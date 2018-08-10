package com.tma.ejb.server.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class ComponentConfig {
	Properties props;

	@PostConstruct
	public void init() {
		InputStream iStream = this.getClass().getClassLoader().getResourceAsStream("server.properties");
		props = new Properties();
		System.out.println("InputStream is: " + iStream);
		try {
			props.load(iStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Read Properties." + props);

	}
	
	public String getProperty(String key) {
		return props.getProperty(key, null);
	}
}
