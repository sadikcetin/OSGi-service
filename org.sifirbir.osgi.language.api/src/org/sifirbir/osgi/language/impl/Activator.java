package org.sifirbir.osgi.language.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		System.out.println(Configuration.BUNDLE.MESSAGE_START);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println(Configuration.BUNDLE.MESSAGE_STOP);
	}

}
