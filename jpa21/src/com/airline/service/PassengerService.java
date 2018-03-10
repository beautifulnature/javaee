package com.airline.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.airline.models.Passenger;

@Stateless
@LocalBean
public class PassengerService {

    public PassengerService() {
    }
    
    @PersistenceContext(unitName="airline")
    private EntityManager em;
    
    public void addPassenger(Passenger p) {
    	em.persist(p);
    }
    
    public List<Passenger> getPassengers() {
    	
    	TypedQuery<Passenger> query = em.createQuery("SELECT p FROM Passenger p",Passenger.class);
    	List<Passenger> pList = query.getResultList();
    	
    	return pList;
    }
    
    public void addFlightTicketToPassenger(String flightId, String passengerId) {
    	
    }
}
