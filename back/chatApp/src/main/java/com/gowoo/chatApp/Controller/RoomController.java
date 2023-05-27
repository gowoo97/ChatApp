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

import com.gowoo.chatApp.DTO.Participants;
import com.gowoo.chatApp.DTO.Room;
import com.gowoo.chatApp.Service.FriendService;
import com.gowoo.chatApp.Service.ParticipantService;
import com.gowoo.chatApp.Service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	
	@Autowired
	private FriendService friendService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private ParticipantService participantService;
	
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
		String maker=(String)session.getAttribute("userId");
		
		Room room = roomService.roomReg(title);
		
		Participants p1=new Participants();
		p1.setUserId(maker);
		p1.setRoomNo(room.getSeq());
		participantService.participate(p1);
		p1.setRoom(room);
		
		for(String str: participant) {
			
			Participants p2=new Participants();
			p2.setUserId(str);
			p2.setRoomNo(room.getSeq());
			p2.setRoom(room);
			participantService.participate(p2);
		}
		
		
		
		return "redirect:/";
	}
	
	
	
}
