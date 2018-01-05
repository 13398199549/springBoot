package org.springstudy.springBoot.service.impl;

import org.springframework.stereotype.Service;
import org.springstudy.springBoot.beans.UserInfo;
import org.springstudy.springBoot.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {

	@Override
	public boolean login(UserInfo user) {
		// TODO Auto-generated method stub
		
		System.out.println(user);
		
		
		return false;
	}

}
