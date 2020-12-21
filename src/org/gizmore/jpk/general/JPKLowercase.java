package org.gizmore.jpk.general;

import org.gizmore.jpk.JPKMethod;

public final class JPKLowercase implements JPKMethod {

	public int getMenuID() {
		
		return MENU_GENERAL;
		
	}

	public String getName() { 
		
		return "Lowercase"; 
		
	}
	
	public String getHelp() {
		
		return "convert uppercase to lowercase characters.";
		
	}
	
	public int getMnemonic() {
		
		return 0;
		
	}
	
	public String getKeyStroke() {

		return "";

	}
	
	public String execute(final String input) {
		
		return input.toLowerCase();
		
	}

}
