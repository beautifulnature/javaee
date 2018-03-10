package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
