package com.gowoo.chatApp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gowoo.chatApp.DTO.Friend;
import com.gowoo.chatApp.DTO.FriendShip;

public interface FriendShipRepository extends CrudRepository<FriendShip, Friend> {
	
	public List<FriendShip> findByFriendReceiver(String receiver);
	
	public FriendShip findByFriendSenderAndFriendReceiver(String sender,String receiver);
	
}
