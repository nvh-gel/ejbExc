package com.tma.ejb.web.utils;

import com.tma.ejb.web.model.impl.AdditonalComponent;
import com.tma.ejb.web.model.impl.BaseComp;
import com.tma.ejb.web.model.impl.CompA;
import com.tma.ejb.web.model.impl.CompB;
import com.tma.ejb.web.model.impl.CompC;

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
