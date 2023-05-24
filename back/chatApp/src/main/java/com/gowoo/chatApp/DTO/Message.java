package com.gowoo.chatApp.DTO;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "message")
public class Message {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;
	
	private String sender;
	
	private String text;
	
	private long room_no;
	
    private LocalDateTime createdDate;
	
}
