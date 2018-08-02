package com.tma.ejb.web.model;

import static com.tma.ejb.web.utils.EJBUtils.getLookupStr;

import javax.naming.Context;
import javax.naming.NamingException;

import com.tma.ejb.comp.b.business.CompBCalculator;

public class CompB extends AdditonalComponent{
	
	public CompB(float val) {
		super(val);
	}

	@Override
	public float getValue(Context context) throws NamingException {
		CompBCalculator calculator = (CompBCalculator) context.lookup(getLookupStr(CompBCalculator.class));
		return calculator.calculate(value);
	}

}
