package com.gowoo.chatApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowoo.chatApp.DTO.Friend;
import com.gowoo.chatApp.DTO.FriendShip;
import com.gowoo.chatApp.Repository.FriendShipRepository;

@Service
public class FriendService {
	
	@Autowired
	private FriendShipRepository repository;
	
	
	public void sendFriendReq(String id1,String id2) {
		
		Friend friend=new Friend();
		friend.setSender(id1);
		friend.setReceiver(id2);
		
		FriendShip friendShip=new FriendShip();
		friendShip.setFriend(friend);
		
		repository.save(friendShip);
	}
	
}
