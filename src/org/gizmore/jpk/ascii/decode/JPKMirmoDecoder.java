package org.gizmore.jpk.ascii.decode;

import org.gizmore.jpk.JPKMethod;
import org.gizmore.jpk.ascii.JPKAsciiMethod;

public final class JPKMirmoDecoder extends JPKAsciiMethod implements JPKMethod
{
	public String getHelp() {
		return "Simple Numeric Decoder, with a variable numeric length (like utf8)";
	}

	public String getKeyStroke() {
		return null;
	}

	public int getMenuID() {
		return MENU_ASCII_DECODE;
	}

	public int getMnemonic() {
		return 0;
	}

	public String getName() {
		return "Mirmo Decoder";
	}

	public String execute(final String text)
	{
		final int len = text.length();
		final StringBuilder back = new StringBuilder(len);
		
		if (text.charAt(0) != 'S' || text.indexOf("SeCrEt") != 0) {
			return "You have to enter a secret phrase at the beginning, because it will solve a particular challenge instantly.\nHowever you can download JPK and hack your way out.";
		}

		char c, c2;
		for (int i = 0; i < len;)
		{
			c = text.charAt(i++);
			
			if (!isDigit(c)) {
				back.append(c);
				continue;
			}
			
			c2 = text.charAt(i++);
			if (!isDigit(c2)) {
				back.append("\nERROR: Not proper encoded file.\n");
				continue;
			}
			
			back.append(mirmoDecode(c, c2));
		}
		return back.toString();
	}
	
	public static char mirmoDecode(char c1, char c2)
	{
		char base;
		switch (c1) {
		case '0': case '1': case '2':
			base = 'a';
			break;
		case '3':
			base = '1';
			c1 = '0';
			break;
		case '4': case '5': case '6':
			base = 'A';
			c1 -= 4;
			break;
		default:
			return '?';
		}
		return (char) (((((c1-'0')*10)+((c2-'0')))+base-1));
	}
}
