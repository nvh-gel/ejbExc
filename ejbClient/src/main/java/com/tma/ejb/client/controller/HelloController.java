package com.tma.ejb.client.controller;

import java.util.Arrays;

import javax.naming.Context;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tma.ejb.client.model.HelloEJBModel;
import com.tma.ejb.client.model.ValueModel;
import com.tma.ejb.client.utils.EJBUtils;


@Controller
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	private static Context context;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(Model model) {
		String message = null;
		float value = 0;
		
		try {
			context = EJBUtils.getContext("ejbServer");
			message = new HelloEJBModel(context).getMessage();
			value = new ValueModel(context).getValue();
		} catch (NamingException e) {
			LOGGER.error(e.getMessage());
		}
		
		model.addAttribute("message", message);
		model.addAttribute("value", value);
		
		return "index";
	}
	
	@RequestMapping(value="/{value}", method = RequestMethod.PUT)
	public ResponseEntity<String> setValue(@PathVariable float value) {
		try {
			context = EJBUtils.getContext("ejbServer");
			new ValueModel(context).setValue(value);
		} catch (Exception e) {
			LOGGER.error(Arrays.toString(e.getStackTrace()));
			return new ResponseEntity<>(Arrays.toString(e.getStackTrace()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("Accepted\n", HttpStatus.ACCEPTED);
	}
}
