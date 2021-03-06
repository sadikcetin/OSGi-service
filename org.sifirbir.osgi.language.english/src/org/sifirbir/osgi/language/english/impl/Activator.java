package org.sifirbir.osgi.language.english.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.sifirbir.osgi.language.api.ILanguage;

public class Activator implements BundleActivator {

	private ServiceRegistration<ILanguage> serviceRegistrationEnglishLanguage = null;

	public void start(BundleContext bundleContext) throws Exception {
		serviceRegistrationEnglishLanguage = bundleContext.registerService(ILanguage.class, new EnglishLangImpl(),
				null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		if (serviceRegistrationEnglishLanguage != null) {
			serviceRegistrationEnglishLanguage.unregister();
		}
	}

}
