package org.gizmore.jpk;

public interface JPKMethod {

	public static final int MENU_NONE = -1;
	public static final int MENU_FILE = 0;
	public static final int MENU_EDIT = 1;
	public static final int MENU_SEARCH = 2;
	public static final int MENU_GENERAL = 3;
	public static final int MENU_ASCII = 4;
	public static final int MENU_ASCII_DECODE = 5;
	public static final int MENU_ASCII_ENCODE = 6;
	public static final int MENU_ASCII_DECRYPT = 7;
	public static final int MENU_BINARY = 8;
	public static final int MENU_NUMBER = 9;
	public static final int MENU_NUMBER_CONVERT = 10;
	public static final int MENU_NUMBER_ARITHMETIC = 11;
	public static final int MENU_ABOUT = 12;
	public static final int MENU_DEVNULL = 13;
	
	public static final String[] menuNames = {
		"File",
		"Edit",
		"Search",
		"General",
		"Ascii",
		"Ascii->Decode",
		"Ascii->Encode",
		"Ascii->Decrypt",
		"Binary",
		"Number",
		"Number->Convert",
		"Number->Arithmetic",
		"About",
		"/dev/null",		
	};
	
	/*
	 * return into which menu the function goes
	 */
	public int getMenuID(); 
	
	/*
	 * get the name as displayed in menu
	 */
	public String getName();

	/*
	 * get rollover help string
	 */
	public String getHelp();

	
	public int    getMnemonic();

	public String getKeyStroke();

	/*
	 * execute the method
	 */
	public String execute(final String text);
	
	
}
