package org.gizmore.jpk.macro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.gizmore.jpk.JPK;

public final class JPKMacro extends JFrame implements KeyListener {
	
	private static final long serialVersionUID = 310;
	
	private ArrayList<JPKMacroItem> macro = new ArrayList<JPKMacroItem>(128);
	private boolean doCapture = false;
	
	public JPKMacro() {
		
		this.setTitle("Macro Recorder");
		this.setSize(240, 64);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JPK.getInstance().getMacro().stopCapture();
			}          
		});
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.setColor(Color.GREEN);
		g.clearRect(0, 0, 240, 64);
		
	}
	
	public void startCapture() {
	
		doCapture = true;
		macro.clear();
		JPKMacroItem.resetMacroRecording();
		this.setVisible(true);
		
	}
	
	public void stopCapture() {
		
		doCapture = false;
		this.setVisible(false);
		
	}
	
	public void repeatCapture() {
		
		final int len = macro.size();
		
		for (int i = 0; i < len; i++) {
			
			macro.get(i).execute();
			
		}
		
	}
	
	public void keyPressed(KeyEvent ke) {
	
		if (!doCapture) {
			return;
		}

//		System.out.println(ke);
		macro.add(new JPKMacroItem(null, ke));
		
	}
	
	public void keyReleased(KeyEvent ke) {
		
		if (!doCapture) {
			return;
		}
//		System.out.println(ke);
		macro.add(new JPKMacroItem(null, ke));
		
	}	
	
	public void keyTyped(KeyEvent ke) {
		
		if (!doCapture) {
			return;
		}
//		System.out.println(ke);
//		macro.add(new JPKMacroItem(null, ke));
		
	}
	
	public void copyToClipboard() {
		
		System.out.println("JPKMacro::copyToClipboard()");
		
		JPKMacroItem.copyToClipboard();
		
	}

}
