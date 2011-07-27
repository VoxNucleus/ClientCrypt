package me.victork.clientcrypt.ui;

import javax.swing.JTabbedPane;

public class ClientCryptPanel extends JTabbedPane {
	
	private CryptPanel c_panel;
	private PerfPanel p_panel;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1547035183139256782L;

	public ClientCryptPanel(){
		c_panel = new CryptPanel();
		p_panel = new PerfPanel();
		
		this.addTab("Cryptographie", c_panel);
		this.addTab("Performances", p_panel);
		//Main Panel
	}
	
	public CryptPanel getC_panel(){
		return c_panel;
	}
	
	public PerfPanel getP_panel(){
		return p_panel;
	}
	

}
