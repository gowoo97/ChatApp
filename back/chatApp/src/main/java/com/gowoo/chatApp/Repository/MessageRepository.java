package com.gowoo.chatApp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.gowoo.chatApp.DTO.Message;

public interface MessageRepository extends CrudRepository<Message,Long> {

}
