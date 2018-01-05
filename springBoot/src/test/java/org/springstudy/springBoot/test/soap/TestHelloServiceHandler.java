package org.springstudy.springBoot.test.soap;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;
/**
 * SOAP协议的客户端
 * @author Administrator
 *
 */
public class TestHelloServiceHandler {

	@Test
	public void testLogin() {
		
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost/boots/services/HelloService?wsdl");
		
		try {
			Object[] objects = client.invoke("login", "小张","123456");
			System.out.println(objects[0]);//得到返回
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSayHello() {
		
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost/boots/services/HelloService?wsdl");
		
		try {
			 Object[] objects = client.invoke("hello", "小张");
			 System.out.println(objects[0]);//得到返回
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
