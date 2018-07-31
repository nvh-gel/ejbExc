package com.tma.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloWorldRemote {
	public String getMsg();
}
