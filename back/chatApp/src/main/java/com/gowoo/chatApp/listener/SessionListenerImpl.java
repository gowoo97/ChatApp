package com.gowoo.chatApp.listener;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@WebListener
public class SessionListenerImpl implements HttpSessionListener {
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		System.out.println("세션 생성!"+se.getSession().getId().toString());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		System.out.println("세션 소멸!"+se.getSession().getId().toString());
	}

}
