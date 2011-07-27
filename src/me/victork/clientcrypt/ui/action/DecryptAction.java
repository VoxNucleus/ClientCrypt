package me.victork.clientcrypt.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import me.victork.clientcrypt.core.ClientCryptEngine;
import me.victork.clientcrypt.core.CryptographyOptions.CRYPTOGRAPHY_OPTIONS;
import me.victork.clientcrypt.ui.CryptPanel;

public class DecryptAction implements ActionListener {
	
	private String input_text;
	private String password;
	private CRYPTOGRAPHY_OPTIONS option;
	
	private CryptPanel associated_panel;
	
	public DecryptAction(CryptPanel panel){
		associated_panel=panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		input_text=associated_panel.getEncryptedText();
		password=associated_panel.getPassword();
		option= associated_panel.getCryptographyOption();
		
		ClientCryptEngine crypt_engine = 
			new ClientCryptEngine(option,0,password, input_text);
		associated_panel.setDecryptedText(crypt_engine.getDecryptedText());
		
	}

}
