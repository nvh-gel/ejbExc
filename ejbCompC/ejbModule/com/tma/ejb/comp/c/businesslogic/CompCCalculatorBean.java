package com.tma.ejb.comp.c.businesslogic;

import com.tma.ejb.comp.c.business.CompCCalculator;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
@Stateless
@LocalBean
public class CompCCalculatorBean implements CompCCalculator {
    public CompCCalculatorBean() {
    }

	@Override
	public float calculate(float value) {
		return value > 30 ? value + 10 : value + 25;
	}

}
