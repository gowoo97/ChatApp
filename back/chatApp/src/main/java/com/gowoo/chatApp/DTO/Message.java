package com.gowoo.chatApp.DTO;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "message")
public class Message {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	@ManyToOne
	private MemberDTO sender;
	
	private String text;
	
	@ManyToOne
	private Room room;
	
	@CreationTimestamp
	private Timestamp createdDate;
	
	
	
	
}
