package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightLocal_ejb8;
import com.airline.service.FlightServiceStatelessBean;

/**
 * Servlet implementation class FlightDetails
 * 
 */
@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(beanName = "flightStateless")
	private FlightLocal_ejb8 fs;
	@EJB(beanName = "flightStateless")
	private FlightLocal_ejb8 fs2;


	@EJB(beanName = "flightStateful")
	private FlightLocal_ejb8 fsStateful;
	@EJB(beanName = "flightStateful")
	private FlightLocal_ejb8 fsStateful2;
	
	
    public FlightDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("The Flight details has been called..");
		
		//stateless//
		
		out.println("Details: " + fs.getFrom() + " to " + fs.getTo());
		
		fs2.setFrom("Paris");
		fs2.setTo("Rome");
		
		out.println("Details: " + fs.getFrom() + " to " + fs.getTo());
	
		//stateful//
		
		out.println("Details stateful with name: " + fsStateful.getFrom() + " to " + fsStateful.getTo());
		
		fsStateful2.setFrom("Paris");
		fsStateful2.setTo("Rome");
		
		out.println("Details stateful with name: " + fsStateful.getFrom() + " to " + fsStateful.getTo());
		out.println("Details stateful with name: " + fsStateful2.getFrom() + " to " + fsStateful2.getTo());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
