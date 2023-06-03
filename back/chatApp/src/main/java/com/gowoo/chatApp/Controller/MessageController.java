package com.gowoo.chatApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.gowoo.chatApp.DTO.Message;
import com.gowoo.chatApp.Service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService service;
	
	@MessageMapping("/send/{id}")
	@SendTo("/room/{id}")
	public Message message(Message message) throws Exception{
		Thread.sleep(1000);
		
		service.insertMessage(message);
		
		
		return message;
	}
}
