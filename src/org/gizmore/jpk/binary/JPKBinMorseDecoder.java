package org.gizmore.jpk.binary;

import javax.swing.JOptionPane; 
import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;
import org.gizmore.jpk.ascii.decode.JPKMorseDecoder;

public final class JPKBinMorseDecoder extends JPKClass implements JPKMethod {

	public String getName() { 
		
		return "Morse Decode"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_BINARY;
		
	}
	
	public String getHelp() {
		
		return "Decodes a binary stream as morse.";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {

		final String uin = JOptionPane.showInputDialog("Need some Input:\n DahLen CharPause", "2 2");
		if (uin == null)
			return null;

		final int[] siglens = stringToIntArray(uin, 10);
		
		if (siglens.length != 2) {
			JOptionPane.showMessageDialog(null, "You have to enter 2 decimal values");
			return null;
		}

		
		jpk.setInputMethod(JPK.ASCII);
		
		return binaryToMorse(input, siglens[0], siglens[1]);
		
	}
	
	private String format(final String input, final int charpause) {
		
		final char[] ca = input.toCharArray();
		final int len = ca.length;
		final StringBuilder back = new StringBuilder(len);
		
		for (int i = 0; i < len; i++)
			switch (ca[i]) {
			case '0': case '1': back.append(ca[i]);
			}

		for (int i = 0; i < len; i++)
			back.append("0");
		back.append("1");
		
		return back.toString();
		
	}
	
//	private static final int MAX_SYMBOL_LENGTH = 8;
	public String binaryToMorse(final String binary, final int dahlen, final int charpause) {
		
		final char[] signal = format(binary, charpause).toCharArray();
		final int len = signal.length;
		final StringBuilder morsechar = new StringBuilder(JPKMorseDecoder.MAX_CODE_LENGTH);
		final StringBuilder back = new StringBuilder(len/3);
		final char[] morseSymbols = { '.', '-' };
	
		int pause = 0;
		int symbol = 0;
		for (int i = 0; i < len; i++) {
			
			if (signal[i] == '1') {
				
				if (pause > 0) {
					
					if (pause >= charpause) {
						
						back.append(String.format("%s ", morsechar.toString()));
						morsechar.delete(0, JPKMorseDecoder.MAX_CODE_LENGTH);
						
					}
					
					pause = 0;
					
				}
				
				symbol++;
				
			} else {
				
				if (symbol > 0) {
					morsechar.append(morseSymbols[symbol >= dahlen ? 1 : 0]);
					symbol = 0;
				}
				
				pause++;
				
			}
			
			
		}
		
		return back.toString();
		
	}
	
}
