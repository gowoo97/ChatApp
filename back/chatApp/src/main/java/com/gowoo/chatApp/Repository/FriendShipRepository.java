package com.gowoo.chatApp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.gowoo.chatApp.DTO.Friend;
import com.gowoo.chatApp.DTO.FriendShip;

public interface FriendShipRepository extends CrudRepository<FriendShip, Friend> {
	
	
	
}
