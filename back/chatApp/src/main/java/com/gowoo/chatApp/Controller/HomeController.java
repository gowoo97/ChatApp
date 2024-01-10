package com.gowoo.chatApp.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gowoo.chatApp.DTO.Room;
import com.gowoo.chatApp.Service.ParticipantService;

@Controller
public class HomeController {

	@Autowired
	private ParticipantService service;
	
	@GetMapping("/")
	public String home(HttpSession session,Model model) {
		String userId=(String)session.getAttribute("userId");
		if(userId != null) {
			List<Room> titles= service.roomList(userId);
			model.addAttribute("titles", titles);
		}
		return "home";
	}
	
	
	
}
