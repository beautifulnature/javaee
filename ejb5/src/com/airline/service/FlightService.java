package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class FlightService
 * annotations makes the class ejb
 * LocalBean local access from the same application
 * Stateless bean ejb how it works?
 * - container may have multiple ejb objects in pool
 * - 10 objects f.ex in its pool
 * - refers to 5th obj in the pool
 * - stateless bean setFrom, setPrice, setX 
 * - we might be working with various ejb beans
 * - 1. time 3 bean, 2. time 4 bean etc
 * - 
 * 
*/
@Stateless
@LocalBean
public class FlightService {

	private Integer id = 23499922;
    private String from = "Los Angeles";
    private String to = "London";
    private Integer price = 400;
    private Integer numOfSeats = 250;
    private String airplaneModel = "Boeing 879";
    
    public FlightService() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(Integer numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public String getAirplaneModel() {
		return airplaneModel;
	}

	public void setAirplaneModel(String airplaneModel) {
		this.airplaneModel = airplaneModel;
	}
	
    @Override
	public String toString() {
		return "FlightService [id=" + id + ", from=" + from + ", to=" + to + ", price=" + price + ", numOfSeats="
				+ numOfSeats + ", airplaneModel=" + airplaneModel + "]";
	}


}