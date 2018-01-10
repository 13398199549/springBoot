package org.springstudy.springBoot.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
//	@JmsListener(destination = "queue.myboot")  //监听某一队列
	@JmsListener(destination = "topic.myboot")  //监听某一主题
	public void receiveQueue(String text) { 
		System.out.println("Consumer收到的报文为:"+text);  
	}
	
	
	
	
	
	
	
}
