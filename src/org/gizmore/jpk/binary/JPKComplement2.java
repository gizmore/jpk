package org.gizmore.jpk.binary;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKComplement2 extends JPKClass implements JPKMethod {

	public String getName() { 
		
		return "C2"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_BINARY;
		
	}
	
	public String getHelp() {
		
		return "Builds the complement 2 of the binary.";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		final String[] lines = getLines(input);
		final int len = lines.length;
		final int bpb = jpk.getBitsPerBlock();
		final StringBuilder back = new StringBuilder(len*(bpb+1));
		
		for (int i = 0; i < len; i++) {
			
			final int value = -Integer.parseInt(lines[i], 2);
			
			back.append(toBinary(value, bpb));
			back.append('\n');
			
		}
		
		return back.toString();

	}

}
