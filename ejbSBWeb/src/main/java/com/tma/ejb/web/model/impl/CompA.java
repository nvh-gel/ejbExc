package com.tma.ejb.web.model.impl;

import static com.tma.ejb.web.utils.EJBUtils.getLookupStr;

import javax.naming.Context;
import javax.naming.NamingException;

import com.tma.ejb.web.model.CompACalculator;

public class CompA extends AdditonalComponent {

	public CompA(HelloComponent comp) {
		super(comp);
		this.module = "ejbCompA";
	}

	@Override
	public void setValue(Context context, float val) throws NamingException {
		CompACalculator compA = (CompACalculator) context.lookup(getLookupStr(this.module, CompACalculator.class));
		float newVal = compA.calculate(val);
		System.out.println("Component A setting value to: " + newVal);
		this.component.setValue(context, newVal);
	}
}
