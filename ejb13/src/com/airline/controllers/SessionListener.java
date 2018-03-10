package com.airline.controllers;

import javax.ejb.EJB;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.airline.service.CounterStatefulBean;

@WebListener
public class SessionListener implements HttpSessionListener {

	
	@EJB
	CounterStatefulBean cbStateful;
	
    public SessionListener() {
    }

    public void sessionCreated(HttpSessionEvent event)  { 
    	HttpSession s = event.getSession();
    	
    	s.setAttribute("cbStateful", cbStateful);
    	
    	
    	
    }

    public void sessionDestroyed(HttpSessionEvent event)  { 
    	
    	
    	
    }
	
}
