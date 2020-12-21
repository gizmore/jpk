package org.gizmore.jpk;

public final class JPKState {

	public String text;
	public int inputType;
	public int inRadix;
	public int outRadix;
	public int bitsPerBlock;
	
	public JPKState() {
		
		text = null;
		inputType = JPK.ASCII;
		inRadix = 16;
		outRadix = 16;
		bitsPerBlock = 8;
		
	}

	public JPKState(JPKState state) {
		
		text = null;
		this.inRadix = state.inRadix;
		this.outRadix = state.outRadix;
		this.bitsPerBlock = state.bitsPerBlock;
		this.inputType = state.inputType;

	}
	
}
