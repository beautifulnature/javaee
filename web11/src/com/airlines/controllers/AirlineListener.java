package com.airlines.controllers;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.*;
import com.airlines.models.*;

/**
 * Application Lifecycle Listener implementation class AirlineListener
 *
 */
@WebListener
public class AirlineListener implements ServletContextListener {

    public AirlineListener() {
    }

    public void contextDestroyed(ServletContextEvent event)  { 
    	
    }

    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext sc = event.getServletContext();
    	ArrayList<Passenger> pList = (ArrayList<Passenger>) sc.getAttribute("passengers");
    	if(pList == null) {
    		System.out.println("no passenger list created yet");
    		pList = new ArrayList<Passenger>();
    		sc.setAttribute("passengers",pList);
    	}
    }
	
}
