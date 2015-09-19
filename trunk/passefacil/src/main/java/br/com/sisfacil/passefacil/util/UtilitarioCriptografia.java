package br.com.sisfacil.passefacil.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.ajax4jsf.util.base64.Base64;

public class UtilitarioCriptografia {

	private static final int KEYLENGTH_MULTIPLIER = 8;
	
	//Gera a chave encriptada
	public static byte[] encriptarPBKDF2(String password, byte[] salt, int iterations,
	        int outputBytes) throws NoSuchAlgorithmException,
	        InvalidKeySpecException {
	    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations,
	            outputBytes * KEYLENGTH_MULTIPLIER);
	    SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	    return f.generateSecret(spec).getEncoded();
	}

	//retorna a chave sem a criptografia
	public static String descriptarPBKDF2ToBase64(String password, byte[] salt, int iterations,
	        int outputBytes){
	    try {
	        return new String(Base64.encodeBase64(encriptarPBKDF2(password, salt, iterations, outputBytes)), "UTF-8");
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (InvalidKeySpecException e) {
	        e.printStackTrace();
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
}
