package com.tma.ejb.web.model.impl;

import static com.tma.ejb.web.utils.EJBUtils.getLookupStr;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import com.tma.ejb.web.model.HelloWorld;
import com.tma.ejb.web.model.ValueHolder;
import com.tma.ejb.web.utils.ComponentFactory;
import com.tma.ejb.web.utils.YAMLConfig;

public class Hello {

	private YAMLConfig yamlConfig;

	public Hello(YAMLConfig yamlConfig) {
		this.yamlConfig = yamlConfig;
	}

	public String getHello(Context context) throws NamingException {
		String module = "ejbServer";
		HelloWorld helloWorld = (HelloWorld) context.lookup(getLookupStr(module, HelloWorld.class));
		return helloWorld.getMsg();
	}

	public float getValue(Context context) throws NamingException {
		String module = "ejbServer";
		ValueHolder valueHolder = (ValueHolder) context.lookup(getLookupStr(module, ValueHolder.class));
		return valueHolder.getValue();
	}

	public void setValue(Context context, float value) throws NamingException {
		List<HelloComponent> comps = new ArrayList<>();
		BaseComp base = new BaseComp();
		base.setValue(context, value);

		ComponentFactory factory = new ComponentFactory(base);

		for (String comp : yamlConfig.getComponents()) {
			comps.add(factory.produce(comp));
		}

		for (HelloComponent comp : comps) {
			comp.setValue(context, base.getValue(context));
		}
	}
}
