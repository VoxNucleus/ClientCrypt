package me.victork.clientcrypt.browser;

import org.json.JSONString;

public abstract class JavaScriptAbstractMessage implements JSONString {
	
	public static String associated_function="";
	
	public String getAssociated_function(){
		return associated_function;
	}

}
