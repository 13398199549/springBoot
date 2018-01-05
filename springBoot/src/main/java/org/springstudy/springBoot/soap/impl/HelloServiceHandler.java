package org.springstudy.springBoot.soap.impl;

import javax.jws.WebService;

import org.springframework.stereotype.Component;
import org.springstudy.springBoot.soap.HelloService;

@Component
@WebService(targetNamespace="http://soap.springBoot.springstudy.org",
serviceName="HelloService",
portName="HelloServicePort",
endpointInterface="org.springstudy.springBoot.soap.HelloService")
public class HelloServiceHandler implements HelloService{

	@Override
	public String sayHello(String userName) {
		// TODO Auto-generated method stub
		return "hello,"+userName;
	}

	@Override
	public String login(String loginName, String password) {
		// TODO Auto-generated method stub
		return "welcome,"+loginName;
	}

}
