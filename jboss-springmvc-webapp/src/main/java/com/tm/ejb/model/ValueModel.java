package com.tm.ejb.model;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.tma.ejb.ValueRemote;

public class ValueModel {
	private Number value;

	public Number getValue() {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		props.put("jboss.naming.client.ejb.context", true);
		
		Context context = null;
		ValueRemote bean = null;
		
		try {
			context = new InitialContext(props);
			bean = (ValueRemote) context.lookup("/ejbStatelessBean/Value!com.tma.ejb.ValueRemote");
			value = bean.getValue();
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return value;
	}

	public void setValue(Number value) {
		this.value = value;
	}
}
