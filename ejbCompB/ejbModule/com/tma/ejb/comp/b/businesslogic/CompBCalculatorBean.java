package com.tma.ejb.comp.b.businesslogic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.tma.ejb.comp.b.business.CompBCalculator;

@Stateless
@LocalBean
public class CompBCalculatorBean implements CompBCalculator {
    public CompBCalculatorBean() {
    }

	@Override
	public float calculate(float value) {
		if (value > 20) {
			return value + 5;
		} else {
			return value + 20;
		}
	}
}
