package me.victork.clientcrypt.core;



import java.io.UnsupportedEncodingException;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.engines.BlowfishEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

import me.victork.clientcrypt.core.CryptographyOptions.CRYPTOGRAPHY_OPTIONS;

public class ClientCryptEngine {
	
	private BufferedBlockCipher cipher;
	private KeyParameter key;
	
	
	private CRYPTOGRAPHY_OPTIONS chosen_option;
	private int c_strength;
	private String string_input;
	private String password;
	private byte[] byte_password;

	/**
	 * Constructor
	 * @param option
	 * @param strength
	 * @param pass
	 * @param input
	 */

	public ClientCryptEngine(CRYPTOGRAPHY_OPTIONS option, int strength,String pass, String input){
		chosen_option=option;
		c_strength=strength;
		string_input=input;
		password=pass;
		
	}

	/**
	 * 
	 * @return the decrypted text
	 */
	public String getDecryptedText(){
		
		byte_password=password.getBytes();
		key=new KeyParameter( byte_password );
		
		String decrypted_text="Nothing";
		try{
			decrypted_text=decrypt_text();
		}catch(Exception ex){
			decrypted_text="Une erreur est survenue";
		}
		
		return decrypted_text;
	}

	/**
	 * 
	 * @return the encrypted byte representation
	 */
	public String getEncryptedText(){
		
		byte_password=password.getBytes();
		key=new KeyParameter( byte_password );
		
		String answer="";
		try{
			answer=encrypt_text();
		}catch(Exception ex){
			answer="Une erreur est survenue";
		}
		return answer;
	}

	/**
	 * TODO : Catch Exception at this point ?
	 * @throws CryptoException
	 * @throws UnsupportedEncodingException 
	 */

	private String encrypt_text() throws CryptoException, UnsupportedEncodingException {
		if(!string_input.isEmpty()){
			
			BlockCipher engine = CryptographyOptions.get_engine(chosen_option);
			cipher = new PaddedBufferedBlockCipher(
					new CBCBlockCipher(engine ) );
			cipher.init(true, key);
			
			byte[] encrypted_data =callCipher(string_input.getBytes());
			return new String(Hex.encode(encrypted_data),"UTF-8");
		}else{
			return "test";
		}
	}
	
	public byte[] decrypt( byte[] data )
	throws CryptoException {
		if( data == null || data.length == 0 ){
			return new byte[0];
		}
		byte[]todecode=Hex.decode(data);
		BlockCipher engine = CryptographyOptions.get_engine(chosen_option);
		cipher = new PaddedBufferedBlockCipher(
				new CBCBlockCipher(engine ) );
		
		cipher.init( false, key );
		return callCipher( todecode );
	}

	private byte[] callCipher( byte[] data )  throws CryptoException {
		int    size =
			cipher.getOutputSize( data.length );
		byte[] result = new byte[ size ];
		int    olen = cipher.processBytes( data, 0,
				data.length, result, 0 );
		olen += cipher.doFinal( result, olen );

		if( olen < size ){
			byte[] tmp = new byte[ olen ];
			System.arraycopy(
					result, 0, tmp, 0, olen );
			result = tmp;
		}
		return result;
	}




	private String decrypt_text() throws CryptoException, UnsupportedEncodingException{
		if(!string_input.isEmpty()){
			return new String(decrypt(string_input.getBytes("UTF-8")));
		}else{
			return "Descrypted";
		}
	}


}
