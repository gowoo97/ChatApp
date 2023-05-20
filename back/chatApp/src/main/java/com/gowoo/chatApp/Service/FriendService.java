package com.gowoo.chatApp.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowoo.chatApp.DTO.Friend;
import com.gowoo.chatApp.DTO.FriendShip;
import com.gowoo.chatApp.Repository.FriendShipRepository;

@Service
public class FriendService {
	
	@Autowired
	private FriendShipRepository repository;
	
	//id1이 id2에게 친구 요청
	@Transactional
	public void sendFriendReq(String id1,String id2) {
		
		Friend friend=new Friend();
		friend.setSender(id1);
		friend.setReceiver(id2);
		
		FriendShip friendShip=new FriendShip();
		friendShip.setFriend(friend);
		
		repository.save(friendShip);
	}
	
	//친구요청 수락
	@Transactional
	public void acceptFriendReq(String id1,String id2) {
		
		FriendShip friendShip=repository.findByFriendSenderAndFriendReceiver(id1, id2);
		friendShip.setAccept(true);
	}
	
	@Transactional
	public void deleteFriendReq(String id1,String id2) {
		FriendShip friendShip=repository.findByFriendSenderAndFriendReceiver(id1, id2);
		repository.delete(friendShip);
	}
	
	//리시버를 이용한 친구관계 불러오기
	@Transactional
	public JSONObject getFriendShipByReceiver(String receiver) {
		List<FriendShip> list=repository.findByFriendReceiver(receiver);
		JSONArray arr=new JSONArray();
		for(FriendShip friendShip:list) {
			JSONObject tmp=new JSONObject();
			tmp.put("receiver",friendShip.getFriend().getReceiver());
			tmp.put("sender",friendShip.getFriend().getSender());
			tmp.put("accept",friendShip.isAccept());
			arr.put(tmp);
		}
		
		JSONObject obj=new JSONObject();
		obj.put("friendShip",arr);
		System.out.println("service:"+obj.toString());
		return obj;
	}
	
}
