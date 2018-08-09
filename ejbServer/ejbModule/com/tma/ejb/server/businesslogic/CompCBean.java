package com.tma.ejb.server.businesslogic;

import javax.ejb.EJB;

import com.tma.ejb.comp.c.business.CompCCalculator;

public class CompCBean extends AdditionalComponentBean{
	@EJB(lookup="ejb:ejbCompC/CompCCalculatorBean!com.tma.ejb.comp.c.business.CompCCalculator")
	CompCCalculator calculator;

	@Override
	public float calculate(float val) {
		System.out.println("Component C is calculating val " + val);
		return calculator.calculate(val);
	}
}