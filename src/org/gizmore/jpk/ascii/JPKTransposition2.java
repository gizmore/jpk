package org.gizmore.jpk.ascii;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKTransposition2 extends JPKClass implements JPKMethod {

	public String getHelp() {
		return "Take input as single line and show possible transposition grids";
	}

	public String getKeyStroke() {
		return null;
	}

	public int getMenuID() {
		return MENU_ASCII;
	}

	public int getMnemonic() {
		return 0;
	}

	public String getName() {
		return "Transposition2";
	}

	public String execute(String text) {

		text = formatInput(text);
		
		final int len = text.length();
		final StringBuilder back = new StringBuilder(len * len / 2);
		
		for (int i = 2; i < len; i++) {
			
			if ((len % i) != 0) {
				continue;
			}
			
			back.append(showGrid(text, i));
			
		}
		
		return back.toString();
		
	}
	
	private String formatInput(String text) {
		
		text = text.replaceAll(" ", "");
		text = text.replaceAll("\n", "");
		text = text.trim();
		
		return text;
		
	}

	private String showGrid(final String text, final int linelen) {
		
		final int textlen = text.length();
		final StringBuilder back = new StringBuilder();
		
		for (int i = 0; i < textlen; i += linelen) {
			
			back.append(text.substring(i, i+linelen));
			back.append('\n');
			
		}
		
		back.append('\n');
		
		return back.toString();
		
	}
	
}
