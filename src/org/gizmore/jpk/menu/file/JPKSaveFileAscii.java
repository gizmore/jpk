package org.gizmore.jpk.menu.file;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;

public final class JPKSaveFileAscii implements JPKMethod {

	public String getName() { 
		
		return "Save File Ascii"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_FILE;
		
	}
	
	public String getHelp() {
		
		return "Save ascii file. (Input is treated as characters)";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String text) {
		
		JPK.getInstance().setInputMethod(JPK.ASCII);
		
		return new JPKSaveFile().execute(text);
		
	}

}
