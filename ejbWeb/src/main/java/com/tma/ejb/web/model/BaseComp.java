package com.tma.ejb.web.model;

import javax.naming.Context;
import javax.naming.NamingException;

import org.springframework.context.annotation.Bean;

import com.tma.ejb.server.business.HelloWorld;
import com.tma.ejb.server.business.ValueHolder;
import static com.tma.ejb.web.utils.EJBUtils.getLookupStr;

public class BaseComp extends HelloComponent {

	@Override
	public float getValue(Context context) throws NamingException {
		ValueHolder valueIntf = (ValueHolder) context.lookup(getLookupStr(ValueHolder.class));
		this.value = valueIntf.getValue();
		return this.value;
	}
}
