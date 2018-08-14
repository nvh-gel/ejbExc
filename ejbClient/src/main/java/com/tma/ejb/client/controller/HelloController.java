package com.tma.ejb.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value="/")
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		String message = null;
		float value = 0;
		
		message = "Hello EJB!";
		
		model.addAttribute("message", message);
		model.addAttribute("value", value);
		
		return "index";
	}
}
