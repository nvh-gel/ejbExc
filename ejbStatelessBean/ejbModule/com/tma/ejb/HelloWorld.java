package com.tma.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * Session Bean implementation class HelloWorld
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class HelloWorld implements HelloWorldRemote {

    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return "test";
	}

}
