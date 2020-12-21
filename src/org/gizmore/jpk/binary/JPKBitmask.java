package org.gizmore.jpk.binary;

import javax.swing.JOptionPane;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKBitmask extends JPKClass implements JPKMethod {

	public String getName() { 
		
		return "Bitmask"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_BINARY;
		
	}
	
	public String getHelp() {
		
		return "keeps only bits of a specified mask. for example thats for lsb masking techniques.";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		final int bpb = jpk.getBitsPerBlock();
		final String proposal = toBinary(1, bpb);

		final String userInput = JOptionPane.showInputDialog("Specify the bitmask", proposal);
		if (userInput == null)
			return null;
		if (userInput.length() != bpb) {
			JOptionPane.showMessageDialog(null, "Your bitmask length has to be == bits per block\nAborted.");
			return null;
		}
		
		return lsbitmask(input, userInput);
		
	}
	
	private String lsbitmask(final String input, final String bitmask) {

		final int bml = bitmask.length();
		final String[] lines = getLines(input);
		final int len = lines.length;
		final char[] bmca = bitmask.toCharArray();
		final StringBuilder result = new StringBuilder(len*bml);
		
		for (int i = 0; i < len; i++) {
			
			char[] inca = lines[i].toCharArray();
			
			for (int j = 0; j < bml; j++)
				if (bmca[j] == '1')
					result.append(inca[j]);
			
		}
		
		return result.toString();
		
	}

}
