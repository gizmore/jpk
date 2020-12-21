package org.gizmore.jpk.binary;

import org.gizmore.jpk.JPKMethod;

public final class JPKComplement1 implements JPKMethod {

	public String getName() { 
		
		return "C1"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_BINARY;
		
	}
	
	public String getHelp() {
		
		return "Builds the complement 1 of the binary.";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		return input.replace('0', '2').replace('1', '0').replace('2', '1');

	}

}
