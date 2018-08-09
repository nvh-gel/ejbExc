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
//import com.tma.ejb.comp.c.business.CompCCalculator;
//
//
//public class CompC extends AdditonalComponent {
//	public CompC(HelloComponent comp) {
//		super(comp);
//		this.module = "ejbCompC";
//	}
//
//	@Override
//	public void setValue(Context context, float val) throws NamingException {
//		CompCCalculator compC = (CompCCalculator) context.lookup(getLookupStr(this.module, CompCCalculator.class));
//		float newVal = compC.calculate(val);
//		Logger logger = LoggerFactory.getLogger(CompC.class);
//		logger.info("Component C set value to: {}", newVal);
//		this.component.setValue(context, newVal);
//	}
//}
