package org.springstudy.springBoot.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springstudy.springBoot.beans.UserInfo;
import org.springstudy.springBoot.pojos.Messager;
import org.springstudy.springBoot.service.IUserService;

@RequestMapping("/users")
@RestController
public class UserController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private IUserService userServiceImpl;
	
	@RequestMapping(value="/{id}",method= {RequestMethod.GET})
	public UserInfo getUserInfobyId(@PathVariable("id") Long id) {
		log.info(id);
		UserInfo user = null;
		try {
			user = userServiceImpl.getUserInfobyId(id);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("UserController------getUserInfobyId()", e);
		}	
		log.info(user);
		return user;
	}
	
	
	
	@RequestMapping(value="/{id}",method= {RequestMethod.DELETE})
	public Messager deleteUserInfo(@PathVariable("id") Long id) {
		log.info(id);
		Messager msg = new Messager(true, "操作成功！");
		try {
			userServiceImpl.deleteUserInfoById(id);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("UserController------deleteUserInfo()", e);
			msg.setStatus(false);
			msg.setInformation("操作失败！");
		}	
		log.info(msg);
		return msg;
	}
	
	@RequestMapping(value="/{id}",method= {RequestMethod.PUT})
	public Messager updateUserInfo(UserInfo user) {
		log.info(user);
		Messager msg = new Messager(true, "操作成功！");
		try {
			userServiceImpl.updateUserInfo(user);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("UserController------updateUserInfo()", e);
			msg.setStatus(false);
			msg.setInformation("操作失败！");
		}	
		log.info(msg);
		return msg;
	}
	
	@RequestMapping(value="/{id}",method= {RequestMethod.POST})
	public Messager saveUserInfo(UserInfo user) {
		log.info(user);
		Messager msg = new Messager(true, "操作成功！");
		try {
			user.setId(null);
			userServiceImpl.saveUserInfo(user);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("UserController------saveUserInfo()", e);
			msg.setStatus(false);
			msg.setInformation("操作失败！");
		}	
		log.info(msg);
		return msg;
	}
	
}
