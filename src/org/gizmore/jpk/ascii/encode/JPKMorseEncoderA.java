package org.gizmore.jpk.ascii.encode;

import org.gizmore.jpk.ascii.JPKAsciiMethod;
import org.gizmore.jpk.ascii.decode.JPKMorseDecoder;

public final class JPKMorseEncoderA extends JPKAsciiMethod {
	
	public String getName() { 
		
		return "EnMorseA"; 
		
	}
	
	public String getHelp() {
		
		return "Encodes a text in morse, using dashes and dots.";
		
	}
	
	public int getMnemonic() {
		
		return 0;
		
	}
	
	public String getKeyStroke() {

		return "";

	}

	public int getMenuID() {
		
		return MENU_ASCII_ENCODE;
		
	}

	public String execute(String text) {
		
		text = text.toLowerCase();

		final int len = text.length();
		
		JPKMorseDecoder decoder = new JPKMorseDecoder();
		
		final StringBuilder back = new StringBuilder(len*3);
		
		final String[] morseChars = decoder.getMorseCharacters();
		final String[] morseDigits = decoder.getMorseDigits();
		
		for (int i = 0; i < len; i++) {
			
			char c = text.charAt(i);
			if (isLowercase(c)) {
				back.append(morseChars[c-'a']);
				back.append(" ");
			}
			else if (isDigit(c)) {
				back.append(morseDigits[c-'0']);
				back.append(" ");
			}
			
		}
		
		return back.toString();
		
	}

}
