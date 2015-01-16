package org.simbiosis.system.api.impl;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.simbiosis.system.model.OperationLog;

@Stateless
@Local
public class SystemLog {

	@Resource(mappedName = "java:/ConnectionFactory")
	ConnectionFactory connectionFactory;
	@Resource(mappedName = "java:/jms/queue/SystemLogQueue")
	Queue operationLog;

	public void sendOperationLog(OperationLog msg) {
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(operationLog);
			ObjectMessage message = session.createObjectMessage();
			message.setObject(msg);
			connection.start();
			producer.send(message);
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
