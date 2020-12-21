package org.gizmore.jpk.history;

import org.gizmore.jpk.JPKMethod;

public final class JPKHistoryPush implements JPKMethod  {

	public String getName() { 
		
		return ">"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_NONE;
		
	}

	public String getHelp() {
		
		return "Copy the current text to history.";
		
	}

	public int getMnemonic() {
	
		return 0;
	
	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {

		return input;
		
	}

}
