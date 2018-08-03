package com.tma.ejb.web.model;

import static com.tma.ejb.web.utils.EJBUtils.getLookupStr;

import javax.naming.Context;
import javax.naming.NamingException;

import com.tma.ejb.comp.b.business.CompBCalculator;

public class CompB extends AdditonalComponent {

	public CompB(HelloComponent comp) {
		super(comp);
		this.module = "ejbCompB";
	}

	@Override
	public void setValue(Context context, float val) throws NamingException {

		CompBCalculator compB = (CompBCalculator) context.lookup(getLookupStr(this.module, CompBCalculator.class));
		float newVal = compB.calculate(val);
		System.out.println("Component B setting value to: " + newVal);
		this.component.setValue(context, newVal);
	}
}
