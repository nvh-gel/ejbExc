package com.tm.ejb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.ejb.model.ValueModel;

@Controller
@RequestMapping(value = "/hello")
public class ValueController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayHello(Model model) {
		model.addAttribute("value", new ValueModel().getValue());
		return "hello";
	}
}
