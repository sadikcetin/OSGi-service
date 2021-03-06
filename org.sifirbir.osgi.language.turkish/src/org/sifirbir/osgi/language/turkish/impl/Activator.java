package org.sifirbir.osgi.language.turkish.impl;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.sifirbir.osgi.language.api.ILanguage;

public class Activator implements BundleActivator {

	private ServiceRegistration<ILanguage> serviceRegistrationTurkishLang = null;
	

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println(Configuration.BUNDLE.MESSAGE_START);
		serviceRegistrationTurkishLang = bundleContext.registerService(ILanguage.class, new TurkishLangImpl(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println(Configuration.BUNDLE.MESSAGE_STOP);
		if (serviceRegistrationTurkishLang != null) {
			serviceRegistrationTurkishLang.unregister();
		}
	}

}
