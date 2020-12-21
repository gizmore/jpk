package org.gizmore.jpk;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class JPKClass {
	
	protected static JPK jpk;
	
	public static void setStaticJPK(final JPK main) {
		
		jpk = main;
		
	}

	// --- Binary --- //
	
	public String toBinary(final long value, final int bitsPerBlock) {
		
//		System.out.println(value);
		final String binaryString = Integer.toBinaryString((int)value);
		return leadBinaryZero(binaryString, bitsPerBlock);
		
	}

	private String leadBinaryZero(final String binaryString, int bitsPerBlock) {
		
		final StringBuilder result = new StringBuilder(bitsPerBlock);
		final int bsl = binaryString.length();
		final int len = bitsPerBlock - bsl;

		if (len < 0) { // CUT OVERFLOW
			
			result.append(binaryString.substring(bsl-bitsPerBlock, bsl));
			
		}
		else { // TRAIL ZEROS
			
			for (int i = 0; i < len; i++)
				result.append('0');
			
			result.append(binaryString);
			
		}
		
		return result.toString();
		
	}
	
	// --- getLines --- //
	
	protected String[] getLines (final String text) {
		
		final ArrayList<String> back = new ArrayList<String>(100);
		final Scanner scan = new Scanner(text);
		
		String line;
		while (scan.hasNextLine()) {

			line = scan.nextLine();
			
			line = line.trim();
			
			if (line.length() > 0) {
				back.add(line);
			}
		}
			
		return back.toArray(new String[0]);		
		
	}

	/* convert a string like "10 20 30" to int[]
	 * TODO: bad implementation
	 * */
	public static int[] stringToIntArray (final String s, final int radix) {
		
		final Scanner scan = new Scanner(s);
		final ArrayList<Integer> list = new ArrayList<Integer>(100);
		
		while (scan.hasNext()) {
			
			if (scan.hasNextInt(radix)) {
				
				final int i = scan.nextInt(radix);

				list.add(new Integer(i));
				
			} else scan.next();
			
		}
		
		/* convert from Integer[] to int[] */
		final Integer[] ba = list.toArray(new Integer[0]);
		final int len = ba.length;
		final int[] rba = new int[len];
		
		for (int i = 0; i < len; i++) {
			rba[i] = ba[i];
		}
		
		return rba;

	}

	public static int[] hexStringToIntArray (final String s) {
		
		final int len = s.length() / 2;
		final int[] result = new int[len];
				
		for (int i = 0; i < len; i++) {
			
			final String t = s.substring(i*2, i*2+2);
			result[i] = Integer.parseInt(t, 16);
			
		}
		
		return result;
		
	}

}
