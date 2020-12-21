package org.gizmore.jpk.number;

import org.gizmore.jpk.JPKMethod;

public final class JPKAdd extends JPKArithmetic implements JPKMethod {
	
	public String getName() { 
		
		return "Add"; 
		
	}
	
	public String getHelp() {
		
		return "Add values to the numbers.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		return arithmetic(input, METHOD_ADD);
		
	}

}
