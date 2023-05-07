package com.gowoo.chatApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signUp")
public class SignUpController {
	
	@GetMapping
	public String signUpPage() {
		return "signUp";
	}
}
