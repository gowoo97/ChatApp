package com.gowoo.chatApp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gowoo.chatApp.DTO.MemberDTO;

public interface MemberRepository extends CrudRepository<MemberDTO, Long> {

	public MemberDTO findById(String id);
	
	public List<MemberDTO> findByIdStartingWith(@Param("id") String id);
}
