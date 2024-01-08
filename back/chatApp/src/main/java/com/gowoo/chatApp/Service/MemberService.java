package com.gowoo.chatApp.Service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowoo.chatApp.DTO.MemberDTO;
import com.gowoo.chatApp.Repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository repository;
	
	//멤버 저장
	public void insertMember(MemberDTO member) {
	
		repository.save(member);
		
		System.out.println(repository.findById(1L));
		
	}
	
	//아이디 일치 확인
	public MemberDTO login(String id,String pw) {
		
		return repository.findById(id);
	}
	
	public long getMemberSeq(String id) {
		return repository.findById(id).getSeq();
	}
	
	//id로 시작하는 멤버 리스트 조회
	public JSONObject getMemberList(String id) {
		List<MemberDTO> list=repository.findByIdStartingWith(id);
		
		JSONObject obj=new JSONObject();
		JSONArray arr=new JSONArray();
		
		for(MemberDTO member : list) {
			JSONObject objmember=new JSONObject();
			objmember.put("memberId",member.getId());
			arr.put(objmember);			
		}
		
		obj.put("members", arr);
		
		System.out.println(obj);
		return obj;
	}
}
