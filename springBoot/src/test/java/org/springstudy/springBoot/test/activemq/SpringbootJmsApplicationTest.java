package org.springstudy.springBoot.test.activemq;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springstudy.springBoot.Application;
import org.springstudy.springBoot.activemq.Producer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {Application.class})
@WebAppConfiguration// 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
public class SpringbootJmsApplicationTest {

	@Resource
	private Producer producer;
	
	@Test
	public void testSendMsg() {
		
//		//点对点（队列模式）
//		Destination destination = new ActiveMQQueue("queue.myboot");
//		for(int i = 0; i < 1000; i ++) {
//			
//			producer.sendMessage(destination, "我发送的消息，你收到了么？这是第：" + i + "条");  
//		}
		
		
		//发布订阅（主题模式）
		Destination destination = new ActiveMQTopic("topic.myboot");
		for(int i = 0; i < 1000; i ++) {
			
			producer.sendMessage(destination, "我发送的消息，你收到了么？这是第：" + i + "条");  
		}
		
	}
	
	
	
}
