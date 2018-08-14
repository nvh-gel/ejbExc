package com.example.switchyard.ejbSWCompB;

import org.switchyard.component.bean.Service;

@Service(CompBCalculator.class)
public class CompBCalculatorBean implements CompBCalculator {

	@Override
	public Double calculate(String val) {
		Double value = Double.valueOf(val);
		return value > 20 ? value + 5 : value + 20;
	}

}
