package org.springstudy.springBoot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springstudy.springBoot.beans.Animal;
import org.springstudy.springBoot.beans.UserInfo;
import org.springstudy.springBoot.configure.Author;
import org.springstudy.springBoot.service.ILoginService;
//import org.springframework.web.bind.annotation.RestController;
//@RestController
@Controller
/**
 * @RestController = @Controller + @ResponseBody
 * @author Administrator
 *
 */
@RequestMapping("/sysmag")
public class LoginController {

	private final Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource
	private Author author;
	
	@Resource
	private ILoginService  loginServiceImpl;
	
	@RequestMapping("/login")
	public String login(Model model,UserInfo user){
		log.info(user);
		loginServiceImpl.login(user);
		
		model.addAttribute("author", author);
		
		log.info(author);
//		return "Hello Spring Boot, " + author;
		return "main";
	}
	
	
	
	@RequestMapping("/hello")
	public ModelAndView hello(String name){
		ModelAndView mv = new ModelAndView();
		List<Animal> animals = new ArrayList<Animal>();
		try {
			Animal animal1 = new Animal("mouser", 12);
			Animal animal2 = (Animal) animal1.clone();
			animal2.setName("python");
			animals.add(animal1);
			animals.add(animal2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("animals", animals);
		mv.addObject("name", name);
		mv.addObject("age", 22);
		mv.setViewName("view/index");
		return mv;
	}
}
