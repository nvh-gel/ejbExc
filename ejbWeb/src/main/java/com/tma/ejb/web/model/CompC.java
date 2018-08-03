package com.tma.ejb.web.model;

import static com.tma.ejb.web.utils.EJBUtils.getLookupStr;

import javax.naming.Context;
import javax.naming.NamingException;

import com.tma.ejb.comp.c.business.CompCCalculator;

public class CompC extends AdditonalComponent {
	public CompC(HelloComponent comp) {
		super(comp);
		this.module = "ejbCompC";
	}
	
	@Override
	public void setValue(Context context, float val) throws NamingException {
		CompCCalculator compC = (CompCCalculator) context.lookup(getLookupStr(this.module, CompCCalculator.class));
		float newVal = compC.calculate(val);
		System.out.println("Component C setting value to: " + newVal);
		this.component.setValue(context, newVal);
	}
}
