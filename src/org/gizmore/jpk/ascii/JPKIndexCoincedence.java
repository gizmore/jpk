package org.gizmore.jpk.ascii;

import org.gizmore.jpk.JPKMethod;

public final class JPKIndexCoincedence implements JPKMethod {

	public String getName() { return "IC"; }
	
	public int getMenuID() {
		
		return MENU_ASCII;
		
	}

	public String getHelp() {
		
		return "Calculate the index of coincedence of _all_ characters; Note: a != A and space is also character.";
		
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
		final int[] count = new int[256];
		
		for (int i = 0; i < len; i++) {
			
			count[ca[i]]++;
			
		}
		
		double sumf1 = 0;
		double sumf2 = 0;
		for (int i = 0; i < 256; i++) {
			
			sumf1 += count[i];
			sumf2 += count[i] * (count[i] - 1);
			
			
		}
		
		return String.format("Index of coincedence: %.3f", (sumf2 / (sumf1 * (sumf1 - 1))));
	}

}
