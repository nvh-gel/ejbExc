package com.tma.ejb.web.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {

	private List<String> components = new ArrayList<>();

	public List<String> getComponents() {
		return this.components;
	}

	public void setComponents(List<String> components) {
		this.components = components;
	}
}