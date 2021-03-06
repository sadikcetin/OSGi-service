package org.sifirbir.osgi.manager.language.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.sifirbir.osgi.language.api.ILanguage;

public class Activator implements BundleActivator, ServiceTrackerCustomizer<ILanguage, ILanguage> {

	private ServiceTracker<ILanguage, ILanguage> serviceTrackerLanguage;
	private static BundleContext context = null;
	private ServiceRegistration<CommandProvider> serviceRegistrationCommand;
	public static Map<String, ServiceRegistration> dynamicServiceReferenceList = new HashMap<String, ServiceRegistration>();
	private ConfigurationAdmin co;

	public static void registerDynamicLanguage(final String code, final String state, final String speak) {

		ServiceRegistration<ILanguage> dynamicServiceReference;

		if (context != null) {
			dynamicServiceReference = context.registerService(ILanguage.class, new ILanguage() {

				@Override
				public String state() {
					return state;
				}

				@Override
				public String speak() {
					return speak;
				}

				@Override
				public String code() {
					return code;
				}
			}, null);
			System.out.println("CODE : " + code);
			System.out.println("asdasd" + dynamicServiceReference);
			dynamicServiceReferenceList.put(code, dynamicServiceReference);
		}

	}

	@Override
	public void start(BundleContext arg0) throws Exception {
		Activator.context = arg0;
		System.out.println(Configuration.BUNDLE.MESSAGE_START);
		trackILanguageService();
		serviceRegistrationCommand = context.registerService(CommandProvider.class, new LanguageManagerCommand(), null);
		System.out.println(serviceRegistrationCommand);
		System.out.println("Bundle ID :" + context.getBundle().getBundleId());
		System.out.println("Location :" + context.getBundle().getLocation());
		System.out.println("Last Modified :" + context.getBundle().getLastModified());
		System.out.println("State: " + context.getBundle().getState());
		System.out.println("Symbolic Name: " + context.getBundle().getSymbolicName());
		System.out.println("Version: " + context.getBundle().getVersion());
		System.out.println("*******************s********************************************");
		
	System.out.println("CONF : "+co.SERVICE_FACTORYPID);

	}
	
	private void trackILanguageService() {
		serviceTrackerLanguage = new ServiceTracker<ILanguage, ILanguage>(Activator.context, ILanguage.class, this);
		serviceTrackerLanguage.open();

	}

	private void unTrackILanguageService() {
		serviceTrackerLanguage.close();
		serviceTrackerLanguage = null;
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		Activator.context = null;
		System.out.println(Configuration.BUNDLE.MESSAGE_STOP);
		unTrackILanguageService();
		if (serviceRegistrationCommand != null) {
			serviceRegistrationCommand.unregister();
		}
	}

	@Override
	public ILanguage addingService(ServiceReference<ILanguage> arg0) {
		ILanguage service = Activator.context.getService(arg0);
		LanguageManagerImpl.getInstance().startService(service);
		return service;
	}

	@Override
	public void modifiedService(ServiceReference<ILanguage> arg0, ILanguage arg1) {

	}

	@Override
	public void removedService(ServiceReference<ILanguage> arg0, ILanguage arg1) {
		LanguageManagerImpl.getInstance().stopService(arg1);
	}

}
