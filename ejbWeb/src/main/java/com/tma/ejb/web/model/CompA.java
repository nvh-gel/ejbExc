package com.tma.ejb.web.model;

import javax.naming.Context;
import javax.naming.NamingException;

import com.tma.ejb.comp.a.business.CompACalculator;
import static com.tma.ejb.web.utils.EJBUtils.getLookupStr;

public class CompA extends AdditonalComponent {

	public CompA(float val) {
		super(val);
	}

	@Override
	public float getValue(Context context) throws NamingException {
		CompACalculator calculator = (CompACalculator) context.lookup(getLookupStr(CompACalculator.class));
		return calculator.calculate(value);
	}
}
