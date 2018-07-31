package com.tma.ejb;

import javax.ejb.Remote;

@Remote
public interface ValueRemote {
	public Number getValue();
	public void setValue(Number val);
}
