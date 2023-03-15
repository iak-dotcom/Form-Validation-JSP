package com.validation.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.validation.entities.User;
import com.validation.services.ValidationServiceImpl;

@Controller
public class VController {
	@Autowired
private	ValidationServiceImpl service;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showForm(Model model) {
	User user = new User();
		model.addAttribute("user", user);
		List<String> professionList = Arrays.asList("Developer", "Designer", "Tester", "Architect");
		model.addAttribute("professionList", professionList);
		return "register_form";
	}
//	The following must be in the same sequence or validation won`t work
	@PostMapping("/register")
	public String submitForm(@Valid @ModelAttribute ("user") User user,
			BindingResult bindingResult, Model model) {
		
List<String> professionList = Arrays.asList("Developer", "Designer", "Tester", "Architect");
			model.addAttribute("professionList", professionList);
			if (bindingResult.hasErrors()) {
			return "register_form";
		}
		service.saveUser(user);
		return "register_success";
	}


}
