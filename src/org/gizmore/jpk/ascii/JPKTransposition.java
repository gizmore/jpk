package org.gizmore.jpk.ascii;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKTransposition extends JPKClass implements JPKMethod {
	
	public String getName() { 
		
		return "Transposition"; 
		
	}

	public int getMenuID() {
		
		return MENU_ASCII;
		
	}

	public String getHelp() {
		
		return "Re-arrange the text by coloumns (very simple transpsition)";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String text) {
		
		final String[] lines = getLines(text);
		final StringBuilder back = new StringBuilder(text.length());
		
		final int nLines = lines.length;
		final int lineLen = lines[0].length();
		
		for (int i = 0; i < nLines; i++) {
			if (lines[i].length() != lineLen) {
				return "The lines have to be of the same length";
			}
		}
		
		for (int x = 0; x < lineLen; x++) {
			for (int y = 0; y < nLines; y++) {
				
				back.append(lines[y].charAt(x));
				
			}
			back.append('\n');
		}
		
		return back.toString();
		
	}

}
