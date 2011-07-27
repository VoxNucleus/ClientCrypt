package me.victork.clientcrypt.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import me.victork.clientcrypt.core.IODisk;
import me.victork.clientcrypt.ui.CryptPanel;

public class Export2DiskAction implements ActionListener {
	
	private CryptPanel cPanel;

	public Export2DiskAction(CryptPanel panel) {
		cPanel=panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IODisk io_disk = new IODisk();
		
		//Set params
		io_disk.setAlgorithm(cPanel.getCryptographyOption().toString());
		io_disk.setEncrypted_txt(cPanel.getEncryptedText());
		io_disk.setUnencrypted_txt(cPanel.getDecryptedText());
		io_disk.setPassword(cPanel.getPassword());
		
		//Save file
		io_disk.save_to_file();
	}

}
