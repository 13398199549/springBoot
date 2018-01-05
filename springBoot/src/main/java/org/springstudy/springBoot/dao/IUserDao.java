package org.springstudy.springBoot.dao;

import org.springstudy.springBoot.beans.UserInfo;

public interface IUserDao {

	public int saveUserInfo(UserInfo user);
	public int updateUserInfo(UserInfo user);
	public int deleteUserInfoById(Long id);
	public UserInfo getUserInfobyId(Long id);
}
