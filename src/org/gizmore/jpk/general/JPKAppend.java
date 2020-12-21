package org.gizmore.jpk.general;

import javax.swing.JOptionPane;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKAppend extends JPKClass implements JPKMethod {

	public String getName() { 
		
		return "Append"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_GENERAL;
		
	}
	
	public String getHelp() {
		
		return "Append a string to each line, you can add trailing 010 here for example.";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		final String uin = JOptionPane.showInputDialog("What to append ?", "010");
		if (uin == null || uin.length() == 0) {
			return null;
		}
		
		final String result = append(input, uin);
		
		jpk.getStatePanel().setBitsPerBlock(jpk.getBitsPerBlock()+uin.length());
		
		return result;
		
	}
	
	private String append(final String input, final String append) {

		final int bpb = jpk.getBitsPerBlock();
		final int tlen = append.length();
		final String[] lines = getLines(input);
		final int len = lines.length;
		final StringBuilder back = new StringBuilder((bpb+tlen+1)*len);
		
		for (int i = 0; i < len; i++) {
			back.append(String.format("%s%s\n", lines[i], append));
		}
		
		return back.toString();
		
	}

}
