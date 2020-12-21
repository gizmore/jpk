package org.gizmore.jpk;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class JPKStatePanel extends JPanel {

	private static final long serialVersionUID = 0x1;

	private JLabel lblInRadix = new JLabel("InRadix"); 
	private JTextField tfInRadix = new JTextField("16"); 
	private JLabel lblOutRadix = new JLabel("OutRadix"); 
	private JTextField tfOutRadix = new JTextField("16"); 
	private JLabel lblBitsPerBlock = new JLabel("BitsPerBlock"); 
	private JTextField tfBitsPerBlock = new JTextField("8");
	
	public JPKStatePanel() {
		
		tfInRadix.setColumns(5);
		add(lblInRadix);
		add(tfInRadix);
		
		tfOutRadix.setColumns(5);
		add(lblOutRadix);
		add(tfOutRadix);
		
		tfBitsPerBlock.setColumns(5);
		add(lblBitsPerBlock);
		add(tfBitsPerBlock);
		
	}
	
	public void setState(JPKState state) {
		
		tfInRadix.setText(Integer.toString(state.inRadix));
		tfOutRadix.setText(Integer.toString(state.outRadix));
		tfBitsPerBlock.setText(Integer.toString(state.bitsPerBlock));
		
		JPK.getInstance().setInputMethod(state.inputType);
		JPK.getInstance().setText(state.text);
		
	}
	
	public JPKState getState() {
		
		JPKState state = new JPKState();
		
		state.inRadix = getInRadix();
		state.outRadix = getOutRadix();
		state.bitsPerBlock = getBitsPerBlock();
		state.text = JPK.getInstance().getText();
		state.inputType = JPK.getInstance().getInputMethodID();
		
		return state;		
	}
	
	public int getInRadix() {
		
		try {
			
			return Integer.parseInt(tfInRadix.getText());	
		
		} catch (Exception ex) {
			ex.printStackTrace();
			tfInRadix.setText("16");
			return 16;
		}
		
	}
	
	public int getOutRadix() {
		
		try {
			
			return Integer.parseInt(tfOutRadix.getText());	
		
		} catch (Exception ex) {
			ex.printStackTrace();
			tfOutRadix.setText("16");
			return 16;
		}
		
	}
	
	public int getBitsPerBlock() {
		
		try {
			
			return Integer.parseInt(tfBitsPerBlock.getText());	
		
		} catch (Exception ex) {
			ex.printStackTrace();
			tfBitsPerBlock.setText("8");
			return 8;
		}
		
	}
	
	public void setInRadix(final int radix) { 
		
		tfInRadix.setText(Integer.toString(radix)); 
		
	}
	
	public void setOutRadix(final int radix) { 
		
		tfOutRadix.setText(Integer.toString(radix)); 
		
	}
	
	public void setBitsPerBlock(final int radix) { 
		
		tfBitsPerBlock.setText(Integer.toString(radix)); 
		
	}
	
}
