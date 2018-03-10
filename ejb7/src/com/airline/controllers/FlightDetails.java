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

import com.airline.service.FlightLocal;
import com.airline.service.FlightRemote;
import com.airline.service.FlightService;

/**
 * Servlet implementation class FlightDetails
 * 
 */
@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FlightLocal fs;

	@EJB
	private FlightRemote fsRemote;
		
    public FlightDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("The Flight details has been called..");
		out.println("Details: " + fs.getFrom() + "  " + fs.getFrom() + " " + fs.getAirplaneModel());
		out.println("Details: Remote: " + fsRemote.getFrom() + "  Remote: " + fsRemote.getFrom() + " Remote: " + fsRemote.getAirplaneModel());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
