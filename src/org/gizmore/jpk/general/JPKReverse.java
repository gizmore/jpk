package org.gizmore.jpk.general;

import org.gizmore.jpk.JPKMethod;

public class JPKReverse implements JPKMethod {

	public String getName() { 
		
		return "Reverse"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_GENERAL;
		
	}

	public String getHelp() {
		
		return "Reverses the text.";
		
	}
	
	public int getMnemonic() {
		
		return 0;
		
	}
	
	public String getKeyStroke() {

		return "";

	}
	
	public String execute(final String input) {
		
		final StringBuilder back = new StringBuilder(input);
		
		return back.reverse().toString();
		
	}

}
