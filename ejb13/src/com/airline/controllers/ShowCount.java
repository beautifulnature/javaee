package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.service.CounterBean;
import com.airline.service.CounterStatefulBean; 

@WebServlet("/ShowCount")
public class ShowCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @EJB
    CounterBean cb;
    
    
    public ShowCount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s = request.getSession();
		CounterStatefulBean cbStateful = (CounterStatefulBean)s.getAttribute("cbStateful");
		
		PrintWriter out = response.getWriter();
		out.println("The count value (Singleton Bean): " 	+ cb.getCount());
		out.println("The count value (Stateful Bean): " 	+ cbStateful.getCount());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
