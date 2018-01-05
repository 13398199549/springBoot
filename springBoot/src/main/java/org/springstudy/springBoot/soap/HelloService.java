package org.springstudy.springBoot.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace="http://soap.springBoot.springstudy.org")
public interface HelloService {

	@WebMethod(operationName="hello")
	public String sayHello(@WebParam(name="arg0")String userName);
	
	@WebMethod
	public String login(@WebParam(name="arg0")String loginName,@WebParam(name="arg1")String password);
	
	
	
}
