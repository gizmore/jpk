package org.gizmore.jpk.menu.file;

import java.io.File;
import java.io.FileInputStream;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;

public final class JPKLoadFileAscii implements JPKMethod {

	public String getHelp() {
		return "Load file as Ascii";
	}

	public String getKeyStroke() {
		return null;
	}

	public int getMenuID() {
		return MENU_FILE;
	}

	public int getMnemonic() {
		return 0;
	}

	public String getName() {
		return "Load File as Ascii";
	}

	public String execute(String text) {

		final File[] file = JPKLoadFile.openFileDialog("Select file to load as Ascii", false);
		
		if (file == null) {
			return null;
		}
		
		return loadFile(file[0]);
		
	}

	private String loadFile(final File file) {
		
		final StringBuilder back = new StringBuilder((int)file.length());
		
		try {

			final FileInputStream fis = new FileInputStream(file);
			final int len  = fis.available();
//			System.out.println(len);

			for (int i = 0; i < len; i++) {
				back.append(String.format("%c", fis.read()));
			}
			
		} catch (Exception e) {
			back.append(String.format("\n%s\n", e.toString()+"\n"));
		}
		
		JPK.getInstance().setInputMethod(JPK.ASCII);
		
		return back.toString();
			
	}

}
