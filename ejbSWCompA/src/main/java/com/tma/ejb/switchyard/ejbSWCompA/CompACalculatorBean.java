package com.tma.ejb.switchyard.ejbSWCompA;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.switchyard.component.bean.Service;

@Service(CompACalculator.class)
public class CompACalculatorBean implements CompACalculator {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompACalculatorBean.class);

	@Override
	public Double calculate(String val) {
		Double value = Double.valueOf(val);
		LOGGER.info("CompA: Re-calculating value of " + value);
		return value > 10 ? value + 3 : value + 10;
	}
}
