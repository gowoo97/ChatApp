package com.gowoo.chatApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gowoo.chatApp.Service.MemberService;


@RestController("/member/{id}")
public class MemberListController {
	
	@Autowired
	private MemberService service;
	
	
	@GetMapping
	public String getMmeberList(@PathVariable(name="id") String id) {
		
		return "hello";
	}
	
}
