package org.gizmore.jpk.number;

import org.gizmore.jpk.JPKMethod;

public final class JPKOr extends JPKArithmetic implements JPKMethod  {

	public String getName() { 
		
		return "OR"; 
		
	}
	
	public String getHelp() {
		
		return "Apply an OR key to the numbers.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		return arithmetic(input, METHOD_OR);
		
	}

}
