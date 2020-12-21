package org.gizmore.jpk.general;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKNumReverse extends JPKClass implements JPKMethod {

	public String getName() { 
		
		return "Reverse Lines"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_GENERAL;
		
	}
	
	public String getHelp() {
		
		return "Reverse all lines.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String text) {
		
		final StringBuilder back = new StringBuilder(text.length());
		
		final String[] lines = this.getLines(text);
		
		final int len = lines.length;
		
		int i = len - 1;
		
		while (i >= 0) {
			back.append(lines[i]);
			back.append('\n');
			i--;
		}
		
		return back.toString();
		
	}

}
