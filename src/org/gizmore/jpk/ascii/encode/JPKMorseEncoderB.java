package org.gizmore.jpk.ascii.encode;

import org.gizmore.jpk.ascii.JPKAsciiMethod;

public final class JPKMorseEncoderB extends JPKAsciiMethod {

	public String getName() { 
		
		return "EnMorseB"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_ASCII_ENCODE;
		
	}

	public String getHelp() {
		
		return "Encodes a text in a binary morse stream, using zeros and ones.";
		
	}
	
	public int getMnemonic() {
		
		return 0;
		
	}
	
	public String getKeyStroke() {

		return "";

	}

	public String execute(String text) {
		
		text = new JPKMorseEncoderA().execute(text);
		
		final int len = text.length();

		StringBuilder back = new StringBuilder(len*8);
		
		for (int i = 0; i < len; i++) {
			
			char c = text.charAt(i);
			
			if (c == '.') {
				back.append("10");
			}
			else if (c == '-') {
				back.append("110");
			}
			else if (c == ' ') {
				back.append("0");
			}
			
		}
		
		return back.toString();
		
	}
	
}
