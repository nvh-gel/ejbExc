package com.tma.ejb.server.business;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {
	public String getMsg();
}
