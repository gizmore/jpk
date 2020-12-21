package org.gizmore.jpk.number;

import javax.swing.JOptionPane;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKGroupNums extends JPKClass implements JPKMethod {
	
	public String getName() { 
		
		return "Group Nums";
	
	}
	
	public int getMenuID() {
		
		return MENU_DEVNULL;
		
	}
	
	public String getHelp() {
		
		return "Groups Numbers";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	private static String inputString = "2";
	
	public String execute(final String text) {
		
		final String uIn = JOptionPane.showInputDialog("Number group count", inputString);
		
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
		
		final String[] lines = this.getLines(text);
		final int len = lines.length;
		final StringBuilder back = new StringBuilder(text.length());
		
		String group;
		
		for (int i = 0; i < len;) {
			
			group = new String();
			
			for (int k = 0; k < n; k++) {
				
				if (i == len) {
					break;
				}
				
				group = String.format("%s\t%s", group, lines[i++].trim());
				
			}
			
			back.append(String.format("%s\n", group.trim()));
			
		}
		
		return back.toString();
		
	}
	
}
