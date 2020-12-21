package org.gizmore.jpk.ascii.decrypt;

import org.gizmore.jpk.JPKMethod;

public final class JPKBaconian implements JPKMethod {

	public String getName() { return "Bacon"; }
	
	public int getMenuID() {
		
		return MENU_ASCII_DECRYPT;
		
	}

	public String getHelp() {
	
		return "Apply different methods of baconian decoding.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	private static int baconMode = 0;
	
	public static void setBaconMode(int mode) {
		
		baconMode = mode;
		
	}
	
	private static char baconMiddle = 'm';
	
	public static void setBaconMiddle(final char middle) {
		
		baconMiddle = middle;
		
	}
	
	private static final char[][] baconModes = {
		
		{ '1', '1', '0', '0' },
		{ '0', '0', '1', '1' },
		{ '1', '0', ' ', ' ' },
		{ '0', '1', ' ', ' ' },
		{ ' ', ' ', '1', '0' },
		{ ' ', ' ', '0', '1' },
		{ '1', '0', '1', '0' },
		{ '1', '0', '0', '1' },
		{ '0', '1', '1', '0' },
		{ '0', '1', '0', '1' },

	};

	public static final int nBaconModes = baconModes.length;

	public String execute(final String input) {
	
		final char middle = baconMiddle;
		final int mode = baconMode;
		
		final char[] in = input.toCharArray();
		final StringBuilder output = new StringBuilder(in.length*25);

		final char[] baconMode = baconModes[mode];
		final String binary = streamBaconian(in, middle, baconMode[0], baconMode[1], baconMode[2], baconMode[3]);
		output.append("Mode "+mode+": "+binary);
		final String baconascii = baconBinToBaconAscii(binary);
		output.append(" | Bacon: "+baconascii);
		final String ascii = baconAsciiToAscii(baconascii);
		output.append(" | Ascii: "+ascii+"\n");
		
		return output.toString();
	}

	private static String streamBaconian(final char[] in, final char middle, final char um, final char uz, final char lm, final char lz) {
	
		final char ul = Character.toUpperCase(middle);
		final char ll = Character.toLowerCase(middle);
		final int len = in.length;
		final StringBuilder result = new StringBuilder(len);
		
		for (int i = 0; i < len; i++) {
			
			final char c = in[i];
			
			if (c >= 'a' && c <= ll)
				result.append(lm);
			else if (c > ll && c <= 'z')
				result.append(lz);
			else if (c >= 'A' && c <= ul)
				result.append(um);
			else if (c > ul && c <= 'Z')
				result.append(uz);
			
		}
		
		return result.toString();
		
	}
	
	private static String baconBinToBaconAscii (final String binary) {
		
		final StringBuilder bacon = new StringBuilder(5);
		final char[] bin = binary.toCharArray();
		final int len = bin.length;
		final StringBuilder result = new StringBuilder((len/5)+1);
		
		for (int i = 0; i < len; i++) {
			
			if(bin[i] == '1' || bin[i] == '0')
				bacon.append(bin[i]);
	
			if (bacon.length() == 5) {
				result.append((char)('A'+Integer.parseInt(bacon.toString(), 2)));
				bacon.delete(0, 5);
			}
			
		}
		if (bacon.length() > 0) {
			result.append((char)('A'+Integer.parseInt(bacon.toString(), 2)));
		}
		
		return result.toString();
		
	}
	
	private static String baconAsciiToAscii (final String bacon) {
		
		final char[] ca = bacon.toCharArray();
		final int len = ca.length;
		
		for (int i = 0; i < len; i ++) {
			
			if (ca[i] > 'U')
				ca[i] += 2;
			else if (ca[i] > 'I')
				ca[i] += 1;
			
		}
		
		return new String(ca);
		
	}

}
