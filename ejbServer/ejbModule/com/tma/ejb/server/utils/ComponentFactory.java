package com.tma.ejb.server.utils;

import com.tma.ejb.server.businesslogic.AdditionalComponentBean;
import com.tma.ejb.server.businesslogic.CompABean;
import com.tma.ejb.server.businesslogic.CompBBean;
import com.tma.ejb.server.businesslogic.CompCBean;

public class ComponentFactory {
	public AdditionalComponentBean produce(String param) {
		switch (param) {
		case "compA":
			return new CompABean();
		case "compB":
			return new CompBBean();
		case "compC":
			return new CompCBean();
		default:
			return null;
		}
	}
}
