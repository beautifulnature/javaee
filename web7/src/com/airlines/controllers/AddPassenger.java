package com.airlines.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddPassenger() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("errors", false);
		
		String firstName = request.getParameter("first-name");
		if(firstName.length() == 0) {
			System.out.println("empty first name");
			request.setAttribute("errors", true);
			request.setAttribute("firstname_error",true);
		}
		
		String lastName = request.getParameter("last-name");
		if(lastName.length() == 0) {
			System.out.println("empty first name");
			request.setAttribute("errors", true);
			request.setAttribute("lastname_error",true);
		}
		
		//10.4.1938
		String pattern = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(request.getParameter("dob"));
		String dobStr[] = request.getParameter("dob").split("\\/");
		
		if(m.find()) {
			System.out.println("match found");
			String mm = dobStr[0];
			String day = dobStr[1];
			String year = dobStr[2];
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(year));
			cal.set(Calendar.MONTH, Integer.parseInt(mm));
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
			Date dob = cal.getTime();
		} else {
			System.out.println("match not found");
			request.setAttribute("errors", true);
			request.setAttribute("date_format_error",true);
		}
		
		String gender = request.getParameter("gender");
		System.out.println(firstName + " " +  lastName + " " + gender + "error: " + request.getAttribute("errors"));
	}
}
