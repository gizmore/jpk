package org.gizmore.jpk.menu.search;

import javax.swing.JTextArea;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;
import org.gizmore.jpk.menu.search.JPKSearch;

public final class JPKSearchNext implements JPKMethod {

	public String getName() { 
		
		return "Search Next"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_SEARCH;
		
	}
	
	public String getHelp() {
		
		return "Search next occurance of a String in the text area.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "ctrl S";

	}

	public String execute(final String text) {
		
		final String ss = JPKSearch.getSearchString();
		final int ssl = ss.length();
		
		if (ssl == 0) {
			return null;
		}
		
		final JTextArea tain = JPK.getInstance().getTextArea();
		tain.grabFocus();
		
		final int start = tain.getSelectionEnd();
		final int found = text.indexOf(ss, start);
		
		if (found == -1)
			tain.setCaretPosition(0);
		else {
//			System.out.println("Found at "+found);
			tain.setSelectionStart(found);
			tain.setSelectionEnd(found+ssl);
		}
		
		return null;
		
	}
	
}
