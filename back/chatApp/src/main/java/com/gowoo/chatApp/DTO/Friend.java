package com.gowoo.chatApp.DTO;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Embeddable
@RequiredArgsConstructor
public class Friend implements Serializable{
	

	private String sender;
	

	private String receiver;


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getReceiver() {
		return receiver;
	}


	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
}