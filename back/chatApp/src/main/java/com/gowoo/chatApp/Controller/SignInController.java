package com.gowoo.chatApp.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gowoo.chatApp.DTO.MemberDTO;
import com.gowoo.chatApp.Service.MemberService;

@Controller
@RequestMapping("/signIn")
public class SignInController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping
	public String signInPage() {
		
		return "signIn";
	}
	
	
	
	@PostMapping
	public String signIn(String id,String pw,HttpSession session,HttpServletResponse res,HttpServletRequest req,
			 String sessionCookie,Model model) {
		MemberDTO rst=service.login(id, pw);
		//아이디가 존재하지 않을때.
		if(rst==null) {
			model.addAttribute("msg","로그인 실패");
			model.addAttribute("url","/signIn");
			return "alert";
		}
		
		
	
		//로그인 안되어 있음
		req.getSession().setAttribute("userId", rst.getId());
		
		
		
		return "redirect:/";
	}
	
}
