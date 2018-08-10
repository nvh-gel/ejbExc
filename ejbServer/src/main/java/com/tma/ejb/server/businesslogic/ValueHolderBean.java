package com.tma.ejb.server.businesslogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.tma.ejb.server.business.ValueHolder;
import com.tma.ejb.server.utils.ComponentConfig;
//import com.tma.ejb.server.utils.ComponentFactory;

/**
 * Session Bean implementation class ValueHolderBean
 */
@Stateful
@TransactionManagement(TransactionManagementType.BEAN)
public class ValueHolderBean implements ValueHolder {
	
	private static float value;
	
	@EJB
	ComponentConfig config;

	@Override
	public float getValue() {
		return value;
	}

	@Override
	public void setValue(float val) {
		value = this.calculateValue(val);
	}
	
	private float calculateValue(float val) {
		System.out.println("Calculating value " + val);
		
		List<String> compOrder = Arrays.asList(config.getProperty("installation").split(","));
		
		float newVal[] = {val};
		
//		compOrder.forEach(comp -> {
//			AdditionalComponentBean component = new ComponentFactory().produce(comp);
//			newVal[0] = component.calculate(val);
//		});		
		return newVal[0];
	}

}
