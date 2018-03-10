package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightLocal_ejb10;
import com.airline.service.FlightServiceStatelessBean;

/**
 * Servlet implementation class FlightDetails
 * 
 */
@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//stateless
	private FlightLocal_ejb10 fs;
	
	//stateful
	private FlightLocal_ejb10 fsStateful;
	
    public FlightDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("The Flight details has been called..");
		try {
			Context context = new InitialContext();
			Object fsObj = context.lookup("java:global/ejb10/flightStateless!com.airline.service.FlightLocal_ejb10");
			fs = (FlightLocal_ejb10) fsObj;
			
			Object fsObjStateful = context.lookup("java:global/ejb10/flightStateful!com.airline.service.FlightLocal_ejb10");
			fsStateful = (FlightLocal_ejb10)  fsObjStateful;
				
		} catch(NamingException e) {
			e.printStackTrace();
		}
		
		// stateless //
		out.println("Details: " + fs.getFrom() + " to " + fs.getTo());
	
		// stateful //
		out.println("Details stateful with name: " + fsStateful.getFrom() + " to " + fsStateful.getTo());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
