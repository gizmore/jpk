package org.gizmore.jpk.input;

import org.gizmore.jpk.JPKClass;

public abstract class JPKInput extends JPKClass {
	
	public abstract String format(final String input);
	public abstract String toAscii(final String input);
	public abstract String toBinary(final String input);
	public abstract String toNumber(final String input, final int outRadix);
	public abstract byte[] toFile(final String input);

}
