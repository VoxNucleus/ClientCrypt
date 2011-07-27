package me.victork.clientcrypt.ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PerfPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3257734978444697221L;

	public PerfPanel(){
		JLabel label_text = new JLabel("Performances - Not implemented yet");
		label_text.setHorizontalAlignment(JLabel.CENTER);
		
		this.setLayout(new GridLayout(1,1));
		this.add(label_text);
	}
}
