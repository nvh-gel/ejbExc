package com.tma.ejb.server.businesslogic;

import javax.ejb.EJB;

import com.tma.ejb.comp.a.business.CompACalculator;

public class CompABean extends AdditionalComponentBean {
	@EJB
	CompACalculator calculator;

	@Override
	public float calculate(float val) {
		return calculator.calculate(val);
	}

}
