package org.gizmore.jpk.binary;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKXORStream extends JPKClass implements JPKMethod {

	public String getHelp() {
		return "XOR 2 lines of binary data [In case you have a one time pad key]";
	}

	public String getKeyStroke() {
		return null;
	}

	public int getMenuID() {
		return MENU_BINARY;
	}

	public int getMnemonic() {
		return 0;
	}

	public String getName() {
		return "Binary XOR OTP";
	}

	public String execute(String text) {

		final String[] lines = getLines(text);
		
		if (lines.length != 2) {
			return "Can operate on 2 lines only.\n";
		}
		if (lines[0].length() != lines[1].length()) {
			return "The two lines have to be of the same length.\n";
		}
		
		final int len = lines[0].length();
		final StringBuilder back = new StringBuilder(len);
		char a, b;
		for (int x = 0; x < len; x++)
		{
			a = lines[0].charAt(x);
			b = lines[1].charAt(x);
			if (a != '1' && a != '0') {
				continue;
			}
			if (b != '1' && b != '0') {
				continue;
			}
			if (a == b) {
				back.append('0');
			}
			else {
				back.append('1');
			}
		}
		
		return back.toString();
	}


}
