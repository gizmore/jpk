package org.gizmore.jpk.binary;

import org.gizmore.jpk.JPKMethod;
import org.gizmore.jpk.input.JPKBinary;
import org.gizmore.jpk.menu.search.JPKReplace;

public class JPKRotAllR implements JPKMethod {

	public String getName() { 
		
		return ">>>"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_BINARY;
		
	}
	
	public String getHelp() {
		
		return "Rotates all bits right";
		
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
		final int tlen = temp.length()-1;
		
		result.append(temp.charAt(tlen));
		result.append(temp.substring(0, tlen));
		
		return new JPKBinary().format(result.toString());

	}

}
