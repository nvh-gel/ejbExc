package com.tma.ejb.web.model.impl;

import static com.tma.ejb.web.utils.EJBUtils.getLookupStr;

import javax.naming.Context;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tma.ejb.web.model.CompBCalculator;

public class CompB extends AdditonalComponent {

	public CompB(HelloComponent comp) {
		super(comp);
		this.module = "ejbCompB";
	}

	@Override
	public void setValue(Context context, float val) throws NamingException {

		CompBCalculator compB = (CompBCalculator) context.lookup(getLookupStr(this.module, CompBCalculator.class));
		float newVal = compB.calculate(val);
		Logger logger = LoggerFactory.getLogger(CompB.class);
		logger.info("Component B set value to: {}", newVal);
		this.component.setValue(context, newVal);
	}
}
