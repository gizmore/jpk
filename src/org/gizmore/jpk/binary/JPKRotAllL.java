package org.gizmore.jpk.binary;

import org.gizmore.jpk.JPKMethod;
import org.gizmore.jpk.menu.search.JPKReplace;
import org.gizmore.jpk.input.JPKBinary;

public final class JPKRotAllL implements JPKMethod {

	public String getName() { 
		
		return "<<<"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_BINARY;
		
	}
	
	public String getHelp() {
		
		return "Rotates all bits left";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		final int len = input.length();
		final StringBuilder result = new StringBuilder(len);
		final String temp = new JPKReplace().replace(input, "\n", "");
		
		result.append(temp.substring(1));
		result.append(temp.charAt(0));
		
		return new JPKBinary().format(result.toString());
		
	}

}
