package com.gowoo.chatApp.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout.do")
public class LogoutController {
	
	@GetMapping
	public String logout(HttpSession session,HttpServletResponse resp) {
		
		Cookie cookie=new Cookie("sessionId",null);
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		
		session.removeAttribute("userId");
		session.invalidate();
		return "redirect:/";
	}
	
	
}
