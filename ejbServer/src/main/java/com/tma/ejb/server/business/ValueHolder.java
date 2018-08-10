package com.tma.ejb.server.business;

import javax.ejb.Remote;

@Remote
public interface ValueHolder {
	public float getValue();
	public void setValue(float val);
}
