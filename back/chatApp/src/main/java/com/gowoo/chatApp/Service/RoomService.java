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
	
	public long roomReg(String title) {
		Room room=new Room();
		room.setTitle(title);
		roomRepository.save(room);
		return room.getSeq();
	}
	
	
	public void participate(long user_seq,long room_no) {
		Participants p=new Participants();
		p.setUser_seq(user_seq);
		p.setRoom_no(room_no);
		participants.save(p);
	}
	
}
