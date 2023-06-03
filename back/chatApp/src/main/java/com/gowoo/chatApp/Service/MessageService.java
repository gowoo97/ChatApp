package com.gowoo.chatApp.Service;

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
}
