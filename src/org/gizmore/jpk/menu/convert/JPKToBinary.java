package org.gizmore.jpk.menu.convert;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.input.JPKInput;

public final class JPKToBinary extends JPKConverter {

	public JPKToBinary(final int menuID) {
		
		super(menuID);
		
	}

	public String getName() {
		
		return String.format("%s To Binary", getInputType(menuID));
		
	}
	
	public String getHelp() {
		
		return "Convert current input to Binary.";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

//		return "ctrl B";
		return null;

	}

	public String execute(final String input) {
				
		final JPKInput inFormat = JPK.getInstance().getInputMethod();
		
		JPK.getInstance().setInputMethod(JPK.BINARY);
		
		return inFormat.toBinary(input);
		
	}

}
