package me.victork.clientcrypt.main;


import javax.swing.JApplet;
import javax.swing.JFrame;
import me.victork.clientcrypt.ui.ClientCryptMenu;
import me.victork.clientcrypt.ui.ClientCryptPanel;

public class ClientCrypt extends JApplet {
	
	public static final String VERSION_NUMBER="0.1";
	public static final String AUTHOR="Victor Kabdebon";
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1669853830436472024L;
	
	    //============================================================ main
	    public static void main(String[] args) {
	        //... Create an initialize the applet.
	        
	        //theApplet.init();         // Needed if overridden in applet
	        //theApplet.start();        // Needed if overridden in applet
	        
	        //... Create a window (JFrame) and make applet the content pane.
	        JFrame window = new JFrame("ClientCrypt - v0.1");
	        JApplet ccryptapp = new ClientCrypt();
	        
	        
	        
	        window.setContentPane(ccryptapp);
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //window.pack();              // Arrange the components.
	        window.setVisible(true);    // Make the window visible.
	    }
	    
	    
	    public ClientCrypt() {
	    	ClientCryptPanel main_panel = new ClientCryptPanel();
	    	
	    	ClientCryptMenu menu = new ClientCryptMenu(main_panel);
	    	setJMenuBar(menu);
	    	
	        add(main_panel);
	        
	    }


}
