package org.simbiosis.system.bean;

import org.simbiosis.system.model.Config;

public interface IConfig {
	Config get(long company, String key);

	void save(Config config);
}
