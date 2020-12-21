package org.gizmore.jpk.ascii;

public final class Digraph {

	private static int currentCode = 0;
	
	public static void resetCurrentCode() {
		
		currentCode = 0;
		
	}
	
	private char c1 = 0, c2 = 0;
	private int code = 0;
	
	public Digraph(char c1, char c2) {
		
		this.c1 = c1;
		this.c2 = c2;
		
	}
	
	public void setUniqueCode() {
		
		code = currentCode++;
		
	}
	
	public int getCode() {
		return code;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o instanceof Digraph) {
			Digraph d = (Digraph) o;
			return d.c1 == c1 && d.c2 == c2;
		}
		
		return false;
		
	}
	
	@Override
	public String toString() {
		
		return String.format("%c%c", c1, c2);
		
	}
	
}
