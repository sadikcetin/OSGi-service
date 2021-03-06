package org.sifirbir.osgi.language.english.impl;

public interface Configuration {
	
	static interface BUNDLE {
		
		public static final String NAME = "SifirBir English Language Bundle";
		public static final String MESSAGE_START = NAME + " STARTED";
		public static final String MESSAGE_STOP = NAME + " STOPPED";
	}
	
	static interface LANG {
		public static final String CODE = "en";
		public static final String MESSAGE_SPEAK = "HELLO !!!";
		public static final String MESSAGE_STATE = "HOW ARE YOU !!!";
	}

}
