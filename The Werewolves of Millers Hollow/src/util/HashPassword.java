/**
 * package util
 */
package util;

/**
 * Imported libraries and classes.
 */
import java.security.MessageDigest;

/**
 * 
 * @author Tiffany Dumaire
 * 
 */
public class HashPassword {
		
	/**
	 * Function allows the possibility to encoding password.
	 * @param password : password you would like encoding
	 * @return an SHA-256, encoding password
	 * @throws Exception
	 */
	public static String hashPassword(String password) throws Exception {
		//Help website : http://www.codeurjava.com/2016/12/hashage-md5-et-sha-256-en-java.html
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < byteData.length;i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

}
