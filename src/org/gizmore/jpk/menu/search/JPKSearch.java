package org.gizmore.jpk.menu.search;

import javax.swing.JOptionPane;

//import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;

public final class JPKSearch implements JPKMethod {

	private static String searchString = "";
	
	public String getName() { 
		
		return "Search";
	
	}
	
	public int getMenuID() {
		
		return MENU_SEARCH;
		
	}
	
	public String getHelp() {
		
		return "Search for a String in the text area.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "ctrl shift S";

	}

	public String execute(final String text) {
		
		final String uIn = JOptionPane.showInputDialog("Enter your search string", searchString);
		
		if (uIn != null) {
			searchString = uIn;
		}

		return new JPKSearchNext().execute(text);
		
	}
	
	public static String getSearchString() {
		
		return searchString;
		
	}
	
}
