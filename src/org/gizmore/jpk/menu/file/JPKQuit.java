package org.gizmore.jpk.menu.file;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;

public final class JPKQuit implements JPKMethod {

	public String getName() { 
		
		return "Quit"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_FILE;
		
	}
	
	public String getHelp() {
		
		return "Exit JPK.";
		
	}

	public String getKeyStroke() {

		return "ctrl shift Q";

	}

	public int getMnemonic() {

		return 0;

	}

	public String execute(String input) {
		
		JPK.getInstance().quit();
		
		return "";

	}

}
