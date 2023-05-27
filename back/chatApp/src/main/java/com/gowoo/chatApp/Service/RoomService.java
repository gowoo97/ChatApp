package com.gowoo.chatApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowoo.chatApp.DTO.Participants;
import com.gowoo.chatApp.DTO.Room;
import com.gowoo.chatApp.Repository.ParticipantsRepository;
import com.gowoo.chatApp.Repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	public Room roomReg(String title) {
		Room room=new Room();
		room.setTitle(title);
		roomRepository.save(room);
		return room;
	}
	
	
}
