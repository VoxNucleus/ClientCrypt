package me.victork.clientcrypt.ui.action;

import java.awt.event.ActionEvent;
import me.victork.clientcrypt.ui.CryptPanel;
import java.awt.event.ActionListener;
/**
 * 
 * @author victor
 *
 */

public class ClearAllAction implements ActionListener{
	
	private CryptPanel panel_to_clear;
	
	public ClearAllAction(CryptPanel panel){
		panel_to_clear=panel;
	}
	
	/**
	 * 
	 * @param e
	 */
	
	public void actionPerformed(ActionEvent e) {
	    panel_to_clear.clear_all();
	  }
}
