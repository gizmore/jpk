package org.gizmore.jpk.binary;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKRotBlockL extends JPKClass implements JPKMethod {

	public String getName() { 
		
		return "<<"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_BINARY;
		
	}
	
	public String getHelp() {
		
		return "Rotates all bit blocks left";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		final String[] lines = getLines(input);
		final int len = lines.length;
		final StringBuilder back = new StringBuilder(input.length());
		
		for (int i = 0; i < len; i++) {
			
			back.append(lines[i].substring(1));
			back.append(lines[i].charAt(0));
			back.append('\n');
			
		}
		
		return back.toString();		

	}

}
