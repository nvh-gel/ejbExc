package com.tma.ejb.comp.b.business;

import javax.ejb.Remote;

@Remote
public interface CompBCalculator {
	public float calculate(float value);
}
