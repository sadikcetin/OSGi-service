package org.sifirbir.osgi.language.german.impl;

public interface Configuration {
	static interface BUNDLE {
		
		public static final String NAME = "SifirBir German Language Bundle";
		public static final String MESSAGE_START = NAME + " STARTED";
		public static final String MESSAGE_STOP = NAME + " STOPPED";
	}
	
	static interface LANG {
		public static final String CODE = "de";
		public static final String MESSAGE_SPEAK = "HALLO !!!";
		public static final String MESSAGE_STATE = "WIE GEHT ES IHNEN ???";
	}
}
