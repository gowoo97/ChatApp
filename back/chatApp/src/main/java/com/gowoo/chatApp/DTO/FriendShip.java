package com.gowoo.chatApp.DTO;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name = "friendShip")
public class FriendShip {
	
	@EmbeddedId
	private Friend friend;
	
	@Column(name="accept")
	private boolean accept;
	
}
