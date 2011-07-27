package me.victork.clientcrypt.core;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.engines.BlowfishEngine;
import org.bouncycastle.crypto.engines.RijndaelEngine;
import org.bouncycastle.crypto.engines.SerpentEngine;
import org.bouncycastle.crypto.engines.TwofishEngine;

public class CryptographyOptions {
	
	public static enum CRYPTOGRAPHY_OPTIONS{
		TWOFISH("Twofish"),
		RIJNDAEL("Rijndael"),
		SERPENT("Serpent"),
		BLOWFISH("Blowfish"),
		AES("AES"),
		DES("DES");
		
		private String display_name;
		
		CRYPTOGRAPHY_OPTIONS(String name){
			display_name=name;
		}
		
		/**
		 * 
		 */
		
		public String toString(){
			return display_name;
		}
		
		/**
		 * 
		 * @param option_name
		 * @return
		 */
		
		public boolean equals(String option_name){
			return display_name.equalsIgnoreCase(option_name);
		}
		
		/**
		 * 
		 * @param name
		 * @return
		 */
		
		public static CRYPTOGRAPHY_OPTIONS get_option_from_name(String name){
			CRYPTOGRAPHY_OPTIONS default_op= CRYPTOGRAPHY_OPTIONS.TWOFISH;
			
			for(CRYPTOGRAPHY_OPTIONS option :CRYPTOGRAPHY_OPTIONS.values()){
				if(option.equals(name)){
					default_op=option;
				}
			}
			
			return default_op;
		}
		
	}
	
	/**
	 * 
	 * @param option
	 * @return the selected engine
	 */
	
	
	public static BlockCipher get_engine(CRYPTOGRAPHY_OPTIONS option){
		
		BlockCipher selected_engine=null;
		switch(option){
		case TWOFISH:
			selected_engine= new TwofishEngine();
			break;
		case RIJNDAEL:
			selected_engine = new RijndaelEngine();
			break;
		case SERPENT:
			selected_engine = new SerpentEngine();
			break;
		case BLOWFISH:
			selected_engine= new BlowfishEngine();
			break;
		case AES:
			selected_engine = new AESEngine();
			break;
		case DES:
			selected_engine= new AESEngine();
			break;
		default:
			selected_engine = new TwofishEngine();
			break;

		}

		return selected_engine;
	}

}
