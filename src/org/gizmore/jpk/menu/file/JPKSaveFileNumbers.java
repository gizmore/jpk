package org.gizmore.jpk.menu.file;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;

public final class JPKSaveFileNumbers implements JPKMethod {

	public String getName() { 
		
		return "Save File Number"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_FILE;
		
	}
	
	public String getHelp() {
		
		return "Save file. (Input is treated as numbers)";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String text) {
		
		JPK.getInstance().setInputMethod(JPK.NUMBER);
		
		return new JPKSaveFile().execute(text);
		
	}

}
