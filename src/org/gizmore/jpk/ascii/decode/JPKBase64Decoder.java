package org.gizmore.jpk.ascii.decode;

import java.util.Base64;

import org.gizmore.jpk.JPKMethod;

public final class JPKBase64Decoder implements JPKMethod {

	public String getName() { 
		
		return "Base64"; 
		
	}

	public int getMenuID() {
		
		return MENU_ASCII_DECODE;
		
	}

	public String getHelp() {
		
		return "Decodes a base64 string.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		try {
			final String back = new String(Base64.getDecoder().decode(input));
			return back;
		}
		catch (Exception e) {
			return e.toString();
		}
		
	}

}
