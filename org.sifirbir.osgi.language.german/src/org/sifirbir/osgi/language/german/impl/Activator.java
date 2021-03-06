package org.sifirbir.osgi.language.german.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.sifirbir.osgi.language.api.ILanguage;

public class Activator implements BundleActivator {
	
	private ServiceRegistration<ILanguage> serviceRegistrationGermanLang = null;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println(Configuration.BUNDLE.MESSAGE_START);
		serviceRegistrationGermanLang = bundleContext.registerService(ILanguage.class, new GermanLangImpl() , null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		if (serviceRegistrationGermanLang != null) {
			System.out.println(Configuration.BUNDLE.MESSAGE_STOP);
		}
	}

}
