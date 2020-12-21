package org.gizmore.jpk.number;

import org.gizmore.jpk.JPKMethod;
import org.gizmore.jpk.input.JPKNumber;

import sun.misc.BASE64Encoder;

public final class JPKBase64Encoder implements JPKMethod  {

	public String getName() { 
		
		return "Base64 Encode"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_NUMBER;
		
	}
	
	public String getHelp() {
		
		return "Encodes the numbers to a base64 string.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		try {
			return new BASE64Encoder().encode(new JPKNumber().toByteArray(input));
		}
		catch (Exception e) {
			return e.toString();
		}
		
	}

}
