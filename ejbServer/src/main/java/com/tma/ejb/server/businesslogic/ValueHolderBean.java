package com.tma.ejb.server.businesslogic;


import java.util.Arrays;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tma.ejb.server.business.ValueHolder;
import com.tma.ejb.server.utils.ComponentConfig;


@JMSDestinationDefinitions(
    value = {
        @JMSDestinationDefinition(
            name = "java:/queue/ejbCompA",
            interfaceName = "javax.jms.Queue",
            destinationName = "ejbCompA"
        )})

/**
 * Session Bean implementation class ValueHolderBean
 */
@Stateful
@TransactionManagement(TransactionManagementType.BEAN)
public class ValueHolderBean implements ValueHolder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValueHolderBean.class);
	
	private static float value;
	
	@EJB
	ComponentConfig config;
	
	@Inject
    private JMSContext context;
	
	@Resource(lookup = "java:/queue/ejbCompA")
    private Queue queue;

	@Override
	public float getValue() {
		return value;
	}
	
	@Override
	public void setValue(float val) {
		value = val;
		LOGGER.info("Enqueue message");
		try {
			context.createProducer().send(queue, value);
//			context.createProducer()
		} catch (Exception e) {
			LOGGER.error(Arrays.toString(e.getStackTrace()));
		}
	}
}
