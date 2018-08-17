package com.tma.ejb.client.model;

import javax.naming.Context;
import javax.naming.NamingException;

import com.tma.ejb.client.utils.EJBUtils;
import com.tma.ejb.server.business.HelloWorld;
import com.tma.ejb.server.business.ValueHolder;

public class HelloEJBModel {
	private String module;
	private HelloWorld hello;
	
	public HelloEJBModel(Context context) {
		this.module = "ejbServer";
		try {
			hello = (HelloWorld) context.lookup(EJBUtils.getLookupStr(module, HelloWorld.class));
		} catch (NamingException e) {
			hello = null;
		}
	}


	public String getMessage() throws NamingException {
		return hello.getMsg();
	}
}
