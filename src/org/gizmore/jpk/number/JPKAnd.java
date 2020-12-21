package org.gizmore.jpk.number;

import org.gizmore.jpk.JPKMethod;

public final class JPKAnd extends JPKArithmetic implements JPKMethod {

	public String getName() { 
		
		return "And"; 
		
	}
	
	public String getHelp() {
		
		return "Apply an AND key to the values.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		return arithmetic(input, METHOD_AND);
		
	}
	
}
