package com.ssafy.house.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.house.dto.UserDto;
import com.ssafy.house.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		UserDto userDto = service.login(map);
		
		if (userDto != null) {
			session.setAttribute("userDto", userDto);
		} else {
			model.addAttribute("msg", "아이디와 패스워드를 확인해주세요.");
		}
		
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "index";
	}
	
}
