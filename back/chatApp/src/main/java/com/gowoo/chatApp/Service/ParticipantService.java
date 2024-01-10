package com.gowoo.chatApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowoo.chatApp.DTO.MemberDTO;
import com.gowoo.chatApp.DTO.Participants;
import com.gowoo.chatApp.DTO.Room;
import com.gowoo.chatApp.Repository.MemberRepository;
import com.gowoo.chatApp.Repository.ParticipantsRepository;
import com.gowoo.chatApp.Repository.RoomRepository;

@Service
public class ParticipantService {
	
	@Autowired
	private ParticipantsRepository participantsRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	public void participate(String userId,long roomSeq) {
		Participants p=new Participants();
		MemberDTO member = memberRepository.findById(userId);
		Optional<Room> room = roomRepository.findById(roomSeq);
		p.setMember(member);
		p.setRoom(room.get());
		participantsRepository.save(p);
	}
	
	public List<Room> roomList(String userId){
		MemberDTO member = memberRepository.findById(userId);
		List<Participants> list=participantsRepository.findBySeq(member.getSeq());
		List<Room> rooms=new ArrayList<>();
		for(Participants p : list) {
			rooms.add(p.getRoom());
		}
		
		return rooms;
		
	}
	
}
