package org.simbiosis.systemui.api.dto;

import java.io.Serializable;

public class UiConfigDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1943590225164690569L;

	private String appApi;
	private String simbiosisApi;

	public String getAppApi() {
		return appApi;
	}

	public void setAppApi(String appApi) {
		this.appApi = appApi;
	}

	public String getSimbiosisApi() {
		return simbiosisApi;
	}

	public void setSimbiosisApi(String simbiosisApi) {
		this.simbiosisApi = simbiosisApi;
	}

}
