package com.airlines.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlines.models.Passenger;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		/* gives access to application context */
		ServletContext sc = this.getServletContext();

		ArrayList<Passenger> pList = (ArrayList<Passenger>)sc.getAttribute("passengers");
		if(pList!=null) {
			String output  = "<ul>";
			for (Passenger passenger : pList) {
				output+="<li>" + passenger.getFirstName() + " " + passenger.getLastName() + " born on " + passenger.getDob() + " Gender " + passenger.getGender() +  "</li>";
			}
			output+="</ul>";
			out.print("Passenger has been added to list<br><a href='/web10/AddPassenger'>Add New Passenger</a><br><h2>Added Passengers</h2>" + output);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
