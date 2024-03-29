package com.gowoo.chatApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gowoo.chatApp.Service.FriendService;

@RequestMapping("/friendShip")
@RestController
public class FriendShipController {

	@Autowired
	private FriendService service;
	
	//id1이 id2에게 친구요청
	@PostMapping("/{id1}/{id2}")
	public void sendFriendReq(@PathVariable("id1") String id1,@PathVariable("id2") String id2) {
		
		service.sendFriendReq(id1,id2);
	}
	
	//요청 확인
	@PutMapping("/{id1}/{id2}")
	public void acceptReq(@PathVariable("id1") String id1,@PathVariable("id2") String id2) {
		service.acceptFriendReq(id1, id2);
	}
	
	//친구 해지
	@DeleteMapping("/{id1}/{id2}")
	public void deleteReq(@PathVariable("id1") String id1,@PathVariable("id2") String id2) {
		service.deleteFriendReq(id1, id2);
	}
	
	
	@GetMapping("/receiver/{id}")
	public String getFriendShipByReceiver(@PathVariable("id") String id) {
		
		return service.getFriendShipByReceiver(id).toString();
	}
	
	
}
