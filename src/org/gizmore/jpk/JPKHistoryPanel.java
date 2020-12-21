package org.gizmore.jpk;

import javax.swing.JLabel;

import org.gizmore.jpk.history.*;

public final class JPKHistoryPanel extends JPKPanel {

	private static final long serialVersionUID = 0x01;
	
	private final JPKHistory history = new JPKHistory();
	private final JLabel lblHistory = new JLabel();
	
	private static final JPKMethod[] methods = {	
		new JPKHistoryClear(),
		new JPKHistoryPop(),
		new JPKHistoryPush(),
	};

	public JPKHistoryPanel() {
		
		super();
		
		add(lblHistory);
		 
		init(methods, 1, 0);

		updateLabel();
		
	}
	
	public JPKState push(JPKState state) {
		
		history.add(state);
		
		updateLabel();
		
		return new JPKState(state);
		
	}
	
	public JPKState pop() {

		int lastIndex = history.size()-1;
		
		if (lastIndex == -1) {
			return null;
		}

		JPKState back = history.get(lastIndex);
		
		history.remove(lastIndex);
			
		updateLabel();

		return back;
	
	}
	
	private void updateLabel() {
		
		lblHistory.setText(String.format("History %d/%d", history.size(), history.size()));
		
	}
	
	public void clear() {

		history.clear();
		
		updateLabel();
	
	}
	
	public int getHistorySize() {
		
		return history.size();
		
	}

}
