package com.tma.ejb.web.model;

import javax.naming.Context;
import javax.naming.NamingException;

public abstract class HelloComponent {
	float value;
	public abstract float getValue(Context context) throws NamingException;
}
