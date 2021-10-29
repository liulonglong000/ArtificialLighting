package com.face.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.face.common.FaceConstants;
import com.face.common.FaceException;
import com.face.common.Page;
import com.face.common.ResultCode;
import com.face.dto.UserDTO;
import com.face.log.SystemServiceLog;
import com.face.mapper.IgcsIparkinfoMapper;
import com.face.mapper.RoleMapper;
import com.face.mapper.UserCameraMapper;
import com.face.mapper.UserMapper;
import com.face.mapper.UserMenuMapper;
import com.face.model.*;
import com.face.service.ISessionService;
import com.face.service.IUserService;
import com.face.utils.IdUtil;
import com.face.utils.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMenuMapper userMenuMapper;

    @Autowired
    private UserCameraMapper userCameraMapper;

    @Autowired
    private ISessionService sessionService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
 	private IgcsIparkinfoMapper parkinfoDAO;

    @SystemServiceLog(description = "用户登录",
                       moduleName = "用户管理",
                       operateType = "登录日志")
    @Override
    public String login(String username, String password) {
        // 校验用户名、密码是否正确
        User user = getUser(username, password);
        if (null == user) {
            throw new FaceException(ResultCode.USERNAME_PASSWORD_ERR);
        }
        // 剔除旧Session TODO 后续可考虑定时清理过期Session
        Session session = sessionService.getSessionByUserId(user.getId());
        if (null != session) {
            sessionService.deleteSession(session.getToken());
        }
        // 生成新Session
        String token = IdUtil.createId();
        session = new Session(token, user);
        sessionService.addSession(session);
        return token;
    }

    @Override
    public void logout(String token) {
        sessionService.deleteSession(token);
    }

    @Override
    public void deleteExptredSession() {
        Date expireTime = getExpireTime(FaceConstants.SESSION_EXPIRE);
        sessionService.deleteExpireSession(expireTime);
    }

    /*@SystemServiceLog(description = "修改密码",
                      moduleName = "用户模块")*/
    @Override
    public void updateUserPassword(Integer userId, String oldPassword, String newPassword) {
        // 校验用户名、旧密码是否正确

        User user = userMapper.selectByPrimaryKey(userId);
        if(null == user || !oldPassword.equals(user.getPassword())) {
            throw new FaceException(ResultCode.OLD_PASSWORD_ERROR);
        }
        User newUser = new User();
        newUser.setPassword(newPassword);
        newUser.setUpdateTime(new Date());
        newUser.setId(user.getId());

        userMapper.updatePassword(newUser);
    }

    @Override
    public Page<UserDTO> queryUserList(String userName,String jobnumber,String truename, int pageIndex, int pageSize) {
        User user = new User();
        user.setUsername(userName);
        user.setTruename(truename);
        user.setJobnumber(jobnumber);
        List<UserDTO> userList = userMapper.queryUserList(user);
        Page<UserDTO> policePage = new Page<>(pageIndex, pageSize, userList.size(), userList, false);
        return policePage;
    }


    @Override
    public int deleteUserByIds(String userids) {
        String[] useridArray = userids.split(",");
        for (String userid : useridArray) {
            UserExample userExample = new UserExample();
            UserExample.Criteria userExampleCriteria = userExample.createCriteria();
            userExampleCriteria.andIdEqualTo(Integer.parseInt(userid));
            User user = new User();
            user.setStatus(1);
            userMapper.updateByExampleSelective(user, userExample);
        }
        return 0;
    }

    @SystemServiceLog(description = "新增用户",
                      moduleName = "用户管理")
    @Override
    public void saveUser(String userinfo) {
        User user = JSONObject.parseObject(userinfo, User.class);
        List<User> userList = getUserListByAccount(user.getUsername());
        if(null != userList && userList.size() > 0) {
            throw new FaceException(ResultCode.USER_DUPLICATE_ERR);
        }
        user.setPassword("666666");
        user.setStatus(0);
        user.setCreateTime(new Date());
        userMapper.insert(user);

        UserMenu userMenu = new UserMenu();
        userMenu.setUserId(user.getId());
        userMenu.setUserMenu(user.getRole().toString());
        userMenuMapper.insert(userMenu);
    }

    @SystemServiceLog(description = "编辑用户",
                      moduleName = "用户管理")
    @Override
    public void updateUser(String userinfo) {
        User user = JSONObject.parseObject(userinfo, User.class);
        userMapper.updateByPrimaryKeySelective(user);

        UserMenu userMenu = new UserMenu();
        userMenu.setUserMenu(user.getRole().toString());

        UserMenuExample userMenuExample = new UserMenuExample();
        UserMenuExample.Criteria userMenuExampleCriteria = userMenuExample.createCriteria();
        userMenuExampleCriteria.andUserIdEqualTo(user.getId());
        userMenuMapper.updateByExampleSelective(userMenu, userMenuExample);
    }

    @Override
    public void setCameraToUser(int userId, String cameraIds) {
        UserCameraExample userCameraExample = new UserCameraExample();
        UserCameraExample.Criteria userCameraExampleCriteria = userCameraExample.createCriteria();
        userCameraExampleCriteria.andUserIdEqualTo(userId);
        List<UserCamera> userCameras = userCameraMapper.selectByExample(userCameraExample);

        UserCamera userCamera = new UserCamera();
        userCamera.setUserId(userId);
        userCamera.setCameraIds(cameraIds);

        if(CollectionUtils.isEmpty(userCameras)) {
            userCameraMapper.insert(userCamera);
        } else {
            UserCamera userCameraDB = userCameras.get(0);
            userCamera.setId(userCameraDB.getId());
            userCameraMapper.updateByPrimaryKey(userCamera);
        }
    }

    @Override
    public List<User> getUserListByAccount(String account) {
        UserExample userExample = new UserExample();
        UserExample.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andUsernameEqualTo(account);
        return userMapper.selectByExample(userExample);
    }

    private Date getExpireTime(int pastSecond) {
        long currentTime = System.currentTimeMillis();
        long expireTime = currentTime - pastSecond * 1000;
        return new Date(expireTime);
    }

    private User getUser(String username, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(example);
        if (null == userList || userList.isEmpty()) {
            return null;
        }
        return userList.get(0);
    }
    

	@Override
	public Session checkLogin(String userId, String userPwd) throws Exception {
		User user = findUserById(userId);
        if (user == null) {
        	throw new RuntimeException("您输入的用户名不存在！");
		}		

		if (!userPwd.equals(user.getPassword())) {
			throw new RuntimeException("您输入的密码错误！");
		}
		
		Role r = roleMapper.selectByPrimaryKey(user.getRole());

        // 剔除旧Session TODO 后续可考虑定时清理过期Session
        Session session = sessionService.getSessionByUserId(user.getId());
        if (null != session) {
            sessionService.deleteSession(session.getToken());
        }
        
        // 生成新Session
        String token = IdUtil.createId();
        session = new Session(token, user, r.getRoleName());
        sessionService.addSession(session);
        return session;
	}	
	
	@Override
	public String getRoleNameById(Integer roleId) throws Exception {
		Role r = roleMapper.selectByPrimaryKey(roleId);
		if (r == null) {
			return null;
		}
		return r.getRoleName();
	}

	@Override
	public String mdyUserNameById(String userId, String userName) throws Exception {
		User user = findUserById(userId);
        if (user == null) {
        	return "用户不存在，请刷新后重试！";
		}

        user.setTruename(userName);
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		userMapper.updateByPrimaryKey(user);

		return "success";
	}

	@Override
	public void addUserInfo(User userInfo, String userRole) throws Exception {
		userInfo.setRole(findRoleIdByName(userRole));
		userMapper.insert(userInfo);
	}

	@Override
	public List<User> queryChildUserById(String parentUserId) throws Exception {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andParentUserIdEqualTo(parentUserId);
		List<User> userList = userMapper.selectByExample(example);

		for (User info : userList) {
			if (info.getParkId() == null) {
				continue;
			}
			if (info.getParkId().length() == 0) {
				continue;
			}
			IgcsIparkinfo park = parkinfoDAO.selectByPrimaryKey(info.getParkId());
			if (park == null) {
				continue;
			}
			info.setParkDesp(park.getParkName());
		}

		return userList;
	}

	@Override
	public String resetPwdById(String userId) throws Exception {
        User user = findUserById(userId);
        if (user == null) {
        	return "用户不存在，请刷新后重试！";
		}
        
        user.setPassword("123456");
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        userMapper.updateByPrimaryKey(user);
        
        Session session = sessionService.getSessionByUserId(user.getId());
        if (null != session) {
            sessionService.deleteSession(session.getToken());
        }
        
		return "success";
	}

	@Override
	public IgcsIparkinfo getParkInfoByUserId(String userId) throws Exception {
		User user = findUserById(userId);
        if (user == null) {
        	throw new RuntimeException("当前登录用户不存在，请重新登录！");
		} 
        
		if (!StringUtil.notEmpty(user.getParkId())) {
			return null;
		}
		
		IgcsIparkinfo parkInfo = parkinfoDAO.selectByPrimaryKey(user.getParkId());
		if (parkInfo == null) {
			throw new RuntimeException("园区信息不存在，请联系系统管理员！");
		}
		
		return parkInfo;
	}

	@Override
	public IgcsIparkinfo findParkInfoById(String parkId) throws Exception {
		return parkinfoDAO.selectByPrimaryKey(parkId);
	}

	@Override
	@Transactional
	public String addParkInfo(IgcsIparkinfo parkInfo, String userId) throws Exception {
		User user = findUserById(userId);
        if (user == null) {
        	throw new RuntimeException("当前登录用户不存在，请重新登录！");
		}  
		
		parkinfoDAO.insert(parkInfo);
		user.setParkId(parkInfo.getParkId());
		userMapper.updateByPrimaryKey(user);
		
		return "success";
	}

	@Override
	public String mdyParkInfo(IgcsIparkinfo info) throws Exception {
		parkinfoDAO.updateByPrimaryKey(info);
		return "success";
	}
	
	private Integer findRoleIdByName(String name) {
		RoleExample roleExample = new RoleExample();
		RoleExample.Criteria roleExampleExampleCriteria = roleExample.createCriteria();
		roleExampleExampleCriteria.andRoleNameEqualTo(name);
		List<Role> roleList = roleMapper.selectByExample(roleExample);
		if (null == roleList || roleList.isEmpty()) {
			return null;
		}
		
		return roleList.get(0).getId();
	}

	@Override
	public void mdyUserInfo(User info) throws Exception {
		userMapper.updateByPrimaryKey(info);
	}

	@Override
	public String mdyUserTelById(String userId, String userTel) throws Exception {
		User u = findUserById(userId);
        if (u == null) {
        	return "当前登录用户不存在，请重新登录！";
		}
		
        u.setPhone(userTel);
        u.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        userMapper.updateByPrimaryKey(u);
		
		return "success";
	}   
    
    @Override
    public String mdyUserPwdById(String userId, String userPwdOld, String userPwdNew) throws Exception {
        User u = findUserById(userId);
        if (u == null) {
        	return "当前登录用户不存在，请重新登录！";
		}
        
        if (!userPwdOld.equals(u.getPassword())) {
        	return "旧密码不正确，请重新输入！";
        }
        
        u.setPassword(userPwdNew);
        u.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        userMapper.updateByPrimaryKey(u);
		
		return "success";
    }
    
    @Override
    public User findUserById(String userId) throws Exception {
    	UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userId);
        List<User> userList = userMapper.selectByExample(example);
        if (null == userList || userList.isEmpty()) {
        	return null;
		}
		
        return userList.get(0);
    }
}
