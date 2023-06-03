package com.gowoo.chatApp.DTO;

import java.sql.Timestamp;

import java.sql.Timestamp;

import java.sql.Timestamp;

import java.sql.Timestamp;

import java.sql.Timestamp;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "message")
public class Message {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	
	
	private String sender;
	
	private String text;
	
	private Long roomNo;
	
	@CreationTimestamp
	private Timestamp createdDate;
	
	
}
