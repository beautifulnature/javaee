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

import com.airline.service.FlightService;

/**
 * Servlet implementation class FlightDetails
 * 
 */
@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FlightService fs = null;
	
    public FlightDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("The Flight details has been called..");
		/*how to get a reference to ejb context manually
		 * without using ejb annotation */
		try {
			//JDNI like phone book catalogue for
			//resources on the server (ejb resourses)
			// ! |
			Context context = new InitialContext();
			Object fObj = context.lookup("java:global/ejb5/FlightService!com.airline.service.FlightService");
			fs = (FlightService) fObj;
			
		} catch(NamingException e) {
			System.out.println("Naming Exception");
			e.printStackTrace();
		}
		
		if(fs!=null) {
			//fs.setTo("London");
			out.println("FS NOT NULL");
			out.println("from: " + fs.getFrom());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
