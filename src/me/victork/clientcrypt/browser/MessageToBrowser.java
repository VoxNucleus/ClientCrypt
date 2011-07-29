package me.victork.clientcrypt.browser;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author victor
 *
 */

public class MessageToBrowser extends JavaScriptAbstractMessage  {
	
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

	@Override
	public String toJSONString()  {
		JSONObject object = new JSONObject();
		try {
			object.put("form_id", form_id);
			object.put("algorithm", algorithm);
			object.put("encrypted_txt", encrypted_txt);
			return object.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
