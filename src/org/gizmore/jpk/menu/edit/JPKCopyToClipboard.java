package org.gizmore.jpk.menu.edit;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;

public final class JPKCopyToClipboard implements JPKMethod {
	
	public String getName() { 
		
		return "Copy"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_EDIT;
		
	}

	public String getHelp() {
		
		return "Copy selected text to clipboard";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "ctrl C";

	}

	public String execute(final String text) {
		
		JPK.getInstance().getMacro().copyToClipboard();
		
		return null;
		
	}


}
