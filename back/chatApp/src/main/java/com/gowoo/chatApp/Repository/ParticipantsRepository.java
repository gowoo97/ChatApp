package com.gowoo.chatApp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gowoo.chatApp.DTO.Participants;

public interface ParticipantsRepository extends CrudRepository<Participants, Long> {

	
	public List<Participants> findBySeq(long seq);
	
}
