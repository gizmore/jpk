package org.gizmore.jpk.menu.about;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;

import javax.swing.JOptionPane;

public final class JPKAbout implements JPKMethod {

	private static final String aboutTitle = "About " + JPK.programName;
	private static final String aboutMessage =
		
		JPK.programName + JPK.version + "\n" +
		"last changes: " + JPK.releaseDate + "\n" +
		JPK.copyString + "\n";
	
	
	public String getName() { 
		
		return "About";
	
	}
	
	public int getMenuID() {
		
		return MENU_ABOUT;
		
	}

	public String getHelp() {
		
		return "Shows an about nag-screen.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {

		JOptionPane.showMessageDialog(null, aboutMessage, aboutTitle, JOptionPane.INFORMATION_MESSAGE);
		
		return null;
		
	}

}
