package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.airline.models.Pilot;

@Stateless
@LocalBean
public class PilotService {

	@PersistenceContext(unitName = "airline")
	EntityManager em;
	
    public PilotService() {
    	
    }
    
    public void addPilot(Pilot p) {
    	
    	em.persist(p);
    }

}
