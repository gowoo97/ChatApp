package com.gowoo.chatApp.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gowoo.chatApp.Service.FriendService;
import com.gowoo.chatApp.Service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	
	@Autowired
	private FriendService friendService;
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/reg")
	public String roomSetting(Model model,HttpSession session) {
		
		List<String> list=friendService.getFriends((String)session.getAttribute("userId"));
		
		model.addAttribute("friends", list);
		
		
		
		return "roomSetting";
	}
	
	@PostMapping("/reg")
	public String regRoom(Model model,HttpSession session,HttpServletRequest req) {
		
	
		String participant[]=req.getParameterValues("participant");
		String title=req.getParameter("title");
		
		long roo_seq = roomService.roomReg(title);
		
		for(String str: participant) {
			
			
			
			
			
		}
		
		
		return "redirect:/";
	}
	
	
	
}
