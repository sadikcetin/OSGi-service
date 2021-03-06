package org.sifirbir.osgi.manager.language.impl;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.framework.ServiceRegistration;
import org.sifirbir.osgi.language.api.ILanguage;
import org.sifirbir.osgi.manager.api.command.IManagerCommand;

public class LanguageManagerCommand  implements CommandProvider, IManagerCommand {
	
	
	private ServiceRegistration<ILanguage> serviceReferece=null;

	public void _c(CommandInterpreter ci) {

		int serviceCount = getServiceCount();
		if (serviceCount == 0) {
			ci.println("NO SERVICE :) ");
		}
		ci.print("Service Count : " + serviceCount + "\n");

	}
	public void _addlang(CommandInterpreter ci) {
		String code = ci.nextArgument();
		String state = ci.nextArgument();
		String speak = ci.nextArgument();
		ci.println("Code " + code);
		ci.println("State : " + state);
		ci.println("Speak : " + speak);
		Activator.registerDynamicLanguage(code, state, speak);

	}

	public void _removelang(CommandInterpreter ci) {
		String code = ci.nextArgument();
		LanguageManagerImpl.getInstance().removeDynamicService(code);
		serviceReferece = Activator.dynamicServiceReferenceList.get(code);
		serviceReferece.unregister();
		
		
	}

	public void _print(CommandInterpreter ci) {
		ci.println(LanguageManagerImpl.getInstance().getServiceInfo());
	}

	public void _speak(CommandInterpreter ci) {
		String arg = ci.nextArgument();
		String message = null;
		if (arg != null && arg.trim().length() > 0) {
			message = LanguageManagerImpl.getInstance().speak(arg);
			if (message == null) {
				ci.println(arg + "  I Have Not Found Any Service");
			} else
				ci.println(message);
		} else {
			ci.println(" Please Enter \"speak [language_code]\" Form");
			ci.println("Example: speak tr");
		}
	}

	@Override
	public String getHelp() {

		StringBuffer string = new StringBuffer();

		string.append("###################################### COMMANDS #####################################\n");
		string.append("Default Language Codes: [tr | en | de]                                               \n");
		string.append("\n");
		string.append("Commands                                                                  Description\n");
		string.append("---------                                                                 -----------\n");
		string.append("c                                 --->                           Active Service Count\n");
		string.append("speak [code]                      --->                 Speaks Passed by Language Code\n");
		string.append("removelang [code]                 --->                 Remove Existing Language Service");
		string.append("print                             --->              Print Avaliable Language Services\n");
		string.append("addlang [code] [speak] [state]    --->    Add New Dynamic Lang With code,Speak&State \n");
		string.append("\n");
		string.append("#####################################################################################\n");

		return string.toString();
	}

	@Override
	public int getServiceCount() {
		return LanguageManagerImpl.getInstance().getRegisteredLanguageCount();
	}

}
