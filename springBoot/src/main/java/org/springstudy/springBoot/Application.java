package org.springstudy.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 程序的主入口
 * @author Administrator
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//将ContextConfig配置类内容，加入到spring容器中
		SpringApplication.run(ContextConfig.class, args);
	}
}
