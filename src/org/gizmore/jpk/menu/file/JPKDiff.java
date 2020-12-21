package org.gizmore.jpk.menu.file;

import java.io.File;
import java.io.FileReader;

import org.gizmore.jpk.JPKMethod;

public final class JPKDiff implements JPKMethod {

	public String getName() { 
		
		return "Diff"; 
		
	}

	public int getMenuID() {
		
		return MENU_FILE;
		
	}

	public String getHelp() {
		
		return "Compare 2 binary files, (Very simple bytewise diff)";
		
	}
	
	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String text) {
	
		final File[] files = JPKLoadFile.openFileDialog("Select Files", true);
		
		if (files == null) {
			return null;
		}
		
		if (files.length != 2) {
			return "Please select 2 files.";
		}
		
		return diff(files[0], files[1]);
		
	}
	
	private String diff(final File file1, final File file2) {
	
		try {
			final StringBuilder back = new StringBuilder(0xffff);
			final FileReader fr1 = new FileReader(file1);
			final FileReader fr2 = new FileReader(file2);
			
			long size = file1.length() > file2.length() ? file2.length() : file1.length();
			
			back.append("Very simple bytewise diff\n");
			back.append("Checking for differences in the following 2 files:\n");
			back.append(String.format("File1: %s (%d bytes)\n", file1.getName(), file1.length()));
			back.append(String.format("File2: %s (%d bytes)\n", file2.getName(), file2.length()));
			back.append(String.format("Checking %d bytes... \n", size));
			
			int a, b;
			for (long i = 0; i < size; i++) {
				
				a = fr1.read();
				b = fr2.read();
				
				if (a == b) {
					continue;
				}
				
//				back.append(String.format("%02x", a+b));
				back.append(String.format("%08x: %02x %02x\n", i, a, b));
				
			}
			
			return back.toString();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		
	}

}
