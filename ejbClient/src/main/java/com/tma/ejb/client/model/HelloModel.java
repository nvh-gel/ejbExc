package com.tma.ejb.client.model;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import com.tma.ejb.server.business.HelloWorld;

import static com.tma.ejb.client.utils.EJBUtils.getLookupStr;

//import com.tma.ejb.web.utils.ComponentFactory;

public class HelloModel {


	public String getHello(Context context) throws NamingException {
		String module = "ejbServer";
		HelloWorld helloWorld = (HelloWorld) context.lookup(getLookupStr(module, HelloWorld.class));
		return helloWorld.getMsg();
	}

//	public float getValue(Context context) throws NamingException {
//		String module = "ejbServer";
//		ValueHolder valueHolder = (ValueHolder) context.lookup(getLookupStr(module, ValueHolder.class));
//		return valueHolder.getValue();
//	}
//
//	public void setValue(Context context, float value) throws NamingException {
//		List<HelloComponent> comps = new ArrayList<>();
//		BaseComp base = new BaseComp();
//		base.setValue(context, value);
//	}
}