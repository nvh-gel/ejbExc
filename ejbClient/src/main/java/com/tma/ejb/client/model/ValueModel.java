package com.tma.ejb.client.model;

import javax.naming.Context;
import javax.naming.NamingException;

import com.tma.ejb.client.utils.EJBUtils;
import com.tma.ejb.server.business.ValueHolder;

public class ValueModel {
	private String module;
	private ValueHolder holder;
	
	public ValueModel(Context context) {
		module = "ejbServer";
		try {
			holder = (ValueHolder) context.lookup(EJBUtils.getLookupStr(module, ValueHolder.class));
		} catch (NamingException e) {
			holder = null;
		}
	}
	
	public float getValue() throws NamingException {
		return holder.getValue();
	}

	public void setValue(float val) throws NamingException {
		holder.setValue(val);
	}
}
