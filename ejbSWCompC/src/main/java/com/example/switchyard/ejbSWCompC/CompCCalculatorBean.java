package com.example.switchyard.ejbSWCompC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.switchyard.component.bean.Service;

@Service(CompCCalculator.class)
public class CompCCalculatorBean implements CompCCalculator {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompCCalculatorBean.class);

	@Override
	public Double calculate(String val) {
		Double value = Double.valueOf(val);
		
		LOGGER.info("CompC: Recalculating value " + value);
		
		return value > 30 ? value + 10 : value + 25;
	}

}
