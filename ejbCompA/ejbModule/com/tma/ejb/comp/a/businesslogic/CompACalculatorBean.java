package com.tma.ejb.comp.a.businesslogic;

import javax.ejb.Stateless;

import com.tma.ejb.comp.a.business.CompACalculator;

@Stateless
public class CompACalculatorBean implements CompACalculator {

    public CompACalculatorBean() {
    }

	@Override
	public float calculate(float value) {
		return value > 10 ? value + 3 : value + 10;
	}

}
