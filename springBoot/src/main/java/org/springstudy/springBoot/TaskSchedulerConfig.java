package org.springstudy.springBoot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("org.springstudy.springBoot.task")
@EnableScheduling//开启对计划任务的支持
public class TaskSchedulerConfig {
	
}
