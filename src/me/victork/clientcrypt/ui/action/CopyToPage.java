package me.victork.clientcrypt.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import me.victork.clientcrypt.browser.BrowserInteraction;
import me.victork.clientcrypt.browser.MessageToBrowser;
import me.victork.clientcrypt.ui.CryptPanel;

public class CopyToPage implements ActionListener{
	
	private CryptPanel cPanel;
	
	public CopyToPage(CryptPanel panel){
		cPanel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try{
			String algo="test";
			String encrypted_txt= cPanel.getEncryptedText();
			MessageToBrowser msg = new MessageToBrowser(BrowserInteraction.form_id,
					algo,encrypted_txt);
			BrowserInteraction.invoke(msg);}
		catch(Exception ex){
			cPanel.setEncryptedText(ex.toString()+" \\ "+ex.getMessage());

		}
		
	}

}
