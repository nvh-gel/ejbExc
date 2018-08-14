package com.example.switchyard.ejbSWCompC;

import org.switchyard.component.bean.Service;

@Service(CompCCalculator.class)
public class CompCCalculatorBean implements CompCCalculator {

	@Override
	public Double calculate(String val) {
		Double value = Double.valueOf(val);
		return value > 30 ? value + 10 : value + 25;
	}

}
