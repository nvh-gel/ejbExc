package com.tma.ejb.web.utils;

public class EJBUtils {
	private EJBUtils() {
	}

	@SuppressWarnings("rawtypes")
	public static String getLookupStr(String module, Class classType) {
		String moduleName = module;
		String beanName = classType.getSimpleName() + "Bean";
		String viewClassName = classType.getName();
		return moduleName + "/" + beanName + "!" + viewClassName;
	}
}
