package org.gizmore.jpk.number;

import java.util.ArrayList;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKNumberSubstitute extends JPKClass implements JPKMethod {

	public String getHelp() {

		return "Substitutes numbers by letters.";
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
		return "Number Substitute";
	}

	public String execute(final String text) {

		final String[] lines = getLines(text);
		final ArrayList<Integer> list = new ArrayList<Integer>(lines.length);
		final int inRadix = jpk.getInRadix();		
		final StringBuilder back = new StringBuilder(lines.length);
		
		int temp;
		
		for (int i = 0; i < lines.length; i++) {
			
			try {
				
				Integer current = Integer.parseInt(lines[i], inRadix);
				
				temp = -1;
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).equals(current)) {
						temp = j;
					}
				}
				
				if (temp == -1) {
					temp = list.size();
					list.add(current);
				}
				
				char c = temp > 25 ? (char)('A'+temp-26) : (char)('a'+temp);
				
				back.append(c);
				
			}
			catch (Exception e) {
				
			}
			
		}
		
		return back.toString();
		
	}


}
