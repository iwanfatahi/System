package org.simbiosis.system.model;

import java.io.Serializable;
import java.util.Date;

public class Salt implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1108775974366113248L;
	String value;
	Date timestamp;
	int valid;

	public Salt() {

	}

	public Salt(String value) {
		this.value = value;
		timestamp = new Date();
		valid = 1;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

}
