package com.tma.ejb.switchyard.ejbSWCompA;

import org.switchyard.component.bean.Service;

@Service(CompACalculator.class)
public class CompACalculatorBean implements CompACalculator {

	@Override
	public Double calculate(String val) {
		Double value = Double.valueOf(val);
		return value > 10 ? value + 3 : value + 10;
	}
}
