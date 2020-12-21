package org.gizmore.jpk.menu.about;

import org.gizmore.jpk.JPKMethod;

public final class JPKAsciiTable implements JPKMethod {

	public String getName() { 
		
		return "AsciiTable"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_ABOUT;
		
	}

	public String getHelp() {
		
		return "Prints an Ascii table in various [useless] formats";
		
	}
	
	public int getMnemonic() {
		
		return 0;
		
	}
	
	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		StringBuilder back = new StringBuilder(2048);
		
		back.append(simpleTable());
		back.append(asciiTable());
		
		return back.toString();
		
	}
	
	private String simpleTable() {
		
		return 
			"         1          2      \n"+
			"1234567890123 4567890123456\n"+
			"abcdefghijklm nopqrstuvwxyz\n"+
			"0123456789012 3456789012345\n";
		
	}
	
	private String asciiTable() {
		
		final StringBuilder back = new StringBuilder(1024);
		
		for (int i = 0x20; i < 0x7f; i++) {
			
			back.append(String.format("%3X", i));
			
		}
		
		back.append('\n');
		
		for (int i = 0x20; i < 0x7f; i++) {
			
			back.append(String.format("  %c", (char)i));
			
		}
		back.append('\n');
		
		back.append('\n');
		for (int i = 0; i < 26; i++) {
			
			back.append(String.format("%2d ", i));
			
		}
		back.append('\n');
		
		for (int i = 0; i < 26; i++) {
			
			back.append(String.format(" %c ", (char)(i+'A')));
			
		}
		back.append('\n');

		return back.toString();
		
	}

}
