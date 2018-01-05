package org.springstudy.springBoot.service;

import org.springstudy.springBoot.beans.UserInfo;

public interface IUserService {

	public int saveUserInfo(UserInfo user);
	public int updateUserInfo(UserInfo user);
	public int deleteUserInfoById(Long id);
	public UserInfo getUserInfobyId(Long id);
	
	
	
	
}
