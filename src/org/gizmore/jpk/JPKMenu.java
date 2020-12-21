package org.gizmore.jpk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import org.gizmore.jpk.ascii.*;
import org.gizmore.jpk.ascii.decode.*;
import org.gizmore.jpk.ascii.decrypt.*;
import org.gizmore.jpk.ascii.encode.*;
import org.gizmore.jpk.binary.*;
import org.gizmore.jpk.general.*;
import org.gizmore.jpk.menu.edit.*;
import org.gizmore.jpk.menu.file.*;
import org.gizmore.jpk.menu.search.*;
import org.gizmore.jpk.menu.convert.*;
import org.gizmore.jpk.menu.about.*;
import org.gizmore.jpk.number.*;

public final class JPKMenu extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = 0x01;
	
	/*
	 * Base menus
	 */
	private final JMenu[] menus = {
			new JMenu("File"),
			new JMenu("Edit"),
			new JMenu("Search"),
			new JMenu("General"),
			
			new JMenu("Ascii"),
			new JMenu("Decode"),
			new JMenu("Encode"),
			new JMenu("Decrypt"),
			
			new JMenu("Binary"),
			
			new JMenu("Number"),
			new JMenu("Convert"),
			new JMenu("Keyed Arithmetic"),
			
			new JMenu("About"),
			new JMenu("/dev/null"),
	};
	
	/*
	 * New in V4: just add all methods here
	 */
	private final JPKMethod[] methods = {
			
			// File
			new JPKLoadFile(),
			new JPKLoadFileAscii(),
			new JPKSaveFileAscii(),
			new JPKSaveFileBinary(),
			new JPKSaveFileNumbers(),
			new JPKDiff(),
			new JPKQuit(),
			
			// Edit
			new JPKCopyToClipboard(),
			new JPKMacroStart(),
			new JPKMacroPlayback(),
			
			// Search
			new JPKSearch(),
			new JPKSearchNext(),
			new JPKReplace(),
			
			// General
			new JPKLead(),
			new JPKAppend(),
			new JPKGroupChars(),
			new JPKNumReverse(),
			new JPKReverse(),
			new JPKUppercase(),
			new JPKLowercase(),
			
			// Ascii
			new JPKFormat(JPKMethod.MENU_ASCII),
			new JPKToBinary(JPKMethod.MENU_ASCII),
			new JPKToNumber(JPKMethod.MENU_ASCII),
			// Ascii Decode
			new JPKAtbash(),
			new JPKMorseDecoder(),
			new JPKBase64Decoder(),
			new JPKUnescape(),
			new JPKMirmoDecoder(),
			new JPKBraille(),
			// Ascii Encode
			new JPKMorseEncoderA(),
			new JPKMorseEncoderB(),
			// Ascii Decrypt
			new JPKCaesar(),
			new JPKAdvCaesar(),
			new JPKKeyedCaesar(),
			new JPKBaconianBF(),
			// Ascii stuff
			new JPKAscHistogram(),
			new JPKIndexCoincedence(),
			new JPKDigraph(),
			new JPKTransposition(),
			new JPKTransposition2(),
			new JPKDeAccent(),

			// Binary
			new JPKFormat(JPKMethod.MENU_BINARY),
			new JPKToAscii(JPKMethod.MENU_BINARY),
			new JPKToNumber(JPKMethod.MENU_BINARY),
			new JPKBinMorseDecoder(),
			new JPKBitmask(),
			new JPKComplement1(),
			new JPKComplement2(),
			new JPKRotAllL(),
			new JPKRotAllR(),
			new JPKRotBlockL(),
			new JPKRotBlockR(),
			new JPKXORStream(),
			new JPKORStream(),
			
			// Number
			new JPKFormat(JPKMethod.MENU_NUMBER_CONVERT),
			new JPKToAscii(JPKMethod.MENU_NUMBER_CONVERT),
			new JPKToBinary(JPKMethod.MENU_NUMBER_CONVERT),
			new JPKToNumber(JPKMethod.MENU_NUMBER_CONVERT),
			new JPKNumHistogram(),
			new JPKNumPadding(),
			new JPKNumberSubstitute(),
			new JPKDivisors(),
			
			new JPKAdd(),
			new JPKAnd(),
			new JPKOr(),
			new JPKXor(),
			new JPKMul(),
			new JPKDiv(),
			new JPKBase64Encoder(),
			new JPKEncodingBF(),
			
			// About
			new JPKAsciiTable(),
			new JPKAbout(),
			new JPKHelp(),
			
			// /dev/null
			new JPKGroupNums(),

	};
	
	private final JMenuItem[] menuItems = new JMenuItem[methods.length];
	

	public JPKMenu() {
		
		menus[JPKMethod.MENU_ASCII].add(menus[JPKMethod.MENU_ASCII_DECODE]);
		menus[JPKMethod.MENU_ASCII].add(menus[JPKMethod.MENU_ASCII_ENCODE]);
		menus[JPKMethod.MENU_ASCII].add(menus[JPKMethod.MENU_ASCII_DECRYPT]);
		menus[JPKMethod.MENU_NUMBER].add(menus[JPKMethod.MENU_NUMBER_CONVERT]);
		menus[JPKMethod.MENU_NUMBER].add(menus[JPKMethod.MENU_NUMBER_ARITHMETIC]);
		
		for (int i = 0; i < methods.length; i++) {
			
			menuItems[i] = new JMenuItem(methods[i].getName());
			menuItems[i].addActionListener(this);
			menuItems[i].setToolTipText(methods[i].getHelp());
			if (methods[i].getKeyStroke() != "") {
				menuItems[i].setAccelerator(KeyStroke.getKeyStroke(methods[i].getKeyStroke()));
			}
			menus[methods[i].getMenuID()].add(menuItems[i]);
			
		}
		
		add(menus[JPKMethod.MENU_FILE]);
		add(menus[JPKMethod.MENU_EDIT]);
		add(menus[JPKMethod.MENU_SEARCH]);
		add(menus[JPKMethod.MENU_GENERAL]);
		add(menus[JPKMethod.MENU_ASCII]);
		add(menus[JPKMethod.MENU_BINARY]);
		add(menus[JPKMethod.MENU_NUMBER]);
		add(menus[JPKMethod.MENU_ABOUT]);
		add(menus[JPKMethod.MENU_DEVNULL]);
		
		
		
	}
	
	public void actionPerformed(final ActionEvent ae) {
		
		final Object o = ae.getSource();
		
		for (int i = 0; i < menuItems.length; i++) {
			if (o == menuItems[i]) {
				setInputType(i);
				JPK.getInstance().execute(methods[i]);
			}
		}
		
	}
	
	/*
	 * hack for old api behaviour
	 */
	private void setInputType(final int i) {
		
		switch(methods[i].getMenuID()) {
		case JPKMethod.MENU_ASCII:
		case JPKMethod.MENU_ASCII_DECODE:
		case JPKMethod.MENU_ASCII_ENCODE:
		case JPKMethod.MENU_ASCII_DECRYPT:
			JPK.getInstance().setInputMethod(JPK.ASCII); break;
		case JPKMethod.MENU_BINARY: 
			JPK.getInstance().setInputMethod(JPK.BINARY); break;
		case JPKMethod.MENU_NUMBER: 
		case JPKMethod.MENU_NUMBER_ARITHMETIC:
		case JPKMethod.MENU_NUMBER_CONVERT:
			JPK.getInstance().setInputMethod(JPK.NUMBER); break;
		default: break;
		}
		
	}
	
	public JPKMethod[] getMethods() {
		
		return methods;
		
	}

}
