package com.tma.ejb.web.model;

import static com.tma.ejb.web.utils.EJBUtils.getLookupStr;

import javax.naming.Context;
import javax.naming.NamingException;

import com.tma.ejb.server.business.ValueHolder;


public class BaseComp implements HelloComponent {
	private String module;

	public BaseComp() {
		this.module = "ejbServer";
	}

	@Override
	public void setValue(Context context, float val) throws NamingException {
		ValueHolder valueIf = (ValueHolder) context.lookup(getLookupStr(module, ValueHolder.class));
		valueIf.setValue(val);
	}

	@Override
	public float getValue(Context context) throws NamingException {
		ValueHolder valueIf = (ValueHolder) context.lookup(getLookupStr(module, ValueHolder.class));
		return valueIf.getValue();
	}
}
