package com.gowoo.chatApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowoo.chatApp.DTO.Message;
import com.gowoo.chatApp.Repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository repository;
	
	public void insertMessage(Message message) {
		System.out.println(message);
		repository.save(message);
	}
	
	
	public List<Message> getMessages(Long roomId){
		
		List<Message> messages=repository.findByRoomNo(roomId);
		
		return messages;
		
	}
	
	
	
}
