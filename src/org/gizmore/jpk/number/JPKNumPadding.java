package org.gizmore.jpk.number;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKNumPadding extends JPKClass implements JPKMethod {
	
	public String getName() { 
		
		return "0 Pad"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_NUMBER;
		
	}
	
	public String getHelp() {
		
		return "Pads all numbers with 0's. '1 12' => '01 12'";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	/*
	 * Pad each line with 0's to an equal line length
	 */
	public String execute(final String text) {
		
		final String[] lines = getLines(text);
		final int len = lines.length;

		int curLen = 0;
		int maxLen = 0;
		
		// Calc max line length
		for (int i = 0; i < len; i++) {
			curLen = lines[i].length();
			if (curLen > maxLen) {
				maxLen = curLen;
			}
		}
		
		final StringBuilder back = new StringBuilder(len*(maxLen+1)+1); 
		
		
		for (int i = 0; i < len; i++) {
			
			// Pad
			curLen = maxLen - lines[i].length();
			for (int j = 0; j < curLen; j++) {
				back.append('0');
			}
			
			// Add line
			back.append(lines[i]);
			back.append('\n');
		}
		
		return back.toString();

	}
	
}
