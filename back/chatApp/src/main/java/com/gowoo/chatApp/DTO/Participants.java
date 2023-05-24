package com.gowoo.chatApp.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "participants")
public class Participants {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;
	
	private long user_seq;
	
	private long room_no;
	
}
