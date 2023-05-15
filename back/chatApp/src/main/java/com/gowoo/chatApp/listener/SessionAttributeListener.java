package com.gowoo.chatApp.listener;

import java.util.HashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

	HashMap<String,HttpSession> members;//key,session객체
	
	public SessionAttributeListener() {
		this.members=new HashMap<>();
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		HttpSession session=se.getSession();
		String userId=(String) session.getAttribute("userId");
		if(members.containsKey(userId)) {//이미 로그인 된 세션이 있다면
			HttpSession preLoged=members.get(userId);
			preLoged.removeAttribute("userId");//이미 로그인된 세션 종료
		}
		
		members.put(userId, session);
		
		System.out.println("세션 추가됨!");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		
	
		
		System.out.println("세션 제거됨!");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("세션 변경됨!");
	}

}
