package org.gizmore.jpk.binary;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKRotBlockR extends JPKClass implements JPKMethod {

	public String getName() { 
		
		return ">>"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_BINARY;
		
	}
	
	public String getHelp() {
		
		return "Rotates all bitblocks right";
		
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
			
			final int ll = lines[i].length() - 1;
			
			back.append(lines[i].charAt(ll));
			back.append(lines[i].substring(0,ll));
			back.append('\n');
			
		}
		
		return back.toString();		

	}
	
}
