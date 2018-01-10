package org.springstudy.springBoot.activemq;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
/**
 * 消息发布者
 * @author Administrator
 *
 */
@Component
public class Producer {

	@Resource
	private JmsTemplate jmsTemplate;
	
	/**
	 * 
	 * @param destination 发送到的队列或者主题
	 * @param message 具体的消息
	 */
	public void sendMessage(Destination destination, final String message){ 
		jmsTemplate.convertAndSend(destination, message); 
	}
}
