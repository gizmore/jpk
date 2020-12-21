package org.gizmore.jpk.ascii;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public abstract class JPKAsciiMethod extends JPKClass implements JPKMethod {

	protected static boolean isChar(final char c) {
		
		return (isUppercase(c) || isLowercase(c));
		
	}
	
	protected static boolean isDigit(final char c) {
		
		return c >= '0' && c <= '9';
		
	}
	
	protected static boolean isLowercase (final char c) {
		
		return c >= 'a' && c <= 'z';
		
	}
	
	protected static boolean isUppercase (final char c) {
		
		return c >= 'A' && c <= 'Z';
		
	}
	
	protected static boolean isReadableAscii (final char c) {
		
		return c >= 0x20 && c <= 0x7f;
		
	}
	
	protected static boolean isWhitespace(final char c)
	{
		return c == ' ' || c == '\n' || c == '\t' || c == '\r';
	}

}
