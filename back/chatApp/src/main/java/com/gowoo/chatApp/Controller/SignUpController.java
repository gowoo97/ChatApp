package com.gowoo.chatApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gowoo.chatApp.DTO.MemberDTO;
import com.gowoo.chatApp.Service.MemberService;

@Controller
@RequestMapping("/signUp")
public class SignUpController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping
	public String signUpPage() {
		return "signUp";
	}
	
	@PostMapping
	public String insertMember(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		
		MemberDTO member=new MemberDTO(id,pw);
		memberService.insertMember(member);
		
		return "redirect:/";
		
	}
}
