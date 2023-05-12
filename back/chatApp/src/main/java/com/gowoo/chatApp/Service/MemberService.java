package com.gowoo.chatApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowoo.chatApp.DTO.MemberDTO;
import com.gowoo.chatApp.Repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository repository;
	
	public void insertMember(MemberDTO member) {
	
		repository.save(member);
		
		System.out.println(repository.findById(1L));
		
	}
	
	public MemberDTO login(String id,String pw) {
		
		return repository.findById(id);
	}
}
