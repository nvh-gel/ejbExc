package com.tma.ejb.web.controller;

import javax.naming.NamingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tma.ejb.web.model.Hello;
import com.tma.ejb.web.utils.EJBInitialContext;
import com.tma.ejb.web.utils.HTTPResponse;
import com.tma.ejb.web.utils.InputRequest;

@Controller(value = "/")
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHello(Model model) {
		String msg = null;
		float value = 42;
		try {
			Hello hello = new Hello();
			msg = hello.getHello(EJBInitialContext.getContext());
			value = hello.getValue(EJBInitialContext.getContext());
		} catch (NamingException e) {
			e.printStackTrace();
		}
		model.addAttribute("message", msg);
		model.addAttribute("value", value);
		return "hello";
	}
	
	@RequestMapping(method = RequestMethod.PUT) 
	public @ResponseBody HTTPResponse setValue(@RequestBody InputRequest rq) {
		System.out.println("updating value to " + rq.getVal());
		try {
			new Hello()
				.setValue(EJBInitialContext.getContext(), rq.getVal());
			return HTTPResponse.ACCEPTED;
			
		} catch (Exception e) {
			e.printStackTrace();
			return HTTPResponse.SERVER_ERROR;
		}
	}
}
