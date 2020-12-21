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
		text = text.replace('�', 'a');
		text = text.replace('�', 'e');
		text = text.replace('�', 'i');
		text = text.replace('�', 'o');
		text = text.replace('�', 'u');
		text = text.replace('�', 'y');
		text = text.replace('�', 'a');
		text = text.replace('�', 'e');
		text = text.replace('�', 'i');
		text = text.replace('�', 'o');
		text = text.replace('�', 'u');
		text = text.replace('�', 'A');
		text = text.replace('�', 'E');
		text = text.replace('�', 'I');
		text = text.replace('�', 'O');
		text = text.replace('�', 'U');
		text = text.replace('�', 'Y');
		text = text.replace('�', 'A');
		text = text.replace('�', 'E');
		text = text.replace('�', 'I');
		text = text.replace('�', 'O');
		text = text.replace('�', 'U');

		// spanish ext
		text = text.replace('�', 'n');
		text = text.replace('�', 'N');
		text = text.replace('�', 'u');

		// german
		text = text.replaceAll("�", "ue");
		text = text.replaceAll("�", "ae");
		text = text.replaceAll("�", "oe");
		text = text.replaceAll("�", "ss");
		text = text.replaceAll("�", "Ue");
		text = text.replaceAll("�", "Ae");
		text = text.replaceAll("�", "Oe");
		
		return text;
	}

}
