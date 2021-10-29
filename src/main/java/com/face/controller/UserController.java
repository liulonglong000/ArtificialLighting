package com.face.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.face.common.Page;
import com.face.dto.Result;
import com.face.dto.UserDTO;
import com.face.model.IgcsIparkinfo;
import com.face.model.Session;
import com.face.model.User;
import com.face.service.IUserService;
import com.face.utils.DataConversionUtil;
import com.face.utils.DateUtils;
import com.face.utils.FileUtil;
import com.face.utils.StringUtil;

/*
 * 1、使用@RestController注解Controller，则Controller中的方法无法返回页面，配置的视图解析器不起作用，返回的内容就是Return里的内容
 * 使用@Controller即可
 * 分开写两个控制器
 * 想返回字符串就用RestController
 * 想返回页面就用Controller
 * 2、原因：@RestController注解相当于@ResponseBody和@Controller的结合
 * 3、@ResponseBody，有这个注解的时候返回结果直接写入HTTP response body中，不会被解析为跳转路径。
 * 比如异步请求，希望响应的结果是json数据，那么加上@responsebody后，就会直接返回json数据。
*/


/**
 * 用户相关接口
 */
@Api(tags = "04 用户相关接口", value = "用户相关操作对应的接口")
@RestController
@RequestMapping("/user")
public class UserController extends LoginController {
	private static final Log log = LogFactory.getLog(UserController.class);
	
	@Autowired
	private IUserService userService;

	@PostConstruct
	private void startSessionExpire() {
		new Thread(new SessionThread()).start();
	}

	@PostMapping("/login")
	public Result<String> login(@RequestParam String username, @RequestParam String password) {
		return new Result<>(userService.login(username, password));
	}

	@GetMapping("/logout")
	public Result logout(@RequestParam String token) {
		System.out.println(JSON.toJSONString(getSession()));
		userService.logout(token);
		return new Result();
	}

	@PostMapping("/update_user_password")
	public Result updateUserPassword(@RequestParam String token, @RequestParam String oldPassword,
			@RequestParam String newPassword) {
		Result result = new Result();
		Session session = getSession();
		Integer userId = session.getUserId();
		userService.updateUserPassword(userId, oldPassword, newPassword);
		return result;
	}

	@GetMapping("/user_list")
	public Result queryUserList(@RequestParam String token, @RequestParam String username,
			@RequestParam String truename, @RequestParam String jobnumber, @RequestParam int pageSize,
			@RequestParam int pageIndex) {
		Result result = new Result();
		Page<UserDTO> userPage = userService.queryUserList(username, jobnumber, truename, pageIndex, pageSize);
		result.setData(userPage);
		return result;
	}

	@PostMapping("/delete_user")
	public Result deleteUser(@RequestParam String token, @RequestParam String userIds) {
		Result result = new Result();
		userService.deleteUserByIds(userIds);
		return result;
	}

	@PostMapping("/add_user")
	public Result saveUser(@RequestParam String token, @RequestParam String userInfo) {
		Result result = new Result();
		userService.saveUser(userInfo);
		return result;
	}

	@PostMapping("/update_user")
	public Result updateUser(@RequestParam String token, @RequestParam String userInfo) {
		Result result = new Result();
		userService.updateUser(userInfo);
		return result;
	}

	@PostMapping("/set_camera_to_user")
	public Result setCameraToUser(@RequestParam String token, @RequestParam String cameraids,
			@RequestParam String userIdBySetting) {
		Result result = new Result();
		/*
		 * if(null == userId) { Session session = getSession(); userId =
		 * session.getUserId(); }
		 */
		userService.setCameraToUser(Integer.valueOf(userIdBySetting), cameraids);
		return result;
	}

	class SessionThread implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(60000 * 5);
					userService.deleteExptredSession();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	@ApiOperation(value = "查询用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户名", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userPwd", value = "用户密码", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userRole", value = "用户权限", required = true, paramType = "query", dataType = "String") })
	@PostMapping("/getLoginInfo")
	public void getLoginInfo(HttpServletResponse response, String userId) throws Exception {
		try {
			User info = userService.findUserById(userId);
			if (info == null) {
				returnJsonWithMsg(response, "用户不存在，请重新登录后重试！");
				return;
			}

			JSONArray jArray = new JSONArray();

			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");
			jArray.add(jObj0);

			JSONObject jObj1 = new JSONObject();
			jObj1.put("name", StringUtil.getStringNotNull(info.getTruename()));
			jObj1.put("phone", StringUtil.getStringNotNull(info.getPhone()));
			jObj1.put("picPath", StringUtil.getStringForDL(info.getLogoAddr()));
			jArray.add(jObj1);
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getLoginInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "查询用户失败（" + e + "）！");
		}
	}	

	@ApiOperation(value = "修改姓名")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "用户名", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userName", value = "用户姓名", required = true, paramType = "query", dataType = "String") })	
	@PostMapping("/mdyUserName")
	public void mdyUserName(HttpServletResponse response, String userId, String userName) throws Exception {
		try {
			String msg = userService.mdyUserNameById(userId, userName);
			returnJsonWithMsg(response, msg);
		} catch (Exception e) {
			log.error("mdyUserNameAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "修改姓名失败（" + e + "）！");
		}
	}	

	@ApiOperation(value = "修改联系电话")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "用户名", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userTel", value = "用户电话", required = true, paramType = "query", dataType = "String") })
	@PostMapping("/mdyUserTel")
	public void mdyUserTel(HttpServletResponse response, String userId, String userTel) throws Exception {
		try {
			String msg = userService.mdyUserTelById(userId, userTel);
			returnJsonWithMsg(response, msg);
		} catch (Exception e) {
			log.error("mdyUserTelAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "修改联系电话失败（" + e + "）！");
		}
	}

	@PostMapping("/mdyUserPwd")
	public void mdyUserPwd(HttpServletResponse response, String userId, String userPwdOld, String userPwdNew) throws Exception {
		try {
			String msg = userService.mdyUserPwdById(userId, userPwdOld, userPwdNew);
			returnJsonWithMsg(response, msg);
		} catch (Exception e) {
			log.error("mdyUserPwdAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "修改密码失败（" + e + "）！");
		}
	}

	@ApiOperation(value = "添加用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "用户名", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userName", value = "用户姓名", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userPwd", value = "用户密码", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userRole", value = "用户权限", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parentUserId", value = "上级用户用户名", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parkId", value = "园区id", required = true, paramType = "query", dataType = "String") })
	@PostMapping("/addUser")
	public void addUser(HttpServletResponse response, String userId, String userName, String userPwd, String userRole,
			String parentUserId, String parkId) throws Exception {
		try {
			User info = userService.findUserById(userId);
			if (info != null) {
				returnJsonWithMsg(response, "该用户名已存在！");
				return;
			}

			info = new User();
			info.setUsername(userId);
			info.setTruename(userName);
			info.setPassword(userPwd);
			info.setParentUserId(parentUserId);
			info.setParkId(parkId);
			info.setCreateTime(getCurTimestamp());
			info.setUpdateTime(getCurTimestamp());

			userService.addUserInfo(info, userRole);

			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("addUserAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "添加用户失败（" + e + "）！");
		}
	}

	@ApiOperation(value = "查询用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parentUserId", value = "上级用户用户名", required = true, paramType = "query", dataType = "String") })
	@PostMapping("/queryUserInfo")
	public void queryUserInfo(HttpServletResponse response, String parentUserId) throws Exception {
		try {
			List<User> lstInfo = userService.queryChildUserById(parentUserId);
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");
			JSONArray jArray = new JSONArray();
			jArray.add(jObj0);

			for (User info : lstInfo) {
				JSONObject jObj1 = new JSONObject();
				jObj1.put("userId", info.getUsername());
				jObj1.put("picPath", StringUtil.getStringForDL(info.getLogoAddr()));
				jObj1.put("userName", StringUtil.getStringNotNull(info.getTruename()));
				jObj1.put("phone", StringUtil.getStringNotNull(info.getPhone()));
				jObj1.put("time", DateUtils.getDateStr(info.getCreateTime()));
				jObj1.put("parkInfo", StringUtil.getStringNotNull(info.getParkDesp()));
				jArray.add(jObj1);
			}

			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jArray.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			log.error("queryUserInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "查询用户失败（" + e + "）！");
		}
	}

	
	
	@ApiOperation(value = "重置密码")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "query", dataType = "String") })
	@PostMapping("/resetPassword")
	public void resetPassword(HttpServletResponse response, String userId) throws Exception {
		try {
			String msg = userService.resetPwdById(userId);
			returnJsonWithMsg(response, msg);
		} catch (Exception e) {
			log.error("resetPasswordAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "重置密码失败（" + e + "）！");
		}
	}

	@ApiOperation(value = "获取园区信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "query", dataType = "String") })
	@PostMapping("/getParkInfo")
	public void getParkInfo(HttpServletResponse response, String userId) throws Exception {
		try {
			IgcsIparkinfo info = userService.getParkInfoByUserId(userId);
			if (info == null) {
				returnJsonWithMsg(response, "add");
				return;
			}

			JSONArray jArray = new JSONArray();

			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");
			jArray.add(jObj0);

			JSONObject jObj1 = new JSONObject();
			jObj1.put("id", info.getParkId());
			jObj1.put("name", StringUtil.getStringNotNull(info.getParkName()));
			jObj1.put("addr", StringUtil.getStringNotNull(info.getParkAddr()));
			jObj1.put("area", DataConversionUtil.integerToString(info.getParkArea()));
			jObj1.put("remark", StringUtil.getStringNotNull(info.getRemark()));
			jObj1.put("pic", StringUtil.getStringForDL(info.getParkPic()));
			jArray.add(jObj1);

			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jArray.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			log.error("getParkInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取园区信息失败（" + e + "）！");
		}
	}

	@ApiOperation(value = "获取园区信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parkId", value = "园区id", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parkName", value = "园区名称", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parkArea", value = "占地面积", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parkAddress", value = "园区地址", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parkRemark", value = "备注", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "picSel", value = "用户id", required = true, paramType = "query", dataType = "MultipartFile") })
	@PostMapping("/addParkInfo")
	public void addParkInfo(HttpServletResponse response, String parkId, String userId, String parkName,
			String parkArea, String parkAddress, String parkRemark, MultipartFile picSel) throws Exception {
		try {
			IgcsIparkinfo infoPre = userService.findParkInfoById(parkId);
			if (infoPre != null) {
				returnJsonWithMsg(response, "园区ID已存在，请重新输入！");
				return;
			}

			IgcsIparkinfo info = new IgcsIparkinfo();

			info.setParkId(parkId);
			info.setParkName(parkName);
			info.setParkArea(DataConversionUtil.stringToInteger(parkArea));
			info.setParkAddr(parkAddress);
			info.setRemark(parkRemark);
			info.setUserId(userId);

			if (picSel != null && picSel.getOriginalFilename().length() > 0) {
				String abPath = FileUtil.getUplodFilePath(picSel.getOriginalFilename());
				info.setParkPic(abPath);
				FileUtil.updateFileContent(FileUtil.WORK_PATH + abPath, picSel);
			}

			info.setInDate(getCurTimestamp());

			String ret = userService.addParkInfo(info, userId);

			returnJsonWithMsg(response, ret);
		} catch (Exception e) {
			log.error("addParkInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "添加园区信息失败（" + e + "）！");
		}
	}

	@ApiOperation(value = "修改园区信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parkId", value = "园区id", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parkName", value = "园区名称", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parkArea", value = "占地面积", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parkAddress", value = "园区地址", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parkRemark", value = "备注", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "picSrcFile", value = "园区图片存储位置", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "picSel", value = "用户id", required = true, paramType = "query", dataType = "MultipartFile") })
	@PostMapping("/mdyParkInfo")
	public void mdyParkInfo(HttpServletResponse response, String parkId, String parkName, String parkArea,
			String parkAddress, String parkRemark, MultipartFile picSel, String picSrcFile) throws Exception {
		try {
			IgcsIparkinfo info = userService.findParkInfoById(parkId);
			if (info == null) {
				returnJsonWithMsg(response, "园区ID不存在，请重新登录后重试！");
				return;
			}

			info.setParkName(parkName);
			info.setParkArea(DataConversionUtil.stringToInteger(parkArea));
			info.setParkAddr(parkAddress);
			info.setRemark(parkRemark);
			
			boolean bDel = false;
			String sourcePic = StringUtil.getStringNotNull(info.getParkPic());
			String sourceDLPic = StringUtil.getStringForDL(info.getParkPic());
			if (picSel != null && picSel.getOriginalFilename().length() > 0) {
				String abPath = FileUtil.getUplodFilePath(picSel.getOriginalFilename());
				info.setParkPic(abPath);
				FileUtil.updateFileContent(FileUtil.WORK_PATH + abPath, picSel);

				if (sourcePic.length() > 0) {
					bDel = true;
				}
			} else {
				if (!sourceDLPic.equals(picSrcFile)) {
					info.setParkPic(null);
					bDel = true;
				}
			}			

			String strRet = userService.mdyParkInfo(info);

			if (strRet.equals("success") && bDel) {
				FileUtil.deleteFile(sourcePic);
			}

			returnJsonWithMsg(response, strRet);

		} catch (Exception e) {
			log.error("mdyParkInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "修改园区信息失败（" + e + "）！");
		}
	}

	@ApiOperation(value = "修改用户头像")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "picSrcFile", value = "园区图片存储位置", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "picSel", value = "用户id", required = true, paramType = "query", dataType = "MultipartFile") })
	@PostMapping("/mdyUserPic")
	public void mdyUserPic(HttpServletResponse response, String userId, MultipartFile picSel, String picSrcFile)
			throws Exception {
		try {
			User info = userService.findUserById(userId);
			if (info == null) {
				returnJsonWithMsg(response, "用户ID不存在，请重新登录后重试！");
				return;
			}

			boolean bDel = false;
			String sourcePic = StringUtil.getStringNotNull(info.getLogoAddr());
			String sourceDLPic = StringUtil.getStringForDL(info.getLogoAddr());
			if (picSel != null && picSel.getOriginalFilename().length() > 0) {
				String picSelFileName = picSel.getOriginalFilename();
				String abPath = FileUtil.getUplodFilePath(picSelFileName);
				info.setLogoAddr(abPath);
				FileUtil.updateFileContent(FileUtil.WORK_PATH + abPath, picSel);

				if (sourcePic.length() > 0) {
					bDel = true;
				}
			} else {
				if (!sourceDLPic.equals(picSrcFile)) {
					info.setLogoAddr(null);
					bDel = true;
				}
			}

			userService.mdyUserInfo(info);

			if (bDel) {
				FileUtil.deleteFile(sourcePic);
			}

			JSONArray jArray = new JSONArray();

			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");
			jArray.add(jObj0);

			JSONObject jObj1 = new JSONObject();
			jObj1.put("pic", StringUtil.getStringForDL(info.getLogoAddr()));
			jArray.add(jObj1);

			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jArray.toString());
			response.getWriter().flush();
			response.getWriter().close();

		} catch (Exception e) {
			log.error("mdyUserPicAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "修改用户头像失败（" + e + "）！");
		}
	}

	@PostMapping("/mdySelfInfo")
	public void mdySelfInfo(HttpServletResponse response, String userId, String userRealName, String userMobile, 
			MultipartFile picSel, String picSrcFile) throws Exception {
		try {
			User info = userService.findUserById(userId);
			if (info == null) {
				returnJsonWithMsg(response, "用户ID不存在，请重新登录后重试！");
				return;
			}
			
			info.setTruename(userRealName);
			info.setPhone(userMobile);

			boolean bDel = false;
			String sourcePic = StringUtil.getStringNotNull(info.getLogoAddr());
			String sourceDLPic = StringUtil.getStringForDL(info.getLogoAddr());
			if (picSel != null && picSel.getOriginalFilename().length() > 0) {
				String abPath = FileUtil.getUplodFilePath(picSel.getOriginalFilename());
				info.setLogoAddr(abPath);
				FileUtil.updateFileContent(FileUtil.WORK_PATH + abPath, picSel);

				if (sourcePic.length() > 0) {
					bDel = true;
				}
			} else {
				if (!sourceDLPic.equals(picSrcFile)) {
					info.setLogoAddr(null);
					bDel = true;
				}
			}

			userService.mdyUserInfo(info);

			if (bDel) {
				FileUtil.deleteFile(sourcePic);
			}
			
			returnJsonWithMsg(response, SUCCESS);

		} catch (Exception e) {
			log.error("mdyUserPicAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "修改个人信息失败（" + e + "）！");
		}
	}
}
