package com.tma.ejb.server.businesslogic;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.tma.ejb.server.business.HelloWorld;

/**
 * Session Bean implementation class HelloWorldBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class HelloWorldBean implements HelloWorld {

	@Override
	public String getMsg() {
		return "Hello EJB!";
	}

}
