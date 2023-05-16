package com.gowoo.chatApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gowoo.chatApp.Service.MemberService;

@RequestMapping("/member/{id}")
@RestController
public class MemberListController {
	
	@Autowired
	private MemberService service;
	
	
	@GetMapping
	public String getMmeberList(@PathVariable(name="id") String id) {
		return service.getMemberList(id).toString();
	}
	
}
