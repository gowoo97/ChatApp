package com.gowoo.chatApp.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gowoo.chatApp.DTO.Message;
import com.gowoo.chatApp.DTO.Participants;
import com.gowoo.chatApp.DTO.Room;
import com.gowoo.chatApp.Service.FriendService;
import com.gowoo.chatApp.Service.MessageService;
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
	
	@Autowired
	private MessageService messageService;
	
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
		
		Room room = roomService.roomReg(title);//새로운 방 생성
		
		
		participantService.participate(maker,room.getSeq());//방생성자 참여
		
		//p1.setRoom(room);
		
		for(String str: participant) {
			participantService.participate(str,room.getSeq());
		}
	
		return "redirect:/";
	}
	
	
	@GetMapping("/{roomId}")
	public String enterRoom(Model model,@PathVariable("roomId") Long roomId) {
		
		List<Message> messages=messageService.getMessages(roomId);
		
		model.addAttribute("messages", messages);

		return "home";
	}
	
	
}
