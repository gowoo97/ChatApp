package com.gowoo.chatApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
	
	@Autowired
	private SimpMessageSendingOperations smso;
	
	@MessageMapping("/send")
	public void message(String message) {
		smso.convertAndSend("/room/1", message);
	}
}
