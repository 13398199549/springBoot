package org.springstudy.springBoot.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springstudy.springBoot.beans.UserInfo;
import org.springstudy.springBoot.dao.IUserDao;
import org.springstudy.springBoot.service.IUserService;

@Transactional(readOnly=true)
@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDaoImpl;
	
	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public int saveUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		return userDaoImpl.saveUserInfo(user);
	}

	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public int updateUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		return userDaoImpl.updateUserInfo(user);
	}

	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public int deleteUserInfoById(Long id) {
		// TODO Auto-generated method stub
		return userDaoImpl.deleteUserInfoById(id);
	}

	@Override
	public UserInfo getUserInfobyId(Long id) {
		// TODO Auto-generated method stub
		return userDaoImpl.getUserInfobyId(id);
	}

}
