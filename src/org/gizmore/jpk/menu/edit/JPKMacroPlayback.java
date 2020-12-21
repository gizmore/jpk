package org.gizmore.jpk.menu.edit;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;

public final class JPKMacroPlayback implements JPKMethod {

	public String getName() { 
		
		return "Playback Macro"; 
		
	}

	public int getMenuID() {
		
		return MENU_EDIT;
		
	}

	public String getHelp() {
		
		return "Replay the current recorded macro (Buggy)";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "ctrl M";

	}

	public String execute(final String text) {
		
		JPK.getInstance().getTextArea().requestFocus();
		
		JPK.getInstance().getMacro().stopCapture();
		
		JPK.getInstance().getMacro().repeatCapture();
		
		return null;
		
	}

}
