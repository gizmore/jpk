package org.gizmore.jpk.number;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKDivisors extends JPKClass implements JPKMethod {

	public String getHelp() {
		return "shows all even divisors for the first number";
	}

	public String getKeyStroke() {
		return null;
	}

	public int getMenuID() {
		return MENU_NUMBER;
	}

	public int getMnemonic() {
		return 0;
	}

	public String getName() {
		return "Show Divisors";
	}

	public String execute(final String text) {
		
		final String[] lines = getLines(text);
		final String line = lines[0];
		
		try {
			final int inRadix = jpk.getInRadix();
			int value = Integer.parseInt(line, inRadix);
			return showDivisors(value);
		}
		catch (Exception e) {
			return e.toString();
		}

	}
	
	public String showDivisors(final int value) {
		
		final StringBuilder back = new StringBuilder(2048);
		
		back.append(String.format("Divisors for %d:\n", value));
		
		for (int i = 1; i < value; i++) {
			
			if ((value % i) != 0) {
				continue;
			}
			
			back.append(String.format("%d\n", i));
			
		}
		
		return back.toString();
		
	}

}
