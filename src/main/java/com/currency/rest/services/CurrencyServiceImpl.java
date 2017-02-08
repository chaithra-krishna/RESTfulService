/**
 * 
 */
package com.currency.rest.services;

import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.currency.rest.model.CurrencyData;

/**
 * @author Macbook pro
 *
 */
@Service
public class CurrencyServiceImpl implements InitializingBean, CurrencyService {

	Logger LOG = LoggerFactory.getLogger(CurrencyServiceImpl.class);

	@Inject
	private ActiveMQConnectionFactory jmsConnectionFactory;

	private Session session = null;

	private MessageProducer producer = null;

	private Connection connection = null;

	private Queue queue = null;

	/**
	 * 
	 * This method sends the data to ActiveMQ.
	 * 
	 * @param currencyData
	 *            - data which needs to send to the ActiveMQ.
	 */
	public void subbmitToQueue(CurrencyData currencyData) {
		try {
			ObjectMessage ObjectMessage = session.createObjectMessage(currencyData);
			producer.send(ObjectMessage);
			LOG.info("CurrencyController : subbmitToQueue : message uploaded to ActiveMQ");
		} catch (JMSException e) {
			LOG.error("CurrencyController : postMessageToQueue : exception occured {}", e.getMessage());
		}
	}

	/**
	 * This method is the prepare the connection for the ActiveMQ immediately
	 * after the bean initialization by spring so when the request comes,
	 * directly can to stored into ActiveMQ.
	 */
	public void afterPropertiesSet() throws Exception {
		LOG.info("CurrencyController : afterPropertiesSet : inside initialization");
		connection = jmsConnectionFactory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = session.createQueue("currencyQueue");
		producer = session.createProducer(queue);
		LOG.info("CurrencyController : afterPropertiesSet : initialization completed");
	}
}
