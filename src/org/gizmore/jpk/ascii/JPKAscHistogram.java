package org.gizmore.jpk.ascii;

import java.util.StringTokenizer;

public final class JPKAscHistogram extends JPKAsciiMethod {

	public int getMenuID() {
		
		return MENU_ASCII;
		
	}

	public String getName() { 
	
		return "Histogram";
		
	}
	
	public String getHelp() {
		
		return "Create a histogram from the text.";
		
	}
	
	public int getMnemonic() {
		
		return java.awt.event.KeyEvent.VK_CONTROL + java.awt.event.KeyEvent.VK_H;
		
	}
	
	public String getKeyStroke() {

		return "";

	}

	private static final int HG_DIGIT = 0;
	private static final int HG_LOWERCASE = 1;
	private static final int HG_UPPERCASE = 2;
	private static final int HG_SPACE = 3;
	private static final int HG_NEWLINE = 4;
	private static final int HG_OTHER_CHAR = 5;
	private static final int HG_NUM_TYPES = 6; // length of enums !

	public String execute(final String text) {
		
//		final int[] count = count(text);
		
		final StringBuilder result = new StringBuilder(2048);
		
		result.append(count(text));

		result.append(countRowsAndWords(text));
		
		return result.toString();
		
	}
	
	private String count (final String text) {
		
		final int countSize = 0x10000;
		final int[] count = new int[countSize];
		final int[] types = new int[HG_NUM_TYPES];
		final char[] in = text.toCharArray();
		final int len = in.length;
		
		for (int i = 0; i < len; i ++) {
			
			int type;
			
			if (isLowercase(in[i])) {
				type = HG_LOWERCASE;
			}
			else if (isUppercase(in[i])) {
				type = HG_UPPERCASE;
			}
			else if (isDigit(in[i])){
				type = HG_DIGIT;
			}
			else if (in[i] == ' ' || in[i] == '\t') {
				type = HG_SPACE;
			}
			else if(in[i] == '\n') {
				type = HG_NEWLINE;
			}
			else {
				type = HG_OTHER_CHAR;
			}
			
			types[type]++; // count type
			count[in[i]]++;  // count char
		
		}

		final StringBuilder back = new StringBuilder(8192);
		
		back.append(String.format("Total chars: %d\n", in.length));
		back.append(String.format("Lower: %d; Upper: %d; Digits: %d; Total: %d\n", 
					types[HG_LOWERCASE], types[HG_UPPERCASE], types[HG_DIGIT], 
					types[HG_LOWERCASE]+types[HG_UPPERCASE]+types[HG_DIGIT]));
		back.append(String.format("Whitespace: %d; Newline: %d; Unknown: %d\n", types[HG_SPACE], types[HG_NEWLINE], types[HG_OTHER_CHAR]));
		
		back.append(" Hex|  Dec|C|   Occurance\n");
		
		for (int i = 0; i < countSize; i++) {
			
			if (count[i] == 0) {
				continue;
			}
			
			back.append(String.format("%4x|%5d|%c|%d\n", i, i, i, count[i]));
			
		}
		
		return back.toString();
		
	}
	
/*	private String output(final int[] types, final int[] count) {
		
		final StringBuilder output = new StringBuilder(8192);

		output.append(String.format("Total known chars: %d\n", count[HG_KNOWN_CHAR]));
		output.append(outSeq('0', count, HG_DIGIT, 10));
		output.append(outSeq('A', count, HG_UPPERCASE, 13));
		output.append(outSeq('N', count, HG_UPPERCASE+13, 13));
		output.append(outSeq('a', count, HG_LOWERCASE, 13));
		output.append(outSeq('n', count, HG_LOWERCASE+13, 13));
		output.append(String.format("Lowercase"))
		output.append(String.format("Whitespace: %d\n", count[HG_SPACE]));
		output.append(String.format("Whitespace + known: %d\n", (count[HG_SPACE]+count[HG_KNOWN_CHAR])));
		output.append(String.format("Others: %d\n", count[HG_OTHER_CHAR]));
		
		return output.toString();

	}
	
	private String outSeq(final char c, final int[] count, final int offset, final int len) {
		
		final StringBuilder back = new StringBuilder(len*8);
		
		for (int i = 0; i < len; i++)
			back.append(String.format("%c(%d) ", c+i, count[offset+i]));
		
		return back.append('\n').toString();
		
	}
*/	
	private String countRowsAndWords(final String text) {
		
		final String[] lines = getLines(text);
		final int len = lines.length;
		final StringBuilder result = new StringBuilder(128);
		
		result.append(String.format("%d lines\n", len));
		
		for (int i = 0; i < len; i++) {
			
			final StringTokenizer st = new StringTokenizer(lines[i]);
			final int nWords = st.countTokens();
			
			if (nWords > 0)	{
				result.append(String.format("Line %d(%d chars): %d words.\n", i+1, lines[i].length(), st.countTokens()));
			}
			
		}
		
		return result.toString();
		
	}

}
