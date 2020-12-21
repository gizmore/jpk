package org.gizmore.jpk.input;

public final class JPKAscii extends JPKInput {

	@ Override
	public String format(final String input) {
		
		final char[] ca = input.toCharArray();
		final int len = ca.length;
		final StringBuilder sb = new StringBuilder(len);
		
		for (int i = 0; i < len; i++) {
			
			if (ca[i] == '\n') {
				ca[i] = ' ';
			}
			
			else if (ca[i] == ' ') {
				ca[i] = '\n';
			}
			
			sb.append(ca[i]);
			
		}

		return sb.toString();
		
	}
	
	@ Override
	public String toAscii(final String input) {
		
		return null;
		
	}
	
	@ Override
	public String toBinary(final String input) {
		
		final char[] ca = input.toCharArray();
		final int len = ca.length;
		final StringBuilder sb = new StringBuilder(len*9);
		
		for (int i = 0; i < len; i++) {
			
			sb.append(toBinary(ca[i], 8));
			sb.append('\n');
			
		}
		
		return sb.toString();
		
	}
	
	@ Override
	public String toNumber(final String input, final int outRadix) {
		
		final char[] ca = input.toCharArray();
		final int len = ca.length;
		final StringBuilder sb = new StringBuilder(len*9);
		
		for (int i = 0; i < len; i++) {
			
			sb.append(Integer.toString(ca[i], outRadix));
			sb.append('\n');
			
		}
		
		return sb.toString();
		
	}

	@ Override
	public byte[] toFile(final String input) {
		
		return input.getBytes();
		
	}
	
}
