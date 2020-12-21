package org.gizmore.jpk.number;

import org.gizmore.jpk.JPKMethod;

public final class JPKXor extends JPKArithmetic implements JPKMethod  {

	public String getName() { 
		
		return "Xor"; 
		
	}
	
	public String getHelp() {
		
		return "Apply an XOR key to the numbers.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		return arithmetic(input, METHOD_XOR);
		
	}

}
