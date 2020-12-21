package org.gizmore.jpk.menu.search;

import javax.swing.JOptionPane;

//import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;

public final class JPKReplace implements JPKMethod {

	private static String search, replace;
	
	public String getName() { 
		
		return "Replace"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_SEARCH;
		
	}
	
	public String getHelp() {
		
		return "Replace a string in the text area, using regular expressions.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "ctrl R";

	}

	public String execute(final String text) {
		
		final String sIn = JOptionPane.showInputDialog("Enter your regex search string", search);
		if (sIn == null) {
			return null;
		}
		
		final String rIn = JOptionPane.showInputDialog("Enter your replacement string ($1-n for backreference)", replace);
		if (rIn == null) {
			return null;
		}
		
		search = sIn;
		replace = rIn;
		
		return replace(text, sIn, rIn);
		
	}
	
	public String replace(final String text, final String search, final String replace) {
		
		try {
			return text.replaceAll(search, replace);
		}
		catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		
	}
//ufinasoosmpwtuaybibsobasoosmpwitcbimssimwmdffimwmdpsnisscmopapthfmppbtdplolacaogbfmafcilogihfmppmtdrpbinogmtnsftspgibfimfyansaatsssbtgstaspbimufnsfmopsfsrmsnslm	

}
