package com.tma.ejb.comp.a.businesslogic;

import javax.ejb.Stateless;

import com.tma.ejb.comp.a.business.CompACalculator;

@Stateless
public class CompACalculatorBean implements CompACalculator {

    public CompACalculatorBean() {
    }

	@Override
	public float calculate(float value) {
		if (value > 10) {
			return value + 3;
		} else {
			return value + 10;
		}
	}

}
