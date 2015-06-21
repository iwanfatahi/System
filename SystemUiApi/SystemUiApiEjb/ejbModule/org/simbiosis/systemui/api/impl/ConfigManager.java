package org.simbiosis.systemui.api.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.simbiosis.systemui.api.bean.IConfigManager;
import org.simbiosis.systemui.api.dto.UiConfigDto;

@Stateless
@Remote(IConfigManager.class)
public class ConfigManager implements IConfigManager {

	@Override
	public UiConfigDto getConfig() {
		UiConfigDto result = new UiConfigDto();
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"/home/simbiosis/global/simbiosis.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			result.setAppApi(prop.getProperty("api.app"));
			result.setSimbiosisApi(prop.getProperty("api.simbiosis"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
