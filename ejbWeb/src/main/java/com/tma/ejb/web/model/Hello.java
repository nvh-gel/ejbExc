package com.tma.ejb.web.model;

import static com.tma.ejb.web.utils.EJBUtils.getLookupStr;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import org.springframework.context.annotation.Bean;

import com.tma.ejb.server.business.HelloWorld;
import com.tma.ejb.server.business.ValueHolder;

public class Hello {

	@Bean
	public String getHello(Context context) throws NamingException {
		String module = "ejbServer";
		HelloWorld helloWorld = (HelloWorld) context.lookup(getLookupStr(module, HelloWorld.class));
		return helloWorld.getMsg();
	}

	@Bean
	public float getValue(Context context) throws NamingException {
		String module = "ejbServer";
		ValueHolder valueHolder = (ValueHolder) context.lookup(getLookupStr(module, ValueHolder.class));
		return valueHolder.getValue();
	}

	@Bean
	public void setValue(Context context, float value) throws NamingException {
		List<HelloComponent> comps = new ArrayList<HelloComponent>();
		BaseComp base = new BaseComp();
		base.setValue(context, value);

		comps.add(new CompA(base));
		comps.add(new CompB(base));
		comps.add(new CompC(base));

		for (HelloComponent comp : comps) {
			comp.setValue(context, base.getValue(context));
		}
	}
}
