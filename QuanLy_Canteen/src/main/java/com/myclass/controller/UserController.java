package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.User;
import com.myclass.repository.UserRepository;

@Controller
@RequestMapping("admin/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("")
	public String get(Model model) {
		List<User> users = userRepository.findAll();
		users.remove(0);
		model.addAttribute("users", users);
		
		return "user/index";
	}
}
