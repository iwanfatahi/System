package org.simbiosis.system.log;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.simbiosis.system.model.OperationLog;

/**
 * Message-Driven Bean implementation class for: OperationLogMdb
 */
@MessageDriven(name = "SystemLogMdb", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/SystemLogQueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class SystemLogMdb implements MessageListener {

	@PersistenceContext(unitName = "SystemLogEjb", type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public SystemLogMdb() {
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		ObjectMessage msg = (ObjectMessage) message;
		try {
			if (msg != null) {
				OperationLog log = (OperationLog) msg.getObject();
				em.persist(log);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
