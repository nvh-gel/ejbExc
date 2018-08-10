package com.tma.ejb.comp.c.business;

import javax.ejb.Remote;

@Remote
public interface CompCCalculator {
	public float calculate(float value);
}
