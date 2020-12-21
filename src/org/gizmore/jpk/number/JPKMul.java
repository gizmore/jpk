package org.gizmore.jpk.number;

import org.gizmore.jpk.JPKMethod;

public final class JPKMul extends JPKArithmetic implements JPKMethod {

	public String getName() { 
		
		return "Mul"; 
		
	}
	
	public String getHelp() {
		
		return "Multiply numbers by a repeated key.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		return arithmetic(input, METHOD_MUL);
		
	}

}
