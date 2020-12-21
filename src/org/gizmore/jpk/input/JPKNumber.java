package org.gizmore.jpk.input;

import java.math.BigInteger;
import java.util.Scanner;

import javax.swing.JOptionPane;

public final class JPKNumber extends JPKInput {

	public byte[] toByteArray(String input) {
		
		final String[] lines = getLines(input);
		final int len = lines.length;
		final byte[] back = new byte[len];
		final int inRadix = jpk.getInRadix();
		
		for (int i = 0; i < len; i++) {
			
			back[i] = (byte)Integer.parseInt(lines[i], inRadix);
			
		}
		
		return back;
		
	}

	@ Override
	public String format(final String input) {
		
		final Scanner scan = new Scanner(input);
		final int radix = jpk.getInRadix();
		final StringBuilder back = new StringBuilder(input.length());
		
		while (scan.hasNext())
		{
			if (scan.hasNextInt(radix)) {
				back.append(Integer.toString(scan.nextInt(radix),radix));
				back.append('\n');
			}
			else scan.next();
		}
		
		return back.toString();
		
	}

	@ Override
	public String toAscii(final String input) {

		final Scanner scan = new Scanner(input);
		final int radix = jpk.getInRadix();
		final StringBuilder back = new StringBuilder(input.length());
		
		while (scan.hasNextInt(radix)) {
			back.append((char)scan.nextInt(radix));
		}
		
		return back.toString();

	}
	
	@ Override
	public String toBinary(final String input) {
		
		final Scanner scan = new Scanner(input);
		final int inRadix = jpk.getInRadix();
		final int bpb = jpk.getBitsPerBlock();
		final StringBuilder back = new StringBuilder(input.length()*(bpb+1));

		while (scan.hasNext()) {
			
			if (scan.hasNextLong(inRadix)) {

				back.append(toBinary(scan.nextLong(inRadix), bpb));
				back.append('\n');
				
			}
			else { 
				System.out.println("JPKNumber.toBinary() .. skip");
				scan.next();
			}
			
		}
		
		return back.toString();

	}
	
	@ Override
	public String toNumber(final String input, int outRadix) {
		
		final Scanner scan = new Scanner(input);
		final int inRadix = jpk.getInRadix();
		final StringBuilder back = new StringBuilder(input.length());
		
		while (scan.hasNext()) {
			
			if (scan.hasNextLong(inRadix)) {
				
				back.append(Long.toString(scan.nextLong(inRadix), outRadix));
				back.append('\n');
				
			}
			else {
				
				scan.next();
				
			}
			
		}
		
		return back.toString();

	}

	@ Override
	public byte[] toFile(String input) {
		
		final String ui = JOptionPane.showInputDialog(null, "Bytes per number", "1");
		
		if (ui == null) {
			return null;
		}
		
		int bpn = 0;
		try {
			bpn = Integer.parseInt(ui);
			if (bpn <= 0 || bpn > 16) {
				throw new Exception("Invalid bytes per number");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		final String[] lines = getLines(input);
		final int len = lines.length;
		final int inRadix = org.gizmore.jpk.JPK.getInstance().getInRadix();
		
		byte[] back = new byte[len*bpn];
		int count = 0;
		
		for (int i = 0; i < len; i++) {
			try {
				BigInteger bi = new BigInteger(lines[i], inRadix);

				String s = bi.toString(16);
				
				while (s.length() < bpn*2) {
					s = "0"+s;
				}
				
				for (int j = 0; j < bpn; j++) {
					String s2 = s.substring(j*2, j*2+2);
					back[count++] = (byte)Integer.parseInt(s2, 16);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			
		}
		
		return back;		
		
	}
	
}
