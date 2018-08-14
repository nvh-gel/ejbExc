package com.tma.ejb.server.businesslogic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.xml.ws.spi.http.HttpContext;

import com.tma.ejb.server.business.ValueHolder;
import com.tma.ejb.server.utils.ComponentConfig;
//import com.tma.ejb.server.utils.ComponentFactory;

/**
 * Session Bean implementation class ValueHolderBean
 */
@Stateful
@TransactionManagement(TransactionManagementType.BEAN)
public class ValueHolderBean implements ValueHolder {
	
	private float value;
	
	@EJB
	ComponentConfig config;

	@Override
	public float getValue() {
		return this.value;
	}

	@Override
	public void setValue(float val) {
		
	}
}
