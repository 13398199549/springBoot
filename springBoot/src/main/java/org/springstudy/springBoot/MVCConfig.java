package org.springstudy.springBoot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
//@EnableWebMvc 
/**
 * 不需要再去写spring-mvc.xml
 * @EnableWebMvc 将该类定义为一个WEB层的配置类，extends WebMvcConfigurationSupport,
 * 取代spring boot框架WEB层的自动配置;
 * 
 * 如果需要在使用spring boot框架的自动配置功能之外，还需要配置自己的东西，
 * 那么可以extends WebMvcConfigurerAdapter ,且不需要定义@EnableWebMvc
 * @author Administrator
 *
 */
@ComponentScan(basePackages={"org.springstudy"},
excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value={Service.class,Repository.class})},
includeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value={Controller.class})})

/*@ImportResource({"classpath*:configuration.xml"})
 * Spring Boot框架虽然理论上赞同项目内部全部使用注解，但是实际项目中，难免
 * 有时还是需要配置，采用ImportResource可以实现加载xml配置
 * */
public class MVCConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * 配置ViewController,为index.ftl提供快捷的路径映射
	 * 相当于配置路径跳转控制器
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		//指定项目首页（http://localhost/boots/）
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/page/wsp2s").setViewName("wsp2s");
		registry.addViewController("/page/wsp2p").setViewName("wsp2p");
	}
	/**
	 * 配置静态资源路径
	 */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
