package org.sifirbir.osgi.manager.language.impl;

import java.util.HashMap;
import java.util.Map;

import org.omg.Messaging.SyncScopeHelper;
import org.sifirbir.osgi.language.api.ILanguage;
import org.sifirbir.osgi.manager.api.IManager;

public class LanguageManagerImpl implements IManager<ILanguage> {

	private static LanguageManagerImpl INSTANCE = null;
	private Map<String, ILanguage> languageList = null;

	private LanguageManagerImpl() {
		languageList = new HashMap<String, ILanguage>();
	}

	public static LanguageManagerImpl getInstance() {
		if (INSTANCE == null)
			INSTANCE = new LanguageManagerImpl();
		return INSTANCE;
	}

	@Override
	public void startService(ILanguage service) {
		this.languageList.put(service.code(), service);
		System.out.println("## " + service.code() + "Par" + service + " Service ACTIVATED.");
	}
	
	@Override
	public void stopService(ILanguage service) {
		this.languageList.remove(service.code());
		System.out.println("## " + service.code() + " Service STOPPING...RESOLVED.");
	}

	public int getRegisteredLanguageCount() {
		return this.languageList.size();
	}

	public String speak(String code) {
		String result = null;
		ILanguage lang = this.languageList.get(code);
		if (lang != null) // exception yapilacak
			result = lang.speak();
		return result;
	}

	public void removeDynamicService(String code) {

		ILanguage element = this.languageList.get(code);
		if (element != null) {
			this.languageList.remove(element.code());
		}

	}

	public String getServiceInfo() {
		StringBuilder builder = new StringBuilder();
		if (this.languageList.size() > 0) {
			for (ILanguage lang : this.languageList.values())
				if (!lang.getClass().getSimpleName().equals("")) {
					builder.append(lang.code()).append(",").append(lang.getClass().getSimpleName()).append("\n");
				} else {
					builder.append(lang.code()).append(",").append(Configuration.BUNDLE.MESSAGE_DYNAMIC_SERVICE).append("\n");
				}

		} else {
			builder.append("THERE IS NO AVALIABLE LANG SERVICE YET.");
		}
		return builder.toString();
	}

}
