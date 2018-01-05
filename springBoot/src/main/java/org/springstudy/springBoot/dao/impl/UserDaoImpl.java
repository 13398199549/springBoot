package org.springstudy.springBoot.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springstudy.springBoot.beans.UserInfo;
import org.springstudy.springBoot.dao.IUserDao;
import org.springstudy.springBoot.mapper.UserMapper;

@Repository
public class UserDaoImpl implements IUserDao {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public int saveUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		return userMapper.saveUserInfo(user);
	}

	@Override
	public int updateUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		return userMapper.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfoById(Long id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUserInfoById(id);
	}

	@Override
	public UserInfo getUserInfobyId(Long id) {
		// TODO Auto-generated method stub
		return userMapper.getUserInfobyId(id);
	}

}
