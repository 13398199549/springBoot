package org.springstudy.springBoot.test.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.junit.Test;
import org.springstudy.springBoot.pojos.Customer;
import org.springstudy.springBoot.utils.JAXBTools;
/**
 * CXF 版Rest WebService 客户端
 * @author Administrator
 *
 */
public class Client {

	@Test
	public void deleteCustomerInfo() {
		// TODO Auto-generated method stub
		Customer customer = getCustomerById(1L);
		if(customer == null){
			return;
		}
		
		DeleteMethod delete = new DeleteMethod("http://localhost/boots/services/RestSimple/customers/"+1l);
		setMethodHeaders(delete);
		try {
			handleHttpMethod(delete);
			
			System.out.println(delete.getResponseBodyAsString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			delete.releaseConnection();
		}
	}

	
	
	@Test
	public void updateCustomerInfo() {
		// TODO Auto-generated method stub
		Customer customer = getCustomerById(1L);
		
		PutMethod put = new PutMethod("http://localhost/boots/services/RestSimple/customers/"+1l);
		setMethodHeaders(put);
		
		customer.setName("真强");
		try {
			
			String xmls = JAXBTools.java2Xml(Customer.class, customer);
			
			System.out.println(xmls);
			RequestEntity entity = new InputStreamRequestEntity(new ByteArrayInputStream(xmls.getBytes("UTF-8")));
			put.setRequestEntity(entity);
			
			handleHttpMethod(put);
			
			
			System.out.println(put.getResponseBodyAsString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			put.releaseConnection();
		}
	}

	
	@Test
	public void addCustomerInfo() {
		// TODO Auto-generated method stub
		PostMethod post = new PostMethod("http://localhost/boots/services/RestSimple/customers/-1");
		setMethodHeaders(post);
		
		Customer cus = new Customer(2L,"浩哥","123456");
		try {
			String xmls = JAXBTools.java2Xml(Customer.class, cus);
			RequestEntity entity = new InputStreamRequestEntity(new ByteArrayInputStream(xmls.getBytes("UTF-8")));
			post.setRequestEntity(entity);
			
			
			handleHttpMethod(post);
			
			System.out.println(post.getResponseBodyAsString());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			post.releaseConnection();
		}
		
		
	}

	/**
	 * GET方式获取数据
	 */
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		GetMethod get = new GetMethod("http://localhost/boots/services/RestSimple/customers/"+id);
		setMethodHeaders(get);
		handleHttpMethod(get);
		Customer customer = null;
		try {
			String str = get.getResponseBodyAsString();//返回的是XML格式的字符串
			
			System.out.println(str);
			
			try {
				//将返回的字符串，转换为JAVA类
				customer = (Customer) JAXBTools.xml2Java(Customer.class, str);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			get.releaseConnection();
		}
		return customer;
	}
	
	/**
	 * 用于执行Http请求
	 * @param get
	 */
	private static void handleHttpMethod(HttpMethod method) {
		// TODO Auto-generated method stub
		HttpClient client = new HttpClient();
		int ret = 0;
		
		try {
			ret = client.executeMethod(method);
			Response.Status status = Response.Status.fromStatusCode(ret);
			//当返回等于200时
			if(status == Response.Status.OK){
				System.out.println("Authorication true");
			}else if(status == Response.Status.FORBIDDEN){
				System.out.println("Authorication failure");
			}
			
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 设置HTTP的请求头
	 */
	public static void setMethodHeaders(HttpMethod method){
		if(method instanceof PostMethod || method instanceof PutMethod) {
			method.setRequestHeader("Content-Type", "application/xml;charset=UTF-8");
		}
		method.setRequestHeader("Accept", "application/xml;charset=UTF-8");
		//e10adc3949ba59abbe56e057f20f883e 用户登录时，服务器发给客户端用于保持状态的令牌信息
		method.setRequestHeader("Authorication", "e10adc3949ba59abbe56e057f20f883e");
	}
	
}
