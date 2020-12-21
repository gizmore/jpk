package org.gizmore.jpk.ascii.decode;

import org.gizmore.jpk.JPKMethod;

import sun.misc.BASE64Decoder;

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
			final String back = new String(new BASE64Decoder().decodeBuffer(input));
			return back;
		}
		catch (Exception e) {
			return e.toString();
		}
		
	}

}
