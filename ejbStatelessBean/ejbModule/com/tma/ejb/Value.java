package com.tma.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class Value
 */
@Stateful
@LocalBean
public class Value implements ValueRemote {
	private Number value;
    /**
     * Default constructor. 
     */
    public Value() {
    	this.value = 42;
    }

	@Override
	public Number getValue() {
		System.out.println("Return number: " + this.value.toString());
		return this.value;
	}

	@Override
	public void setValue(Number val) {
		System.out.println("Set value to " + val.toString());
		this.value = val;
	}

}
