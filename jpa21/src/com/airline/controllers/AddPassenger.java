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
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Passenger  p = new Passenger();
		String fNameString =request.getParameter("first_name"); 
		p.setFirstName(fNameString);
		String lNameString = request.getParameter("last_name");
		p.setLastName(lNameString);
		
		String dob_raw = request.getParameter("dob");
		Calendar cal = Calendar.getInstance();
		String dobParts[] = dob_raw.split("\\/");
		
		cal.set(Calendar.YEAR, Integer.parseInt(dobParts[2]));
		cal.set(Calendar.MONTH, Integer.parseInt(dobParts[0]) - 1 );
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dobParts[1]));
		
		Date dob = cal.getTime();
		p.setDob(dob);
		
		String gender = request.getParameter("gender");
		p.setGender(Gender.valueOf(gender));
		
		//p.setFlightClass(FlightClass.Coach);
		
		System.out.println(p);
		ps.addPassenger(p);
		
		response.sendRedirect("Passengers");
		
	}

}
