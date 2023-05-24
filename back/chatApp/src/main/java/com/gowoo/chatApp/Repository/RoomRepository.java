package com.gowoo.chatApp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.gowoo.chatApp.DTO.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {

}
