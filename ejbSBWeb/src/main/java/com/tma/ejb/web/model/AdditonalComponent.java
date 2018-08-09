package com.tma.ejb.web.model;

import javax.naming.Context;
import javax.naming.NamingException;

public class AdditonalComponent implements HelloComponent {
	protected HelloComponent component;
	protected String module;
	
	public AdditonalComponent(HelloComponent comp) {
		this.component = comp;
	}

	@Override
	public void setValue(Context context, float val) throws NamingException {
		this.component.setValue(context, val);
	}

	@Override
	public float getValue(Context context) throws NamingException {
		return this.component.getValue(context);
	}
	
	
}
