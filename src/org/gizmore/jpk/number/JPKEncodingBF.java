package org.gizmore.jpk.number;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;
import org.gizmore.jpk.input.JPKNumber;

public final class JPKEncodingBF extends JPKClass implements JPKMethod {
	
	private static String[] encodings = null;
	private static boolean isInited = false;
	
	private static void initEncodings() {
		
		if (isInited == true)
			return;
		
		final Charset[] csa = Charset.availableCharsets().values().toArray(new Charset[0]);
		final int len = csa.length;
		
		encodings = new String[len];
		
		for (int i = 0; i < len; i++)
			encodings[i] = csa[i].toString();
		
		isInited = true;
	}
	
	public String getName() { 
		
		return "CharsetBF"; 
		
	}
	
	public String getHelp() {
		
		return "Apply all available character encodings.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public int getMenuID() {
		
		return MENU_NUMBER;
		
	}
	
	public String execute(final String input) {
	
		initEncodings();
		final int len = encodings.length;
		final StringBuilder back = new StringBuilder((input.length()+50)*len);
		
		for (int i = 0; i < len; i++)
			back.append(String.format("%s: %s\n", encodings[i], toEncodedString(input, encodings[i])));
		
		return back.toString();
		
	}	

	public String toEncodedString (final String input, final String encoding) {
		
		final ByteBuffer bb = ByteBuffer.wrap(new JPKNumber().toByteArray(input));
		final Charset charset = Charset.forName(encoding);
		
		return charset.decode(bb).toString();
		
	}

}
