package org.gizmore.jpk.ascii.decrypt;

import javax.swing.JOptionPane;

import org.gizmore.jpk.ascii.JPKAsciiMethod;

public final class JPKKeyedCaesar extends JPKAsciiMethod {
	
	public int getMenuID() {
		
		return MENU_ASCII_DECRYPT;
		
	}

	public String getName() { 
		
		return "Keyed Caesar";
		
	}
	
	public String getHelp() {
		
		return "Apply caesar decipherment by using a keyword";
		
	}
	
	public int getMnemonic() {
		
		return 0;
		
	}
	
	public String getKeyStroke() {

		return "";

	}

	private static String lastKey = "caesar";
	
	public String execute(final String input) {
		
		String keyString = JOptionPane.showInputDialog("Enter Keyword", lastKey);
		
		if (keyString == null) {
			return null;
		}

		keyString = validateKey(keyString.toLowerCase());

		if (keyString.length() == 0) {
			return null;
		}
		
		lastKey = keyString;
		
		return keyedCaesar(input.toLowerCase(), keyString.toLowerCase());
		
	}
	
	private String validateKey(final String key) {
		
		final int len = key.length();
		final StringBuilder back = new StringBuilder(len);
		char c;
		
		for (int i = 0; i < len; i++) {
			c = key.charAt(i);
			if (isLowercase(c)) {
				back.append(c);
			}
		}
		
		return back.toString();
		
	}
	
	private int[] phraseToKey(final String key) {
		
		final int len = key.length();
		final int[] back = new int[len];
		
		for (int i = 0; i < len; i++) {
			
			back[i] = key.charAt(i) - 'a';
			
		}
		
		return back;
		
	}
	
	private String keyedCaesar(final String text, final String key) {
		
		final int len = text.length();
		final int keylen = key.length();
		final StringBuilder back = new StringBuilder(len);

		final int[] k = phraseToKey(key);
		final char[] txt = text.toLowerCase().toCharArray();
		char c;
		
		int taken = 0;
		for (int i = 0; i < len; i++)
		{
			
			c = txt[i];
			
			if (isLowercase(c)) {

				c += k[taken%keylen];
				
				if (c > 'z') {
					c -= 26;
				}
				taken++;
			}
			
			back.append(c);
			
		}
		
		return back.toString();
		
	}

}
