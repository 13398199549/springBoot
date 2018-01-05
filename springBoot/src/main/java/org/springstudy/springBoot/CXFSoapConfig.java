package org.springstudy.springBoot;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springstudy.springBoot.soap.HelloService;

@Configuration
public class CXFSoapConfig {

	@Autowired
	private Bus bus;

	@Resource
	private HelloService helloServiceHandler;

	/**
	 * 发布接口
	 * @return
	 */
	@Bean
	public Endpoint endpoint() {
		//发布后，可以采用 http://localhost/boots/services/ 查看
		EndpointImpl endpoint = new EndpointImpl(bus, helloServiceHandler);
		endpoint.publish("/HelloService");// 接口发布在 /NetbarServices 目录下
		return endpoint;
	}

}
