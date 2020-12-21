package org.gizmore.jpk.general;

import org.gizmore.jpk.JPKMethod;

public class JPKUppercase implements JPKMethod {

	public int getMenuID() {
		
		return MENU_GENERAL;
		
	}

	public String getName() { 
		
		return "Uppercase"; 
		
	}
	
	public String getHelp() {
		
		return "convert lowercase to uppercase characters.";
		
	}
	
	public int getMnemonic() {
		
		return 0;
		
	}
	
	public String getKeyStroke() {

		return "";

	}
	
	public String execute(final String input) {
		
		return input.toUpperCase();
		
	}

}
