package com.tma.ejb.client.utils;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EJBUtils {
	private static Context context;
	
	
	public static Context getContext() throws NamingException {
		if (context == null) {
			Properties jndiProps = new Properties();
			jndiProps.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
			jndiProps.put("jboss.naming.client.ejb.context", true);
			jndiProps.put("java.naming.provider.url", "http-remoting://localhost:8080");
			context = new InitialContext(jndiProps);
		}
		return context;
	}
	
	public static String getLookupStr(String module, Class classType) {
		String moduleName = module;
		String beanName = classType.getSimpleName() + "Bean";
		String viewClassName = classType.getName();
		return moduleName + "/" + beanName + "!" + viewClassName;
	}
}
