package com.tma.ejb.web.model;

import static com.tma.ejb.web.utils.EJBUtils.getLookupStr;

import javax.naming.Context;
import javax.naming.NamingException;

import org.springframework.context.annotation.Bean;

import com.tma.ejb.server.business.HelloWorld;
import com.tma.ejb.server.business.ValueHolder;

public class Hello {
	
	@Bean
	public HelloWorld getHello(Context context) throws NamingException {
		return (HelloWorld) context.lookup(getLookupStr(HelloWorld.class));
	}
	
	@Bean
	public ValueHolder getValue(Context context) throws NamingException {
		return (ValueHolder) context.lookup(getLookupStr(ValueHolder.class));
	}
}
