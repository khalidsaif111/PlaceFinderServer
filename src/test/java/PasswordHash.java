import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import junit.framework.TestCase;

public class PasswordHash extends TestCase {

	public void testMD5Hash() {
		String password = "secret";
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		String encodedPassword = md5PasswordEncoder.encodePassword(password, null);
		System.out.println("MD5 : " + encodedPassword);
	}
	
	public void testBCryptHash() {
		String password = "secret";
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		System.out.println("BCrypt : " + encodedPassword);
	}
}
