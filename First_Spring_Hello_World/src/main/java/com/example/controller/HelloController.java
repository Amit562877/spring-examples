package com.example.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;

@RestController
public class HelloController {
	@RequestMapping("/")
	public ModelAndView getMessage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
		
	}

	@GetMapping("/api/data")
	@ResponseBody
	public String getData(@RequestParam String uname, @RequestParam String psw, @RequestParam String remember,Model model) {
		User u=new User();
		u.setUsername(uname);
		u.setPassword(psw);
		u.setRemember(remember);
		model.addAttribute("User", u);
		return "home";
	}
}
