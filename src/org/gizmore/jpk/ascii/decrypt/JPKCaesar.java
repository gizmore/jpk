package org.gizmore.jpk.ascii.decrypt;

import org.gizmore.jpk.ascii.JPKAsciiMethod;

public final class JPKCaesar extends JPKAsciiMethod {

	public String getName() { 
		
		return "Caesar"; 
		
	}

	public int getMenuID() {
		
		return MENU_ASCII_DECRYPT;
		
	}

	public String getHelp() {
		
		return "Apply 25 caesar shifts.";
		
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
		final StringBuilder back = new StringBuilder((len+1)*26);
		
		for (int i = 0; i < 26; i++) {
			
			for (int j = 0; j < len; j++) {
				if (isUppercase(ca[j])) {
					if (ca[j] == 'Z')
						ca[j] = 'A';
					else ca[j]++;
				}
				else if (isLowercase(ca[j])) {
					if (ca[j] == 'z')
						ca[j] = 'a';
					else ca[j]++;
				}
			}
			
			back.append(ca);
			back.append('\n');
		}
		
		return back.toString();
		
	}

}
