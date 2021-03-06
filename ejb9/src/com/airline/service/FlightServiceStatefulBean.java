package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;


@Stateful(name="flightStateful")
public class FlightServiceStatefulBean implements FlightLocal_ejb8 {

	private Integer id = 23499922;
    private String from = "Los Angeles";
    private String to = "London";
    private Integer price = 400;
    private Integer numOfSeats = 250;
    private String airplaneModel = "Boeing 879";
    
    public FlightServiceStatefulBean() {}

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