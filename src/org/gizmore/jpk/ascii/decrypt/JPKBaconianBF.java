package org.gizmore.jpk.ascii.decrypt;

import javax.swing.JOptionPane;
import org.gizmore.jpk.JPKMethod;

public final class JPKBaconianBF implements JPKMethod {

	public String getName() { return "Bacon Brute"; }
	
	public int getMenuID() {
		
		return MENU_ASCII_DECRYPT;
		
	}

	public String getHelp() {
	
		return "Apply ALL different methods of baconian decoding.";
		
	}

	public String toString() {

		return "Baconian";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		final String userInput = JOptionPane.showInputDialog("Specify middle character", "m");
		if (userInput == null)
			return null;
		
		JPKBaconian.setBaconMiddle(userInput.charAt(0));
		
		StringBuilder output;
		try {
			output = new StringBuilder(input.length()*250);
		} catch (Exception e) {
			return e.toString();
		}
		
		JPKBaconian decoder = new JPKBaconian();
		
		output.append("Plain  :"+input+"\n");
		for (int i = 0; i < JPKBaconian.nBaconModes; i++) {
			
			JPKBaconian.setBaconMode(i);
			output.append(decoder.execute(input));
			
		}
		
		return output.toString();
		
	}
	
}
