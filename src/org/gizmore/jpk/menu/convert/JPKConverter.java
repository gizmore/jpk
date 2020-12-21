package org.gizmore.jpk.menu.convert;

import org.gizmore.jpk.JPKMethod;

public abstract class JPKConverter implements JPKMethod {

	protected int menuID;
	
	protected String getInputType(final int menuID) {
		
		switch (menuID) {
		case MENU_ASCII: return "Ascii";
		case MENU_BINARY: return "Binary";
		case MENU_NUMBER:
		case MENU_NUMBER_CONVERT:
			return "Number";
		default: return "Error";
		}
		
	}
	
	public JPKConverter(final int menuID) {
		
		this.menuID = menuID;
		
	}
	
	public int getMenuID() {
		
		return menuID;
		
	}

	
}
