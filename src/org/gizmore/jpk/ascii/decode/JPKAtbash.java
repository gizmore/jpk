package org.gizmore.jpk.ascii.decode;

import org.gizmore.jpk.ascii.JPKAsciiMethod;

public final class JPKAtbash extends JPKAsciiMethod {

	public int getMenuID() {
		
		return MENU_ASCII_DECODE;
		
	}

	public String getName() { 
		
		return "Atbash"; 
		
	}
	
	public String getHelp() {
		
		return "decodes a text using atbash.";
		
	}
	
	public int getMnemonic() {
		
		return 0;
		
	}
	
	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		final char[] ca = input.toCharArray();
		final int len = ca.length;
		
		for (int i = 0; i < len; i++) {
			
			if (isUppercase(ca[i])) {
				int c = ca[i] - 'A';
				c = 25 - c;
				ca[i] = (char)('A' + c);
			}
			else if (isLowercase(ca[i])) {
				int c = ca[i] - 'a';
				c = 25 - c;
				ca[i] = (char)('a' + c);
			}
		}
		
		return new String(ca);
		
	}

}
