package org.springstudy.springBoot.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springstudy.springBoot.pojos.WiselyMessage;
import org.springstudy.springBoot.pojos.WiselyResponse;
/**
 * Websocket 发布订阅模式
 * @author Administrator
 *
 */
@Controller
public class Wsp2sController {

	@MessageMapping("/accept")// 约等于 @RequestMapping
	@SendTo("/topic/getResponse")//当服务器收到消息时，会对订阅了@SendTo中的路径的浏览器发送消息
	public WiselyResponse say(WiselyMessage msg) throws Exception {
		System.out.println(msg);
		Thread.sleep(2000);
		return new WiselyResponse(msg.getInformation());
	}
	
}
