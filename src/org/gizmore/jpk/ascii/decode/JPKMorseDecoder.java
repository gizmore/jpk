package org.gizmore.jpk.ascii.decode;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.gizmore.jpk.JPKMethod;

public final class JPKMorseDecoder implements JPKMethod {
	
	public static int MAX_CODE_LENGTH = 5;
	
	private static boolean isInited = false;
	private static Hashtable<String, Character> htMorse = new Hashtable<String, Character>();
	
	private static final String[] morseCharacters = {
		".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
		".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
		".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
	};
	private static final String[] morseDigits = {
		"-----", ".----", "..---", "...--", "....-",
		".....", "-....", "--...", "---..", "----.", 
	};
	
	public String[] getMorseCharacters() {
	
		return morseCharacters;
		
	}
	
	public String[] getMorseDigits() {
		
		return morseDigits;
		
	}
	
	public static void initMorseTable() {
	
		if (isInited)
			return;
		
		for (int i = 0; i < 26; i++)
			htMorse.put(morseCharacters[i], (char)('A'+i));
		for (int i = 0; i < 10; i++)
			htMorse.put(morseDigits[i], (char)('0'+i));
		
		isInited = true;
		
	}

	public String getName() { 
		
		return "DeMorse"; 
		
	}
	
	public String getHelp() {
		
		return "decodes an ascii text of dashes[-] and dots[.] using morse.";
		
	}
	
	public int getMnemonic() {
		
		return 0;
		
	}
	
	public String getKeyStroke() {

		return "";

	}

	public int getMenuID() {
		
		return MENU_ASCII_DECODE;
		
	}

	private String format(final String input) {
		
		final char[] ca = input.toCharArray();
		final int len = ca.length;
		final StringBuilder back = new StringBuilder(len);

		for (int i = 0; i < len; i++)
			
			switch (ca[i]) {
			case '\n': ca[i] = ' ';
			case '.': case '-': case ' ':
				back.append(ca[i]);
				break;
			default: break;
			}
		
		return back.toString();
		
	}
		
	
	public String execute(final String input) {
		
		initMorseTable();
		
		final String morse = format(input);
		final StringTokenizer st = new StringTokenizer(morse);
		final StringBuilder result = new StringBuilder(morse.length()/2);
		
		while (st.hasMoreTokens()) {
			
			result.append(htMorse.get(st.nextToken()));
			
		}
		
		return result.toString();
		
	}
	
	public char morseToChar(final String morse) {
		
		return htMorse.get(morse);
		
	}

}
