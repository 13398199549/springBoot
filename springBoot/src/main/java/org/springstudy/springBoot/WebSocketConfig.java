package org.springstudy.springBoot;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
//注解开启使用STOMP协议来传输基于代理的消息(开启websocket支持)
//此时控制器需要使用@MessageMapping取代@RequestMapping
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

	//主从STOMP协议的节点（endpoint），并映射的指定的URL
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		registry.addEndpoint("/endpointWisely").withSockJS();//注册一个STOMP的endpoint,并指定使用SockJS协议
	}
	
	//配置消息代理（Message Broker）
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// TODO Auto-generated method stub
		registry.enableSimpleBroker("/topic");//给广播模式定义一个/topic消息代理
	}

}
