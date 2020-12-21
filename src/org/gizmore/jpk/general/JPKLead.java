package org.gizmore.jpk.general;

import javax.swing.JOptionPane;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKLead extends JPKClass implements JPKMethod {

	public String getName() { 
		
		return "Lead"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_GENERAL;
		
	}
	
	public String getHelp() {
		
		return "Prepends a string to each line, you can add leading 010 here for example.";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		final String uin = JOptionPane.showInputDialog("What to add as lead ?", "010");
		if (uin == null || uin.length() == 0)
			return null;
		
		final String result = trail(input, uin);
		
		jpk.getStatePanel().setBitsPerBlock(jpk.getBitsPerBlock()+uin.length());
		
		return result;
		
	}
	
	private String trail(final String input, final String trail) {

		final int bpb = jpk.getBitsPerBlock();
		final int tlen = trail.length();
		final String[] lines = getLines(input);
		final int len = lines.length;
		final StringBuilder back = new StringBuilder((bpb+tlen+1)*len);
		
		for (int i = 0; i < len; i++) {
			back.append(String.format("%s%s\n", trail, lines[i]));
		}
		
		return back.toString();
		
	}

}
