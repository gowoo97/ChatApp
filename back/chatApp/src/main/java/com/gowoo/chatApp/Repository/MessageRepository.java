package com.gowoo.chatApp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gowoo.chatApp.DTO.Message;

public interface MessageRepository extends CrudRepository<Message,Long> {

	public List<Message> findByRoom_Seq(Long roomId);
	
}
