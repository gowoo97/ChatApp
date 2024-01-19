package com.gowoo.chatApp.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowoo.chatApp.DTO.MemberDTO;
import com.gowoo.chatApp.DTO.Message;
import com.gowoo.chatApp.DTO.Room;
import com.gowoo.chatApp.Repository.MemberRepository;
import com.gowoo.chatApp.Repository.MessageRepository;
import com.gowoo.chatApp.Repository.RoomRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private MemberRepository memberRepsitory;
	
	@Autowired
	private RoomRepository roomRepository;
	
	public Message insertMessage(HashMap<String,Object> map) {
		System.out.println(map);
		
		MemberDTO member = memberRepsitory.findById(map.get("sender").toString());
		
		Optional<Room> room = roomRepository.findById(Long.parseLong(map.get("roomNo").toString()));
		
		
		Message message= new Message();
		message.setSender(member);
		message.setRoom(room.get());
		message.setText(map.get("text").toString());
		
		messageRepository.save(message);
		
		return message;
	}
	
	
	public List<Message> getMessages(Long roomId){
		
		List<Message> messages=messageRepository.findByRoom_Seq(roomId);
		
		return messages;
	}
	
	
	
}
