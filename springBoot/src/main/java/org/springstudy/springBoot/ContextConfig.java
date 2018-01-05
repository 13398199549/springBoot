package org.springstudy.springBoot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
/**
 * 配置类取代applicationContext.xml
 * @author Administrator
 *
 */
@Configuration
@ComponentScan(basePackages={"org.springstudy"},
excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value={Controller.class})})

/*@ImportResource({"classpath*:configuration.xml"})
 * Spring Boot框架虽然理论上赞同项目内部全部使用注解，但是实际项目中，难免
 * 有时还是需要配置，采用ImportResource可以实现加载xml配置
 * */
public class ContextConfig {

}
