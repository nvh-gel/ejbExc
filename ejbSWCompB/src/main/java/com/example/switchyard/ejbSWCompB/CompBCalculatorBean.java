package com.example.switchyard.ejbSWCompB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.switchyard.component.bean.Service;

@Service(CompBCalculator.class)
public class CompBCalculatorBean implements CompBCalculator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CompBCalculator.class);

	@Override
	public Double calculate(String val) {
		Double value = Double.valueOf(val);
		
		LOGGER.info("CompB: Recalculating value for " + value);
		
		return value > 20 ? value + 5 : value + 20;
	}

}
