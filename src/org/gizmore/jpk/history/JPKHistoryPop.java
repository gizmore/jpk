package org.gizmore.jpk.history;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;
import org.gizmore.jpk.JPKState;

public final class JPKHistoryPop implements JPKMethod {

	public int getMenuID() {
		
		return MENU_NONE;
		
	}

	public String getName() { 
		
		return "<";
		
	}
	
	public String getHelp() {
		
		return "Pop one page of the history. You can not walk forward again.";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String text) {
		
		JPKState state = JPK.getInstance().getHistory().pop();
		 
		if (state != null) {
			JPK.getInstance().setState(state);
		}
		
		return null;
		
	}

}
