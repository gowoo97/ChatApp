package com.gowoo.chatApp.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
	
	@MessageMapping("/send/{id}")
	@SendTo("/room/{id}")
	public String message(String message) throws Exception{
		Thread.sleep(1000);
		return message;
	}
}
