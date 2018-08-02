package com.tma.ejb.web.utils;

public class EJBUtils {
	public static String getLookupStr(Class classType) {
		String moduleName = "ejbServer/";
		String beanName = classType.getSimpleName() + "Bean";
		String viewClassName = classType.getName();
		return moduleName + beanName + "!" + viewClassName;
	}
}
