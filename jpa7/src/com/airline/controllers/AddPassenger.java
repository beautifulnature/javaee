package com.airline.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.FlightClass;
import com.airline.models.Gender;
import com.airline.models.Passenger;
import com.airline.service.PassengerService;

@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
    PassengerService ps;   
    
	public AddPassenger() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Passenger  p = new Passenger();
		p.setFirstName("janne");
		p.setLastName("kallio");
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 1968);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DAY_OF_MONTH, 10);
		Date dob = cal.getTime();
		p.setDob(dob);
		
		p.setGender(Gender.Male);
		
		p.setFlightClass(FlightClass.Coach);
		System.out.println(p);
		ps.addPassenger(p);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
