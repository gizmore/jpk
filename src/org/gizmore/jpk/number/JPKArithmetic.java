package org.gizmore.jpk.number;

import javax.swing.JOptionPane;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public class JPKArithmetic extends JPKClass {

	protected static final int METHOD_ADD = 0;
	protected static final int METHOD_XOR = 1;
	protected static final int METHOD_AND = 2;
	protected static final int METHOD_OR = 3;
	protected static final int METHOD_DIV = 4;
	protected static final int METHOD_MUL = 5;
	
	private static String lastKey = "0xbadc0ded";

	public int getMenuID() {
		
		return JPKMethod.MENU_NUMBER_ARITHMETIC;
		
	}
	
	protected String arithmetic (final String input, final int method) {
		
		final int[] key = getKeyViaDialog();
		
		if (key == null) {
			return null;
		}
		
		final String[] lines = getLines(input);
		final int nLines = lines.length;
		final int inRadix = jpk.getInRadix();
		final int outRadix = jpk.getOutRadix();
		final int keylen = key.length;
		final StringBuilder result = new StringBuilder(lines.length*16);
		
		int keynum = 0;
		int val = 0;

		for (int i = 0; i < nLines; i++) {
			
			if (lines[i].length()==0) {
				continue;
			}
			
			try {
				val = Integer.parseInt(lines[i], inRadix);
			}
			catch (Exception ex) {
				result.append(ex.toString());
				ex.printStackTrace();
				continue;
			}
			
			switch (method) {
			default: result.append("Invalid method\n"); return result.toString();
			case METHOD_ADD: val += key[keynum]; break;
			case METHOD_XOR: val ^= key[keynum]; break;
			case METHOD_AND: val &= key[keynum]; break;
			case METHOD_OR:  val |= key[keynum]; break;
			case METHOD_DIV: val /= key[keynum]; break;
			case METHOD_MUL: val *= key[keynum]; break;
			}
			
			result.append(Integer.toString(val, outRadix));
			result.append('\n');

			if (++keynum == keylen) {
				keynum = 0;
			}
			
		}
		
		jpk.getStatePanel().setInRadix(outRadix);
		
		return result.toString();
		
	}
	
	protected int[] getKeyViaDialog() {
		
		final String keyString = JOptionPane.showInputDialog("Enter Key Values 0xblubblub.. || 10 20 30 .. (for dec)", lastKey);
		
		if (keyString == null) {
			return null;
		}
		
		final int[] key = keyString.startsWith("0x") ? hexStringToIntArray(keyString.substring(2)) : stringToIntArray(keyString, 10);
		
		if (key.length == 0) {
			return null;
		}
		
		lastKey = keyString;

		return key;
		
	}

}
