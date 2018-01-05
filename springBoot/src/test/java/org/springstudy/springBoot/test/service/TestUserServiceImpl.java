package org.springstudy.springBoot.test.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springstudy.springBoot.Application;
import org.springstudy.springBoot.beans.UserInfo;
import org.springstudy.springBoot.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {Application.class})
@WebAppConfiguration// 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
public class TestUserServiceImpl {

	@Resource
	private IUserService userServiceImpl;
	
	@Test
	public void testUpdateUserInfo() {
		UserInfo user = new UserInfo();
		user.setId(2l);		
		user.setPassword("123456");
		user.setLoginName("zl");
		user.setGender(1);
		user.setUserName("张龙");
		userServiceImpl.updateUserInfo(user);
		
	}
	
	@Test
	public void testSaveUserInfo() {
		UserInfo user = new UserInfo();
		user.setPassword("123456");
		user.setLoginName("ls");
		user.setGender(1);
		user.setUserName("李斯");
		userServiceImpl.saveUserInfo(user);
		
	}
	
	
}
