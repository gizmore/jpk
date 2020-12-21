package org.gizmore.jpk.number;

import java.util.ArrayList;
import java.util.Comparator;

import org.gizmore.jpk.JPKMethod;
import org.gizmore.jpk.JPKClass;

class Number implements Comparator<Number>{
	
	private int value;
	private int occurance;
	
	public Number(int value) {
		
		this.value = value;
		this.occurance = 1;
		
	}
	
	public void increaseOccurance() {
		
		this.occurance++;
		
	}
	
	public int getValue() {
		
		return this.value;
		
	}
	
	public int getOccurance() {
		
		return this.occurance;
		
	}
	
	public int compare(Number a, Number b) {
		
		return a.getValue() - b.getValue();
		
	}
	
/*	public int compare(Number a, Number b) {
		
		return a.getOccurance() - b.getOccurance();
		
	}*/

}

public final class JPKNumHistogram extends JPKClass implements JPKMethod {
	
	public String getName() { 
		
		return "Histogram";
	
	}
	
	public String getHelp() {
		
		return "calculate a number histogram";
		
	}
	
	public int getMenuID() {
		
		return MENU_NUMBER;
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String input) {
		
		final String[] lines = getLines(input);
		final int nLines = lines.length;
		final int inRadix = jpk.getInRadix();
		final ArrayList<Number> counter = new ArrayList<Number>(nLines);
		
		for (int i = 0; i < nLines; i++) {
			
			try {
				int value = Integer.parseInt(lines[i], inRadix);
				count(value, counter);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		return result(counter);
		
	}
	
	private void count(final int value, final ArrayList<Number> counter) {
		
		final int cs = counter.size();
		
		for (int i = 0; i < cs; i++) {
			
			final Number n = counter.get(i);
			if (n.getValue() == value) {
				n.increaseOccurance();
				return;
			}
			
		}
		
		counter.add(new Number(value));
		
	}
	
	private String result(final ArrayList<Number> counter) {
		
		final int cs = counter.size();
		final StringBuilder result = new StringBuilder(cs * 15 + 60);
		int total = 0;

		result.append("Number Histogram\n");
		result.append("Value: Occurancy\n");
		result.append("-------------------\n");
		
		Number[]numbers = counter.toArray(new Number[0]);
		
		java.util.Arrays.sort(numbers, new Number(0));
		
		for (int i = 0; i < cs; i++) {
		
			final Number n = numbers[i];
			total += n.getOccurance();
			
			result.append(String.format("%d: %d\n", n.getValue(), n.getOccurance()));
			
		}
		
		result.append("-------------------\n");
		result.append(String.format("Total numbers: %d\n", total));
		result.append(String.format("Total different numbers: %d\n", cs));
		
		return result.toString();
		
	}

}
