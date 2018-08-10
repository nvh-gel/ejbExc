package com.tma.ejb.comp.a.business;

import javax.ejb.Remote;

@Remote
public interface CompACalculator {
	float calculate(float value);
}
