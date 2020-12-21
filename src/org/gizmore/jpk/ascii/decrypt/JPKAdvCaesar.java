package org.gizmore.jpk.ascii.decrypt;

import javax.swing.JOptionPane;

import org.gizmore.jpk.ascii.JPKAsciiMethod;

public final class JPKAdvCaesar extends JPKAsciiMethod {

	public int getMenuID() {
		
		return MENU_ASCII_DECRYPT;
		
	}
	
	public String getName() { 
	
		return "Adv Caesar";
		
	}
	
	public String getHelp() {
		
		return "Bruteforce caesar with changing key. (is that railfence?)";
		
	}
	
	public int getMnemonic() {
		
		return java.awt.event.KeyEvent.VK_CONTROL + java.awt.event.KeyEvent.VK_H;
		
	}
	
	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		final String userIn = JOptionPane.showInputDialog("Insert key step:", "1" );
		if (userIn == null)
			return null;
		
		try {
			
			final int step = Integer.parseInt(userIn);
			
			return advCaesarBF(input, step);
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "");
			return null;
			
		}
		
	}
	
	private String advCaesarBF(final String input, final int step) {
		
		final int len = input.length();
		final StringBuilder back = new StringBuilder(len*26);
		
		for (int i = 0; i < 26; i++)
			back.append(String.format("%s\n", advCaesar(input, i, step)));
		
		return back.toString();

	}
	
	private String advCaesar(final String input, final int startKey, final int step) {
		
		final char[] ca = input.toCharArray();
		final int len = ca.length;
		
		int key = startKey;
		for (int i = 0; i < len; i++) {
			
			ca[i] = caesarChar(ca[i], key%26);
			key += step;
			
		}
		
		return new String(ca);
	}
	
	private char caesarChar(char c, final int key) {
		
		if (isUppercase(c)) {
			
			c += key;
			if (c > 'Z')
				c -= 26;
			else if (c < 'A')
				c += 26;
			
		} else if (isLowercase(c)) {
			
			c += key;
			if (c > 'z')
				c -= 26;
			else if (c < 'a')
				c += 26;
			
		}
		
		return c;
		
	}
	
}
