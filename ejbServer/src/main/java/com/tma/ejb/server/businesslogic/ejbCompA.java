package com.tma.ejb.server.businesslogic;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: ejbCompA
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "tutorialQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })

@TransactionManagement(TransactionManagementType.BEAN)
public class ejbCompA implements MessageListener {

	/**
	 * Default constructor.
	 */
	public ejbCompA() {
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("Message received: " + textMessage.getText());
		} catch (JMSException e) {
			System.out.println("Error while trying to consume messages: " + e.getMessage());
		}
	}

}
