package com.face.service;

import com.face.common.Page;
import com.face.dto.UserDTO;
import com.face.model.Session;
import com.face.model.IgcsIparkinfo;
import com.face.model.User;

import java.util.List;

public interface IUserService {
    String login(String username, String password);
    void logout(String token);
    void deleteExptredSession();
    void updateUserPassword(Integer userId, String oldPassword, String newPassword);
    Page<UserDTO> queryUserList(String userName,String jobnumber,String truename, int pageIndex, int pageSize);
    int deleteUserByIds(String userids);
    void saveUser(String userinfo);
    void updateUser(String userinfo);
    void setCameraToUser(int userId, String cameraIds);
    List<User> getUserListByAccount(String account);
    
    Session checkLogin(String userId, String userPwd) throws Exception;

	String mdyUserNameById(String userId, String userName) throws Exception;

	void addUserInfo(User userInfo, String userRole) throws Exception;

	List<User> queryChildUserById(String parentUserId) throws Exception;

	String resetPwdById(String userId) throws Exception;

	IgcsIparkinfo getParkInfoByUserId(String userId) throws Exception;

	IgcsIparkinfo findParkInfoById(String parkId) throws Exception;

	String addParkInfo(IgcsIparkinfo parkInfo, String userId) throws Exception;

	String mdyParkInfo(IgcsIparkinfo info) throws Exception;

	void mdyUserInfo(User info) throws Exception;

	String mdyUserTelById(String userId, String userTel) throws Exception;
	
	String mdyUserPwdById(String userId, String userPwdOld, String userPwdNew) throws Exception;
	
	User findUserById(String userId) throws Exception;
	
	String getRoleNameById(Integer roleId) throws Exception;
}
