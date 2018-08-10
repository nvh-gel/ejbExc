package com.tma.ejb.server.utils;

import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EJBUtils {
	private static Context context;
	
	@EJB
	private static ComponentConfig config;
	

	private EJBUtils() {
	}

	@SuppressWarnings("rawtypes")
	public static String getLookupStr(String module, Class classType) {
		String moduleName = module;
		String beanName = classType.getSimpleName() + "Bean";
		String viewClassName = classType.getName();
		return moduleName + "/" + beanName + "!" + viewClassName;
	}

	public static Context getContext(String component) throws NamingException {
		if (context == null) {
			Properties jndiProps = new Properties();
			jndiProps.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
			jndiProps.put("jboss.naming.client.ejb.context", true);
			jndiProps.put("java.naming.provider.url", String.format("http-remoting://%s", config.getProperty(component)));
			context = new InitialContext(jndiProps);
		}
		return context;
	}
}
