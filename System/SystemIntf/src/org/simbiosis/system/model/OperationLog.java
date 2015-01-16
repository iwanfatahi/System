package org.simbiosis.system.model;

import java.io.Serializable;

public class OperationLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2670375449785322264L;
	OperationLogPK id;
	String operation;
	String session;

	public OperationLog() {

	}

	public OperationLog(long userId, String session, String operation) {
		id = new OperationLogPK(userId);
		this.session = session;
		this.operation = operation;
	}

	public OperationLogPK getId() {
		return id;
	}

	public void setId(OperationLogPK id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

}
