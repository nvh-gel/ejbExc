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
		return value > 20 ? value + 5 : value + 20;
	}
}
