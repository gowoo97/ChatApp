package com.gowoo.chatApp.Service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowoo.chatApp.DTO.Participants;
import com.gowoo.chatApp.Repository.ParticipantsRepository;

@Service
public class ParticipantService {
	
	@Autowired
	private ParticipantsRepository repository;
	
	public void participate(Participants p) {
		repository.save(p);
	}
	
	public List<String> roomList(String userId){
		List<Participants> list=repository.findByUserId(userId);
		List<String> titles=new LinkedList<>();
		
		for(Participants p : list) {
			titles.add(p.getRoom().getTitle());
		}
		
		return titles;
		
	}
	
}
