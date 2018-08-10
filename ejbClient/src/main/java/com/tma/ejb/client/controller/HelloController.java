package com.tma.ejb.client.controller;

import java.util.Arrays;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tma.ejb.client.model.HelloModel;
import com.tma.ejb.client.utils.EJBUtils;

@RestController(value="/")
public class HelloController {
	Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHello(Model model) {
		String msg = null;
		float value = 42;

		try {
			HelloModel hello = new HelloModel();
			msg = hello.getHello(EJBUtils.getContext());
//			value = hello.getValue(EJBUtils.getContext());
		} catch (NamingException e) {
			logger.error(Arrays.toString(e.getStackTrace()));
		}

		model.addAttribute("message", msg);
		model.addAttribute("value", value);
		return msg;
	}
}
