package org.gizmore.jpk;

import java.awt.Dimension;
import java.awt.Font;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.GridLayout;
//import javax.swing.SpringLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import javax.swing.JApplet;
import javax.swing.JFrame;
//import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import org.gizmore.jpk.input.*;
import org.gizmore.jpk.macro.JPKMacro;
import org.gizmore.jpk.macro.JPKMacroItem;

/*
 * JPK comes with absolutely no warranty.
 * Also it comes without a knife.
 * In fact, it doesnt come, you donwloaded it.
 * 
 */
public final class JPK extends JApplet {

	private static final long serialVersionUID = 0x406a;
	
	public static final String programName = "JPocketKnife";
	public static final String version = "v4.06a";
	public static final String releaseDate = "2008.Nov.2";
	public static final String copyString = "(c)2008 by Gizmore";
	public static final String motRelease = "New stuff:\nNumber->ShowDivisors\nNumber->Substitution\nBinary XOR|OR\nHave fun ! ;)\n";
	private static String getTitle() { return String.format("%s %s", programName, version); }
	private static String getStartMessage() { return String.format("%s %s; %s\n%s\n%s\n", programName, version, releaseDate, copyString, motRelease); }

	private static JPK instance = null; 
	private static final int jpkWidth = 720, jpkHeight = 600;
	private static final int textAreaWidth = jpkWidth-20, textAreaHeight = jpkHeight - 100;
	private static final Font fontTextArea = new Font("Monospaced", 0, 12);
	
	private final JPKMenu menu = new JPKMenu();
	private final JPKStatePanel statePanel = new JPKStatePanel(); 
	private final JPKHistoryPanel historyPanel = new JPKHistoryPanel();

	private int inputMethod = 0;
	public static final int ASCII = 0, BINARY = 1, NUMBER = 2;
	private JPKInput[] inputs = {
		new JPKAscii(),
		new JPKBinary(),
		new JPKNumber(),
	};

	private JTextArea textArea = new JTextArea();
	
	private JPKMacro macro = new JPKMacro();
	
	public static JPK getInstance() { return instance; }

	public static void main(String[] args) {
		
		JFrame frame = new JFrame(getTitle());
		JPK jpk = new JPK();
		jpk.init();
		frame.add(jpk);
		frame.setSize(jpkWidth, jpkHeight);
		frame.setLocation(20, 20);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				}          
		});
		
		frame.setVisible(true);
		
	}
	
	public int        getInRadix()      { return statePanel.getInRadix(); }
	public int        getOutRadix()     { return statePanel.getOutRadix(); }
	public int        getBitsPerBlock() { return statePanel.getBitsPerBlock(); }
	public String     getText()         { return textArea.getText(); }
	public int        getInputMethodID()  { return inputMethod; }
	public JTextArea  getTextArea()     { return textArea; }
	public JPKMenu    getMenu()         { return menu; }
	public JPKInput   getInputMethod()  { return inputs[inputMethod]; }
	public JPKStatePanel getStatePanel() { return statePanel; }
	public JPKHistoryPanel getHistory()  { return historyPanel; }
/*	public JPKAsciiPanel getAsciiPanel() { return asciiPanel; }
	public JPKBinaryPanel getBinaryPanel() { return binaryPanel; }
	public JPKNumberPanel getNumberPanel() { return numberPanel; }*/
	public JPKMacro getMacro() { return macro; }
	
	public void setText(final String text) { textArea.setText(text); }
	public void setState(final JPKState state) { statePanel.setState(state); }
	public void setInputMethod(final int type) { inputMethod = type; }

	@Override
	public void init() {
		
		instance = this;
		
		final String macroMessage = JPKMacroItem.initMacroBot();
		
		JPKClass.setStaticJPK(this);
		
//		GridBagLayout gbag = new GridBagLayout();
//		GridBagConstraints c = new GridBagConstraints();
//		setLayout(gbag);
		setLayout(new FlowLayout(FlowLayout.CENTER));

		// Menu 
		setJMenuBar(menu);
		
//		c.gridy = 0;
//		gbag.setConstraints(historyPanel, c);
		add(historyPanel);
		
		add(statePanel);

		// Button Tab
//		c.fill = GridBagConstraints.NONE;
//		c.gridy++;
/*		tabs.addTab("Ascii", asciiPanel);
		tabs.addTab("Binary", binaryPanel);
		tabs.addTab("Number", numberPanel);
//		gbag.setConstraints(tabs, c);
		add(tabs);*/

		// TextArea
//		c.gridy++;
//		c.fill = GridBagConstraints.BOTH;
//		textArea.setPreferredSize(new Dimension(textAreaWidth-60, textAreaHeight-50));
//		textArea.setMinimumSize(new Dimension(640, 240));
		textArea.setFont(fontTextArea);
		textArea.setText(getStartMessage()+macroMessage);
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setPreferredSize(new Dimension(textAreaWidth, textAreaHeight));
		textArea.addKeyListener(macro);
//		gbag.setConstraints(textArea, c);
		add(jsp);
		
	}
	
	public void quit() {
		
		System.exit(0);
		
	}
	
	public void execute(final JPKMethod method) {
	
		JPKState state = statePanel.getState();

		final String result = method.execute(textArea.getText());
		
		if (result != null) {
			historyPanel.push(state);
			textArea.setText(result);
		}
		
		System.gc();
		
	}

}
