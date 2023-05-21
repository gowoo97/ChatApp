package com.gowoo.chatApp.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gowoo.chatApp.DTO.FriendShip;
import com.gowoo.chatApp.Service.FriendService;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	
	@Autowired
	private FriendService service;
	
	@GetMapping("/reg")
	public String roomSetting(Model model,HttpSession session) {
		
		List<String> list=service.getFriends((String)session.getAttribute("userId"));
		
		model.addAttribute("friends", list);
		
		
		return "roomSetting";
	}
	
	
	
}
