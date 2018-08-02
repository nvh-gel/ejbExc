package com.tma.ejb.server.businesslogic;

import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.tma.ejb.server.business.ValueHolder;

/**
 * Session Bean implementation class ValueHolderBean
 */
@Stateful
@TransactionManagement(TransactionManagementType.BEAN)
public class ValueHolderBean implements ValueHolder {
	private static float value;
    /**
     * Default constructor. 
     */
    public ValueHolderBean() {
    }

	@Override
	public float getValue() {
		return value;
	}

	@Override
	public void setValue(float val) {
		value = val;
	}

}
