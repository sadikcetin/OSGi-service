package org.sifirbir.osgi.language.english.impl;

import org.sifirbir.osgi.language.api.ILanguage;

public class EnglishLangImpl implements ILanguage {

	@Override
	public String speak() {
		return Configuration.LANG.MESSAGE_SPEAK;
	}

	@Override
	public String state() {
		return (Configuration.LANG.MESSAGE_STATE);

	}

	@Override
	public String code() {
		return Configuration.LANG.CODE;
	}

}
