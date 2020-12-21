package org.gizmore.jpk.menu.convert;

import org.gizmore.jpk.JPK;

public class JPKFormat extends JPKConverter {

	public JPKFormat(final int menuID) {
		
		super(menuID);
		
	}
	
	public String getName() {
		
		return String.format("%s Format", getInputType(menuID));
		
	}

	public String getHelp() {
		
		return "Format the text and validate its input. You should call format when you change the input type.";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return null;

	}

	public String execute(final String input) {
		
		return JPK.getInstance().getInputMethod().format(input);
		
	}

}
