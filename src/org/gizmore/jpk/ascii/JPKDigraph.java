package org.gizmore.jpk.ascii;

import java.util.ArrayList;

import org.gizmore.jpk.JPKMethod;

public final class JPKDigraph implements JPKMethod {

	public String getName() { 
		
		return "Digraphs"; 
		
	}

	public int getMenuID() {
		
		return MENU_ASCII;
		
	}

	public String getHelp() {
		
		return "Take digraphs, and convert them into single letters.";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String text) {
		
		final int len = text.length();
		final ArrayList<Digraph> list = new ArrayList<Digraph>(128);
		
		if (len % 2 == 1) {
			return "The text length is not even. (Aborted).";
		}
		
		Digraph.resetCurrentCode();
		int[] result = new int[len/2];
		
		char c1, c2;
		int j, count = 0;
		Digraph current, known = null;
		for (int i = 0; i < len; ) {
			
			c1 = text.charAt(i++);
			c2 = text.charAt(i++);
			current = new Digraph(c1, c2);
			
			for (j = 0; j < list.size(); j++) {
				
				known = list.get(j);
				if (known.equals(current)) {
					break;
				}
				
			}
			
			if (j == list.size()) { // Unknown digraph
				current.setUniqueCode();
				result[count++] = current.getCode();
				list.add(current);
			}
			else { // Digraph was known
				result[count++] = known.getCode();
			}
			
		}

//		System.out.println(String.format("Counted %d different Digraphs.", list.size()));
		
		final StringBuilder back = new StringBuilder(len/2);
		
		for (int i = 0; i < len/2; i++) {
			back.append((char)(result[i]+'A'));
//			System.out.println(result[i]);
		}
		
		return back.toString();
		
	}
	
}
