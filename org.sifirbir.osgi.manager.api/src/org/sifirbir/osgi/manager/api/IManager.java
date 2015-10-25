package org.sifirbir.osgi.manager.api;

public interface IManager<SERVICE> {

	void startService(SERVICE service);
	void stopService(SERVICE service);

}
