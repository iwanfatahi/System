package org.simbiosis.system.model;

import java.io.Serializable;
import java.util.Date;

public class OperationLogPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4430911618534270843L;
	long user;
	Date timestamp;

	public OperationLogPK() {

	}

	public OperationLogPK(long user) {
		this.user = user;
		timestamp = new Date();
	}

	public long getUser() {
		return user;
	}

	public void setUser(long user) {
		this.user = user;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + (int) (user ^ (user >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperationLogPK other = (OperationLogPK) obj;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (user != other.user)
			return false;
		return true;
	}

}
