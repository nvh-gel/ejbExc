//package com.tma.ejb.web.model;
//
//import static com.tma.ejb.server.utils.EJBUtils.getLookupStr;
//
//import javax.naming.Context;
//import javax.naming.NamingException;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.tma.ejb.comp.a.business.CompACalculator;
//
//
//public class CompA extends AdditonalComponent {
//
//	public CompA(HelloComponent comp) {
//		super(comp);
//		this.module = "ejbCompA";
//	}
//
//	@Override
//	public void setValue(Context context, float val) throws NamingException {
//		CompACalculator compA = (CompACalculator) context.lookup(getLookupStr(this.module, CompACalculator.class));
//		float newVal = compA.calculate(val);
//		Logger logger = LoggerFactory.getLogger(CompA.class);
//		logger.info("Component A set value to: {}", newVal);
//		this.component.setValue(context, newVal);
//	}
//}
