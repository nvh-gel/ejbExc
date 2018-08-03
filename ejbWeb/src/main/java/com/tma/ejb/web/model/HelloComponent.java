package com.tma.ejb.web.model;


import javax.naming.Context;
import javax.naming.NamingException;


public interface HelloComponent {
	public float getValue(Context context) throws NamingException;
	
	public void setValue(Context context, float val) throws NamingException;
}
