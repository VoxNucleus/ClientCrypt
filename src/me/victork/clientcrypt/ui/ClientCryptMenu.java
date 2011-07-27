package me.victork.clientcrypt.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import me.victork.clientcrypt.ui.action.Export2DiskAction;

public class ClientCryptMenu extends JMenuBar{
	
	private ClientCryptPanel main_panel;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2451495802974198409L;
	
	
	public ClientCryptMenu(ClientCryptPanel panel){
		super();
		main_panel=panel;
		build_client_crypt_menu();
	}
	/**
	 * Build the Client crypt menu
	 */
	private void build_client_crypt_menu() {
		JMenu aboutMenu = new JMenu("About/A Propos");
		
		JMenuItem about = new JMenuItem("About");
		aboutMenu.add(about);
		
		JMenu export_menu= new JMenu("Export");
		
		JMenuItem export_all = new JMenuItem("Export all to file");
		export_all.addActionListener(new Export2DiskAction(main_panel.getC_panel()));
		
		JMenuItem export_cod_mess = new JMenuItem("Export encoded message");
		
		export_menu.add(export_all);
		export_menu.add(export_cod_mess);
		

		JMenu import_menu = new JMenu("Import");
		JMenuItem import_from_file = new JMenuItem("Import from file");
		import_menu.add(import_from_file);
		
		this.add(export_menu);
		this.add(import_menu);
		this.add(aboutMenu);
		
	}

}
