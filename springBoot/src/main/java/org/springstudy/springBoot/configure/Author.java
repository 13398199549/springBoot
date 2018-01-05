package org.springstudy.springBoot.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 将properties文件与JAVA类自动关联
 * @author Administrator
 *
 */
@Component
@ConfigurationProperties(prefix="author")
@PropertySource(value={"classpath:config/author.properties"})
public class Author {
	
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Author [name=" + name + ", age=" + age + "]";
	}
}
