package com.tma.ejb.web.utils;

import com.tma.ejb.web.model.AdditonalComponent;
import com.tma.ejb.web.model.BaseComp;
import com.tma.ejb.web.model.CompA;
import com.tma.ejb.web.model.CompB;
import com.tma.ejb.web.model.CompC;

public class ComponentFactory {
	private BaseComp base;

	public ComponentFactory(BaseComp base) {
		this.base = base;
	}

	public AdditonalComponent produce(String param) {
		switch (param) {
		case "compA":
			return new CompA(base);
		case "compB":
			return new CompB(base);
		case "compC":
			return new CompC(base);
		default:
			return null;
		}
	}
}
