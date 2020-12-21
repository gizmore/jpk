package org.gizmore.jpk.general;

import javax.swing.JOptionPane;

import org.gizmore.jpk.JPKMethod;

public final class JPKGroupChars implements JPKMethod {
	
	public String getName() { 
		
		return "Group Chars";
	
	}
	
	public int getMenuID() {
		
		return MENU_GENERAL;
		
	}
	
	public String getHelp() {
		
		return "Groups characters";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	private static String inputString = "2";
	
	public String execute(final String text) {
		
		final String uIn = JOptionPane.showInputDialog("Character group count", inputString);
		
		if (uIn == null) {
			return null;
		}
		
		int n = 0;
		try {
			n = Integer.parseInt(uIn);
			inputString = uIn;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
			
		return group(text, n);
		
	}
	
	public String group(final String text, final int n) {
		
		final char[] ca = text.toCharArray();
		final int len = ca.length;
		final StringBuilder back = new StringBuilder(len);

		int taken = 0;
		for (int i = 0; i < len; i++) {
			
			if (ca[i]=='\n' || ca[i] == ' ') {
				continue;
			}
			
			back.append(ca[i]);
			
			if (++taken == n) {
				taken = 0;
				back.append('\n');
			}
			
		}
		
		back.append('\n');
		return back.toString();
		
	}
	
}
