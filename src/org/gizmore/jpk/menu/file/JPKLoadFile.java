package org.gizmore.jpk.menu.file;

import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFileChooser;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;

public class JPKLoadFile implements JPKMethod {

	public String getName() { 
		
		return "Load File"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_FILE;
		
	}

	public String getHelp() {
		
		return "Load a file into the text area as hex numbers.";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "ctrl L";

	}

	public static File[] openFileDialog(final String title, final boolean isMultifile) {
		
		final JFileChooser jfc = new JFileChooser();
		
		jfc.setDialogTitle(title);
		jfc.setMultiSelectionEnabled(isMultifile);
		
		final int result = jfc.showOpenDialog(null);
		
		if (result != JFileChooser.APPROVE_OPTION) {
			return null;
		}
		
		return isMultifile ? jfc.getSelectedFiles() : new File[] { jfc.getSelectedFile() };
		
	}
	
	public String execute(final String text) {
		
		final File[] file = openFileDialog("Select a file to load", false);
		
		if (file == null) {
			JPK.getInstance().getHistory().pop();
			return text;
		}
		
		JPK.getInstance().setInputMethod(JPK.NUMBER);
		JPK.getInstance().getStatePanel().setInRadix(16);
		
		return loadFile(file[0]);
		
	}
	
	private String loadFile(final File file) {
		
		final StringBuilder back = new StringBuilder();
		
		try {

			final FileInputStream fis = new FileInputStream(file);
			final int len  = fis.available();
//			System.out.println(len);

			for (int i = 0; i < len; i++) {
				back.append(String.format("%02x\n", fis.read()));
			}
			
		} catch (Exception e) {
			back.append(e.toString()+"\n");
		}
		
		return back.toString();
			
	}

}
