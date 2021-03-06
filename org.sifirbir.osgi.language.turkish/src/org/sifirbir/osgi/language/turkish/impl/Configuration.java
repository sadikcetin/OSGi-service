package org.sifirbir.osgi.language.turkish.impl;

public interface Configuration {

	static interface BUNDLE {
		public static final String NAME = "SifirBir Turkish Language Bundle";
		public static final String MESSAGE_START = NAME + " STARTED";
		public static final String MESSAGE_STOP = NAME + " STOPPED";
	}
	
	static interface LANG {
		public static final String CODE = "tr";
		public static final String MESSAGE_SPEAK = "MERHABALAR !!!";
		public static final String MESSAGE_STATE = "NASILSINIZ ???";
	}
	
}
