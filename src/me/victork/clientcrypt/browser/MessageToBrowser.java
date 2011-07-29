package me.victork.clientcrypt.browser;


/**
 * 
 * @author victor
 *
 */
public class MessageToBrowser extends JavaScriptAbstractMessage {
	
	public static String associated_function="fill_enc";
	
	private String form_id="";
	private String algorithm="";
	private String encrypted_txt="";
	
	public MessageToBrowser(String id, String algo,String encrypted){
		form_id=id;
		algorithm=algo;
		encrypted_txt=encrypted;
	}
	
	public String getForm_id(){
		return form_id;
	}
	
	public String getAlgorithm(){
		return algorithm;
	}
	
	public String getEncrypted_txt(){
		return encrypted_txt;
	}

}
