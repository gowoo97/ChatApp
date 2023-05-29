package com.gowoo.chatApp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowoo.chatApp.DTO.Participants;
import com.gowoo.chatApp.DTO.Room;
import com.gowoo.chatApp.Repository.ParticipantsRepository;

@Service
public class ParticipantService {
	
	@Autowired
	private ParticipantsRepository repository;
	
	public void participate(Participants p) {
		repository.save(p);
	}
	
	public List<Room> roomList(String userId){
		List<Participants> list=repository.findByUserId(userId);
		List<Room> rooms=new ArrayList<>();
		for(Participants p : list) {
			rooms.add(p.getRoom());
		}
		
		return rooms;
		
	}
	
}
