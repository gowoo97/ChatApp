package com.gowoo.chatApp.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

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
