package com.gowoo.chatApp.DTO;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;



import lombok.Data;


@Entity
@Table(name = "friendShip")
public class FriendShip {
	
	@EmbeddedId
	private Friend friend;
	
	@Column(name="accept")
	private boolean accept;

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}
	
}
