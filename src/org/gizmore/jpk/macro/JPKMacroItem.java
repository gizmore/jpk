package org.gizmore.jpk.macro;

import java.awt.event.KeyEvent;

import javax.swing.JTextArea;

import org.gizmore.jpk.JPK;
import org.gizmore.jpk.JPKClass;
import org.gizmore.jpk.JPKMethod;


public final class JPKMacroItem extends JPKClass {
	
	private static JTextArea textArea;
	
	private static boolean shift = false;
	private static boolean control = false;

	private static String clipboard = null;
	
	public static String initMacroBot() {
		
		try {
			textArea = JPK.getInstance().getTextArea();
//			return "Macros available\n";
		}
		catch (Exception e) {
//			return "Macros not available\n";
		}
		
		return "";
		
	}
	
	public static void resetMacroRecording() {
		
		shift = control = false;
		
	}
	
	public static void copyToClipboard() {
		
		clipboard = textArea.getSelectedText();
		
	}
	
	private JPKMethod method;
	private KeyEvent keyEvent;
	
	public JPKMacroItem(JPKMethod method, KeyEvent ke) {
		
		this.method = method;
		this.keyEvent = ke;
		
	}
	
	public void execute() {
		
		System.out.println("JPKMacroItem::execute()");
		
		if (method != null) {
			method.execute(JPK.getInstance().getText());
		}
		
		if (keyEvent != null) {
			keyEvent();
		}
		
	}
	
	private void keyEvent() {
		
		switch (keyEvent.getID()) {
		case KeyEvent.KEY_PRESSED: keyPressedEvent(keyEvent); break;
		case KeyEvent.KEY_RELEASED: keyReleasedEvent(keyEvent); break;
		}
		
	}
	
	private void keyPressedEvent(final KeyEvent ke) {
		
		
		final int code = ke.getKeyCode();
		
		switch(code) {
		case KeyEvent.VK_SHIFT: shift = true; break;
		case KeyEvent.VK_CONTROL: control = true; break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_UP:
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_HOME:
		case KeyEvent.VK_END:
			keyMoveEvent(code);
			break;
			
		default:
			if (control) {
				keyControlEvent(ke);
			}
			else {
				keyInsertEvent(ke);
			}
			break;
		}
		
	}
	
	private void keyReleasedEvent(final KeyEvent ke) {
		
		switch(ke.getKeyCode()) {
		case KeyEvent.VK_SHIFT: shift = false; break;
		case KeyEvent.VK_CONTROL: control = false; break;
		}
				
	}

	/*
	 * A cursor move event occured:
	 * Either: left,down,up,right,home,end,pageup,pagedown
	 */
	private void keyMoveEvent(int code) {
		
		int start = textArea.getSelectionStart();
		int end = textArea.getSelectionEnd();
//		int len = textArea.getText().length();

		switch (code) {
		
		case KeyEvent.VK_LEFT:
			start = getLeftPos(textArea.getText(), start);
			end = shift ? start : end;
			break;
			
		case KeyEvent.VK_RIGHT:
			end = getRightPos(textArea.getText(), end);
			start = shift ? start : end;
			break;
		
		case KeyEvent.VK_UP:
			start = getUpPos(textArea.getText(), start);
			end = shift ? end : start;
			break;
			
		case KeyEvent.VK_DOWN:
			int t = getDownPos(textArea.getText(), end);
			start = shift ? start : t;
			end = t;
			break;

		case KeyEvent.VK_HOME:
			start = getHomePos(textArea.getText(), start);
			end = shift ? end : start;
			break;
			
		case KeyEvent.VK_END:
			end = getEndPos(textArea.getText(), end);
			start = shift ? start : end;
			break;
			
		}
		
		textArea.setSelectionStart(start);
		textArea.setSelectionEnd(shift ? end : start);
		
	}
	
	private int getLeftPos(final String text, int start) {
		
		if (start == 0) { // already reached start
			return 0;
		}
		if (!control) { // simple key left
			return start - 1;
		}
		
		start--;

		final boolean isLetter = Character.isLetterOrDigit(text.charAt(start));
		
		while (start > 0) {
			
			if (isLetter != Character.isLetterOrDigit(text.charAt(start))) {
				while (text.charAt(start-1) == ' ') {
					start--;
				}
				start++;
				break;
			}
			start--;
		}
		
		return start < 0 ? 0 : start;

	}
	
	private int getRightPos(final String text, int start) {
		
		final int len = text.length();
		
		if (start == len) {
			return start;
		}
		
		final boolean isLetter = Character.isLetterOrDigit(text.charAt(start));
		
		if (start == len) {
			return start;
		}
		
		start++;
		
		if (!control) {
			return start;
		}
		
		while (start < len) {
			
			if (isLetter != Character.isLetterOrDigit(text.charAt(start))) {
				while (text.charAt(start) == ' ') {
					start++;
				}
				break;
			}
			start++;
		}
		
		return start;
		
	}

	private int getUpPos(final String text, final int start) {
		
		System.out.println(String.format("JPKMacroItem::getUpPos() Start: %d", start));
		
		// get column
		final int offset = getLineOffset(text, start);
		System.out.println(String.format("Offset: %d", offset));
		
		int t = getLineStart(text, start);
		System.out.println(String.format("t: %d", t));
		
		// top line ?
		if (t == 0) {
			return start;
		}
		
		t-=2;
		t = getLineStart(text, t);
		int t2 = getLineEnd(text, t);
		t2 = t2 - t;  
		t += offset > t2 ? t2 : offset;
		
		return t;
		
	}
	
	private int getLineStart(final String text, int pos) {
		
		if (pos == text.length()) {
			return pos;
		}
		
		while (pos > 0) {
			
			pos--;

			if (text.charAt(pos) == '\n') {
				pos++;
				break;
			}
			
		}
		
		return pos;
		
	}
	
	private int getLineEnd(final String text, int pos) {
		
		pos = text.indexOf('\n', pos);
		
		return pos == -1 ? text.length() : pos;
		
	}
	
	private int getLineOffset(final String text, int pos) {
		
//		if (pos >= text.length()) {
//			return text.length();
//		}
		
		int delta = pos;
		
		while (pos > 0) {
			
			pos--;

			if (text.charAt(pos) == '\n') {
				pos++;
				break;
			}
			
		}
		
		return delta - pos;
		
		
	}
	
	/*
	 * Get a position in text like moving 1 down with cursor.
	 */
	private int getDownPos(final String text, final int start) {
		
		System.out.println(String.format("getDownPos(start: %d)", start));
//		int len = text.length();
		
		int offset = getLineOffset(text, start);
		System.out.println(String.format("Offset: %d", offset));
		
		int t = text.indexOf('\n', start);
		System.out.println(String.format("t: %d", t));
		if (t == -1 ) {
			return start;
		}
		t++;
		System.out.println(String.format("t: %d", t));
		
		int lineStart = getLineStart(text, t);
		int lineEnd = getLineEnd(text, t);
		System.out.println(String.format("End: %d", lineEnd));
		
		if (offset > lineEnd - lineStart) {
			offset = lineEnd - lineStart;
		}
		
		t += offset;
		System.out.println(String.format("t: %d", t));
		
//		t =  t > len ? len : (t > lineEnd ? lineEnd : t);
		System.out.println(String.format("t: %d", t));
		
		return t;
		
	}
	
	private int getHomePos(final String text, int start) {
		
		System.out.println(String.format("JPKMacroItem::getHomePos(%d)", start));
		
		while (start > 0) {
			
			start--;

			if (text.charAt(start) == '\n') {
				start++;
				break;
			}
			
		}
		
		System.out.println(String.format("Start: %d", start));
		
		return start;
		
	}
	
	private int getEndPos(final String text, final int start) {
		
		System.out.println(String.format("MacroItem::getEndPos() Start: %d", start));
		
		final int len = text.length();
		
		int pos = text.indexOf('\n', start);
		
		pos = pos == -1 ? len : pos;
		
		System.out.println(String.format("pos: %d", pos));
		
		return pos; 
		
	}
	
	private void keyInsertEvent(final KeyEvent ke) {
		
		char c = ke.getKeyChar();
		
		insertText(Character.toString(c));
		
	}
	
	private void insertText(final String text) {
		
		int start = textArea.getSelectionStart();
		int end = textArea.getSelectionEnd();
		
		StringBuilder sb = new StringBuilder(textArea.getText());
		sb.delete(start, end);
		sb.insert(start, text);
		
		textArea.setText(sb.toString());
		textArea.setSelectionStart(start + text.length());
		textArea.setSelectionEnd(start + text.length());
		
	}
	
	private void keyControlEvent(final KeyEvent ke) {
		
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_C: clipboard = textArea.getSelectedText(); break;
		case KeyEvent.VK_V: insertText(clipboard == null ? "[Empty Clipboard]" : clipboard); break;
		default: break;
		}
		
	}
	
}

