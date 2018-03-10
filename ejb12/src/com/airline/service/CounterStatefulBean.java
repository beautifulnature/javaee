package com.airline.service;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class CounterStatefulBean {

	private Integer count = 0;
	public CounterStatefulBean() {}
    public Integer getCount() {
		return count;
	}
    
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public void addOneToCount() {
		this.count++;
	}
}
