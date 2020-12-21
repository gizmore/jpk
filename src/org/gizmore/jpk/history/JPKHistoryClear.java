package org.gizmore.jpk.history;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;

public final class JPKHistoryClear implements JPKMethod  {

	public String getName() { return "Clear"; }
	
	public int getMenuID() {
		
		return MENU_NONE;
		
	}

	public String getHelp() {
		
		return "Clear the history. Clearing an empty history clears the text area.";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String text) {

		if (JPK.getInstance().getHistory().getHistorySize() == 0) {
			
			JPK.getInstance().getTextArea().setText("");
//			JPK.getInstance().getHistory().pop();
			return null;
			
		} else {
			 
			JPK.getInstance().getHistory().clear();
			return null;			

		}
		
	}

}
