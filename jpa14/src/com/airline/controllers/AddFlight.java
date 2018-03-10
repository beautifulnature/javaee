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

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.FlightDestinations;
import com.airline.service.FlightService;

/**
 * Servlet implementation class AddFlight
 */
@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	FlightService fs;
	
    public AddFlight() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Flight f = new Flight();
		f.setFlightDestination(FlightDestinations.Los_Angeles);
		f.setFlightOrigin(FlightDestinations.London);
		f.setPrice(1000);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,2018);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 4);
		cal.set(Calendar.HOUR_OF_DAY, 19);
		cal.set(Calendar.MINUTE, 0);
		Date flightTime = cal.getTime();
		System.out.println(flightTime);
		
		f.setFlightTime(flightTime);
		
		Airplane a = new Airplane();
		a.setModelName("797");
		a.setPlaneMake("Boeing");
		a.setSeatingCapacity(200);
		
		f.setAirplaneDetail(a);
		
		System.out.println(f);
		System.out.println(a);
		
		fs.addFlight(f, a);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
