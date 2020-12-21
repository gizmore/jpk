package org.gizmore.jpk.menu.file;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;

import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;

public final class JPKSaveFile extends JPKClass implements JPKMethod {
	
	public String getName() { 
		
		return "Save File"; 
		
	}
	
	public int getMenuID() {
		
		return MENU_FILE;
		
	}
	
	public String getHelp() {
		
		return "Save file.";
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String text) {
		
		File file = saveFileDialog("Choose file to save");
		
		if (file == null) {
			return null;
		}
		
		return saveToFile(text, file);
		
	}
	
	public static File saveFileDialog(final String title) {
		
		final JFileChooser jfc = new JFileChooser();
		
		jfc.setDialogTitle(title);
		
		final int result = jfc.showSaveDialog(null);
		
		if (result != JFileChooser.APPROVE_OPTION) {
			return null;
		}
		
		return jfc.getSelectedFile();
		
	}

	public String saveToFile(final String text, final File file) {
		
		try {
			
			final FileOutputStream fos = new FileOutputStream(file);
			final byte[] ba = jpk.getInputMethod().toFile(text);
			final int len = ba.length;
			
			fos.write(ba, 0, len);
			
			fos.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
			return e.toString();
			
		}
		
		return String.format("Saved to '%s'\n", file.getAbsolutePath());
		
	}

}
