package me.victork.clientcrypt.browser;

import javax.swing.JApplet;

import com.google.gson.Gson;

import me.victork.clientcrypt.ui.ClientCryptPanel;
import netscape.javascript.JSObject;


/**
 * Class managing interaction Browser via Javascript - Java applet 
 * Only one instance is authorized
 * @author victor
 *
 */
public class BrowserInteraction {
	
	public static String form_id="clientcrypt_target";
	private static JApplet applet;
	private static ClientCryptPanel panel;
	private static String JAVASCRIPT_FUNCTION="fill_enc";
	
	public BrowserInteraction instance=null;
	
	public BrowserInteraction getInstance(JApplet app,ClientCryptPanel pan){
		if(instance!=null){
			return instance;
		}else{
			return new BrowserInteraction(app,pan);}
	}
	
	private BrowserInteraction(JApplet app,ClientCryptPanel pan){
		applet=app;
		panel=pan;
	}
	/**
	 * 
	 */
	public static void invoke(JavaScriptAbstractMessage mess){
		JSObject window=JSObject.getWindow(applet);
		Gson gson_converter = new Gson();
		
		window.eval(JAVASCRIPT_FUNCTION+"("+ gson_converter.toJson(mess)+")");
		window.call(JAVASCRIPT_FUNCTION, null);
	}
	
	public static void receive(){
		panel.getC_panel().setDecryptedText("test");
	}
	

}
