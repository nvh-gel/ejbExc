package com.tma.ejb.web.controller;

import java.util.Arrays;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tma.ejb.web.model.Hello;
import com.tma.ejb.web.utils.EJBUtils;
import com.tma.ejb.web.utils.HTTPResponse;
import com.tma.ejb.web.utils.InputRequest;
import com.tma.ejb.web.utils.YAMLConfig;

@Controller(value = "/")
public class HelloController {
	Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private YAMLConfig yamlConfig;

	@RequestMapping(method = RequestMethod.GET)
	public String getHello(Model model) {
		String msg = null;
		float value = 42;

		try {
			Hello hello = new Hello(yamlConfig);
			msg = hello.getHello(EJBUtils.getContext());
			value = hello.getValue(EJBUtils.getContext());
		} catch (NamingException e) {
			logger.error(Arrays.toString(e.getStackTrace()));
		}

		model.addAttribute("message", msg);
		model.addAttribute("value", value);
		return "index";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody HTTPResponse setValue(@RequestBody InputRequest rq) {
		logger.info("updating value to {}", rq.getVal());
		try {
			new Hello(yamlConfig).setValue(EJBUtils.getContext(), rq.getVal());
			return HTTPResponse.ACCEPTED;

		} catch (Exception e) {
			logger.error(Arrays.toString(e.getStackTrace()));
			return HTTPResponse.SERVER_ERROR;
		}
	}

	public YAMLConfig getYamlConfig() {
		return this.yamlConfig;
	}

	public void setYamlConfig(YAMLConfig yamlConfig) {
		this.yamlConfig = yamlConfig;
	}
}