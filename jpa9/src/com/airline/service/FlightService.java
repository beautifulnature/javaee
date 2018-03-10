package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.airline.models.Airplane;
import com.airline.models.Flight;

@Stateless
@LocalBean
public class FlightService {

    public FlightService() {}
    
    @PersistenceContext(unitName = "airline")
    EntityManager em;
    
    public void addFlight(Flight f, Airplane a) {
    	
    	em.persist(f);	
    	em.persist(a);	
    	
    }
    

}
