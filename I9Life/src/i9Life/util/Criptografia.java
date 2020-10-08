package i9Life.util;

import org.apache.commons.codec.binary.Base64;

public class Criptografia {

	public static String criptografa(String senha) {
		return Base64.encodeBase64String(senha.getBytes());
	}

	public static String descriptografa(String senhaCodificada) {
		byte[] decoded = Base64.decodeBase64(senhaCodificada.getBytes());
		String decodedString = new String(decoded);

		return decodedString;
	}

}
