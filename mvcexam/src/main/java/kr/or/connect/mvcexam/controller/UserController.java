package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.connect.mvcexam.dto.User;

@Controller
public class UserController {
	@RequestMapping(path = "/userform", method=RequestMethod.GET)
	public String userform() {
		return "userForm";
	}
	
	@RequestMapping(path = "/regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute User user) {
		//ModelAttribute 객체에 담아주는 어노테이션
		System.out.println(user);
		return "regist";
	}
}
