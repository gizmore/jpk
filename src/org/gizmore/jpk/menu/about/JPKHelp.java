package org.gizmore.jpk.menu.about;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKMethod;

public final class JPKHelp implements JPKMethod {

	public String getName() { return "Help"; }
	
	public String getHelp() {
		
		return "Prints help for all comands.";
		
	}

	public int getMenuID() {
		
		return MENU_ABOUT;
		
	}

	public int getMnemonic() {

		return 0;

	}

	public String getKeyStroke() {

		return "";

	}

	public String execute(final String text) {

		final StringBuilder sb = new StringBuilder(2048);
		
		sb.append(getBasicHelp());

		sb.append(getHelp("Menu Functions", JPK.getInstance().getMenu().getMethods()));

		sb.append(getCredits());
		
		return sb.toString();
		
	}
	
	private String getHelp(final String headline, final JPKMethod[] methods) {
		
		final StringBuilder sb = new StringBuilder(512);
		final int len = methods.length;
		
		sb.append(headline);
		sb.append(":\n");
		
		for (int i = 0; i < len; i++) {
			
			sb.append(JPKMethod.menuNames[methods[i].getMenuID()]);
			sb.append("->");
			sb.append(methods[i].getName());
			sb.append(": ");
			sb.append(methods[i].getHelp());
			sb.append("\n");
			
		}
		
		sb.append("------------------------------------------------\n");
		
		return sb.toString();
		
	}
	
	private String getBasicHelp() {
		
		StringBuilder sb = new StringBuilder(2048);

		sb.append("JPK is mainly a conversion tool\n" +
			"When you hover the mouse over a function, you get some help what it does.\n" +
			"When your input is binary or number, make sure you have 1 number per line, and select the correct InRadix or BitsPerBlock.\n"+
			"It is a good idea to press Binary->Format, or Number->Format, before doing Number or Binary functions.\n");
		sb.append("------------------------------------------------\n");

		return sb.toString();

	}

	private String getCredits() {
		
		return 
			"Thanks go out to all challengers";
		
	}
	
}
