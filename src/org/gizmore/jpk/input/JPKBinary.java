package org.gizmore.jpk.input;

import java.util.Scanner;

public final class JPKBinary extends JPKInput {

	@ Override
	public String format(final String input) {
		
		final int bpb = jpk.getBitsPerBlock();
		final char[] ca = input.toCharArray();
		final int len = ca.length;
		final StringBuilder block = new StringBuilder(bpb);
		final StringBuilder result = new StringBuilder(len);
		
		for (int i = 0; i < len; i++) {
			
			if (ca[i] == '0' || ca[i] == '1') {
				block.append(ca[i]);
			}
			
			if (block.length() == bpb) {
				result.append(block);
				result.append("\n");
				block.delete(0, bpb);
			}
			
		}
		
		if (block.length() > 0) {
			result.append(block);
			result.append("\n");
		}
		
		return result.toString();
		
	}
	
	@ Override
	public String toAscii(final String input) {
		
		final int len = input.length();
		final int bpb = jpk.getBitsPerBlock();
		final int nc = (len / bpb);
		final StringBuilder sb = new StringBuilder(nc); 
		final Scanner scan = new Scanner(input);
		
		while (scan.hasNextLine()) {
			
			try {
				sb.append((char)(Integer.parseInt(scan.nextLine(), 2)));
			} catch (Exception e) {
				sb.append(e.toString());
				sb.append('\n');
			}
			
		}
		
		return sb.toString();

	}
	
	@ Override
	public String toBinary(final String input) {
		
		return format(input);

	}
	
	@ Override
	public String toNumber(final String input, final int outRadix) {
		
		final String[] lines = getLines(input);
		final int nLines = lines.length;
		final StringBuilder result = new StringBuilder(nLines * 6);
		
		for (int i = 0; i < nLines; i++) {
			
			try {
				long val = Long.parseLong(lines[i], 2);
				result.append(Long.toString(val, outRadix));
				result.append('\n');
			} catch (Exception ex) {
				System.out.println(ex);
			}
			
		}
		
		return result.toString();

	}

	@ Override
	public byte[] toFile(String input) {
		
		input = new org.gizmore.jpk.menu.convert.JPKToNumber(-1).execute(input);
		
		return org.gizmore.jpk.JPK.getInstance().getInputMethod().toFile(input);
		
	}
	
}
