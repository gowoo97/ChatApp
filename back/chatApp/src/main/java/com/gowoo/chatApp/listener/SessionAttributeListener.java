package com.gowoo.chatApp.listener;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

	private ConcurrentHashMap<String,HttpSession> members;//key,session객체
	
	
	public SessionAttributeListener(){
		members=new ConcurrentHashMap<String,HttpSession>();
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		
		HttpSession session=se.getSession();
		
		String userId=(String) session.getAttribute("userId");
		if(userId != null&&members.containsKey(userId)) {//이미 로그인 된 세션이 있다면
			HttpSession preLoged=members.get(userId);
			preLoged.invalidate();//이미 로그인된 세션 종료
		}
		
		members.put(userId, session);
		
		System.out.println("세션 추가됨!");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		
		members.remove(se.getValue());
		
		System.out.println("세션 제거됨!");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("세션 변경됨!");
	}

}
