package org.gizmore.jpk;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPKPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 0x01;
	
	private static final int buttonsPerRow = 6;

	private JButton[] buttons = null;
	private JPKMethod[] methods = null;
	
	public void init(JPKMethod[] methods) {
		
		init(methods, 0, 0);
		
	}
	
	public void init(JPKMethod[] methods, int xoff, int yoff) {
		
		init(methods, xoff, yoff, buttonsPerRow);
		
	}

	public void init(JPKMethod[] methods, int xoff, int yoff, int buttonsPerRow) {

		final GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gbag);
		
		this.methods = methods;
		this.buttons = new JButton[methods.length];
		
		for (int i = 0; i < methods.length; i++) {
			
			this.buttons[i] = new JButton(methods[i].getName());
			this.buttons[i].addActionListener(this);
			this.buttons[i].setToolTipText(methods[i].getHelp());
			
			if (methods[i].getMnemonic() != 0) {
				this.buttons[i].setMnemonic(methods[i].getMnemonic());
			}
			
			c.gridx = (i % buttonsPerRow) + xoff;
			c.gridy = (i / buttonsPerRow) + yoff;
			
			gbag.setConstraints(this.buttons[i], c);
			add(this.buttons[i]);
			
		}
		
	}

	public void actionPerformed(final ActionEvent ae) {
		
		final Object o = ae.getSource();
		
		for (int i = 0; i < buttons.length; i++) {
			if (o == buttons[i]) {
				JPK.getInstance().execute(methods[i]);
				return;
			}
		}
		
	}
	
	public JPKMethod[] getMethods() {
		
		return methods;
		
	}

}
