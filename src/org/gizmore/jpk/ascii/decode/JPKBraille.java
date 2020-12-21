package org.gizmore.jpk.ascii.decode;

import javax.swing.JOptionPane;

import org.gizmore.jpk.JPKMethod;
import org.gizmore.jpk.ascii.JPKAsciiMethod;

public final class JPKBraille extends JPKAsciiMethod implements JPKMethod {

	public String getName()
	{
		return "Braille Decode";
	}

	public int getMenuID() { return MENU_ASCII_DECODE; }
	public int getMnemonic() { return 0; }
	public String getKeyStroke() { return null; }
	
	public String getHelp()
	{
		return "Braille Decoder; (What blind people write)";
	}

	private static String config = "o+";

	public String execute(String text)
	{
		String conf = null;
		if (null == (conf = configure(config))) {
			return "Misconfigured ! Use 2 different chars; no whitespace allowed\n"+text;
		}
		return brailleDecode(text.replaceAll(" ", ""), conf);
	}
	
	private String configure(String oldConfig)
	{
		final String uIn = JOptionPane.showInputDialog("2 Characters used: ", oldConfig);
		
		if (uIn == null) {
			return null;
		}
		if (uIn.length() != 2) {
			return null;
		}
		if (uIn.charAt(0) == uIn.charAt(1)) {
			return null;
		}
		if (isWhitespace(uIn.charAt(0)) || isWhitespace(uIn.charAt(1))) {
			return null;
		}
		config = uIn;
		return uIn;
	}

	private static char[] braille = 
	{
		'?', '?', '?', '?', '?', '?', '?', '?', // 0-7
		'?', '?', '?', '?', '?', '?', '?', '?', // 8-15
		'?', '?', '?', '?', '?', '?', '?', '?', // 16-23
		'I', '?', 'S', '?', 'J', 'W', 'T', '?', // 24-31
		'A', '?', 'K', 'U', 'E', '?', 'O', 'Z', // 32-39
		'B', '?', 'L', 'V', 'H', '?', 'R', '?', // 40-47
		'C', '?', 'M', 'X', 'D', '?', 'N', 'Y', // 48-55
		'F', '?', 'P', '?', 'G', '?', 'Q', '?', // 56-63
	};
	
	private String brailleDecode(final String text, final String conf)
	{
		final String[] lines = getLines(text);
		final StringBuilder back = new StringBuilder(text.length() / 6);
		final int nLines = lines.length;
		char zero = conf.charAt(0);
		char one = conf.charAt(1);
		int x;
		
		
		for (int y = 0; y < nLines; y += 3)
		{
			if (nLines < y+3) {
				break;
			}
			x = 0;
			while (true)
			{
				if (x+1 > lines[y].length()) {
					break;
				}
				int debraille = 0;
				if (lines[y].charAt(x) != zero && lines[y].charAt(x) != one) {
					break;
				}
				
				if (lines[y].charAt(x) == one) {
					debraille += 0x20;
				}
				if (lines[y].charAt(x+1) == one) {
					debraille += 0x10;
				}
				if (lines[y+1].charAt(x) == one) {
					debraille += 0x08;
				}
				if (lines[y+1].charAt(x+1) == one) {
					debraille += 0x04;
				}
				if (lines[y+2].charAt(x) == one) {
					debraille += 0x02;
				}
				if (lines[y+2].charAt(x+1) == one) {
					debraille += 0x01;
				}
				
//				back.append(debraille);
//				back.append('\n');
				
				back.append(braille[debraille]);
				
				x += 2;
			}
			back.append('\n');
		}
		return back.toString();
	}
}
