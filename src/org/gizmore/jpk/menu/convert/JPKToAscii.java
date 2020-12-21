package org.gizmore.jpk.menu.convert;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.input.JPKInput;

public final class JPKToAscii extends JPKConverter {

	public JPKToAscii(final int menuID) {
		
		super(menuID);
		
	}
	
	public String getName() {
		
		return String.format("%s To Ascii", getInputType(menuID));
		
	}

	public String getHelp() {
		
		return "Convert current input to Ascii.";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		//return "ctrl A";
		return null;

	}

	public String execute(final String input) {
		
		JPKInput inFormat = JPK.getInstance().getInputMethod();
		
		JPK.getInstance().setInputMethod(JPK.ASCII);
		
		return inFormat.toAscii(input);
		
	}

}
