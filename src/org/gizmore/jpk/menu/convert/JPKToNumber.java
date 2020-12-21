package org.gizmore.jpk.menu.convert;

import javax.swing.JOptionPane;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.input.JPKInput;

public final class JPKToNumber extends JPKConverter {

	public JPKToNumber(final int menuID) {
		
		super(menuID);
		
	}

	public String getName() {
		
		return String.format("%s To Number", getInputType(menuID));
		
	}

	public String getHelp() {
		
		return "Convert current input to Number of base \"Out Radix\".";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

//		return "ctrl N";
		return null;

	}

	public String execute(final String input) {
				
		JPKInput inFormat = JPK.getInstance().getInputMethod();
		
		JPK.getInstance().setInputMethod(JPK.NUMBER);
		
		int outRadix = JPK.getInstance().getOutRadix();
		final String uIn = JOptionPane.showInputDialog("Output Radix", String.format("%d", outRadix));
		
		if (uIn != null) {
			
			try {
				outRadix = Integer.parseInt(uIn);
				JPK.getInstance().getStatePanel().setOutRadix(outRadix);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
		final String back = inFormat.toNumber(input, outRadix);
		
		JPK.getInstance().getStatePanel().setInRadix(outRadix);
		
		return back;
		
	}

}
