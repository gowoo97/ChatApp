package com.gowoo.chatApp.DTO;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Embeddable
@RequiredArgsConstructor
public class Friend implements Serializable{
	

	private String sender;
	

	private String receiver;
	
}