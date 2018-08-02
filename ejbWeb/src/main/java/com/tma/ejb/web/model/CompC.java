package com.tma.ejb.web.model;

import static com.tma.ejb.web.utils.EJBUtils.getLookupStr;

import javax.naming.Context;
import javax.naming.NamingException;

import com.tma.ejb.comp.c.business.CompCCalculator;

public class CompC extends AdditonalComponent {

	public CompC(float val) {
		super(val);
	}

	@Override
	public float getValue(Context context) throws NamingException {
		CompCCalculator calculator = (CompCCalculator) context.lookup(getLookupStr(CompCCalculator.class));
		this.value = calculator.calculate(value);
		return this.value;
	}


}
