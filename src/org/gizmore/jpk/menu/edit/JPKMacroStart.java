package org.gizmore.jpk.menu.edit;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;

public final class JPKMacroStart implements JPKMethod {

	public String getName() { 
		
		return "Record Macro"; 
		
	}

	public int getMenuID() {
		
		return MENU_EDIT;
		
	}

	public String getHelp() {
		
		return "Record keystrokes for playback (Buggy)";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "strg shift M";

	}

	public String execute(final String text) {
		
		JPK.getInstance().getMacro().startCapture();
		
		JPK.getInstance().getTextArea().requestFocus();
		
		return null;
		
	}
	
}
