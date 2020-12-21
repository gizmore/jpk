package org.gizmore.jpk.ascii;

import org.gizmore.jpk.JPKMethod;

public final class JPKDeAccent implements JPKMethod {

	public String getHelp() {
		return "Remove accents from spanish and france languages.";
	}

	public String getKeyStroke() {
		return null;
	}

	public int getMenuID() {
		return MENU_ASCII;
	}

	public int getMnemonic() {
		return 0;
	}

	public String getName() {
		return "DeAccent";
	}

	public String execute(String text) {
		
		// front tick, back tick
		text = text.replace('á', 'a');
		text = text.replace('é', 'e');
		text = text.replace('í', 'i');
		text = text.replace('ó', 'o');
		text = text.replace('ú', 'u');
		text = text.replace('ý', 'y');
		text = text.replace('à', 'a');
		text = text.replace('è', 'e');
		text = text.replace('ì', 'i');
		text = text.replace('ò', 'o');
		text = text.replace('ù', 'u');
		text = text.replace('Á', 'A');
		text = text.replace('É', 'E');
		text = text.replace('Í', 'I');
		text = text.replace('Ó', 'O');
		text = text.replace('Ú', 'U');
		text = text.replace('Ý', 'Y');
		text = text.replace('À', 'A');
		text = text.replace('È', 'E');
		text = text.replace('Ì', 'I');
		text = text.replace('Ò', 'O');
		text = text.replace('Ù', 'U');

		// spanish ext
		text = text.replace('ñ', 'n');
		text = text.replace('Ñ', 'N');
		text = text.replace('ü', 'u');

		// german
		text = text.replaceAll("ü", "ue");
		text = text.replaceAll("ä", "ae");
		text = text.replaceAll("ö", "oe");
		text = text.replaceAll("ß", "ss");
		text = text.replaceAll("Ü", "Ue");
		text = text.replaceAll("Ä", "Ae");
		text = text.replaceAll("Ö", "Oe");
		
		return text;
	}

}
