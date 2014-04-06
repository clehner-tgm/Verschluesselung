package lehner.test;

import lehner.cipher.MonoAlphabeticCipher;
import lehner.cipher.SubstitutionCipher;
import org.junit.Test;

/**
 * Testen der verschiedenen Methoden und Konstruktoren. Man versucht einen möglichst hohen
 * Abdeckungsgrad zu erreichen
 * 
 * @author Cindy Lehner
 * @version 2014-04-06
 */
public class Testing {

	@Test
	public void test1(){
		String a = "ßüöäzyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		if(s.getSecretAlphabet().equals(a)){
			System.out.println("setAlphabet Test1 gelungen");
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test2(){
		String a = "ßüöäzyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		s.setSecretAlphabet("ßüöäzyxwva");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test3(){
		String a = "ßüöäzyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		s.setSecretAlphabet("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	@Test
	public void test4(){
		String a = "ßüöäzyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		if(s.encrypt("cindy").equals("övqäf")){
			System.out.println("Encrypt Test gelungen!");
		}
	}
	
	@Test
	public void test5(){
		String a = "ßüöäzyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		if(s.decrypt("övqäf").equals("cindy")){
			System.out.println("Decrypt Test gelungen!");
		}
	}
	
	@Test
	public void test6(){
		MonoAlphabeticCipher m = new MonoAlphabeticCipher();
		if(m.getSecretAlphabet().equals("abcdefghijklmnopqrstuvwxyzäöüß")){
			System.out.println("MonoAlphabetic Test gelungen!");
		}
	}
	
	@Test
	public void test7(){
		String a = "ßüöäzyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		String texte = s.encrypt("CINDY");
		String textd = s.decrypt(texte);
		if(textd.equals("cindy")){
			System.out.println("Encrypt und Decrypt Test gelungen!");
		}
	}
	
	@Test
	public void test8(){
		String a = "ßüöäzyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		String texte = s.encrypt("CI7DY");
		String textd = s.decrypt(texte);
		if(textd.equals("ci7dy")){
			System.out.println("Encrypt und Decrypt Test2 gelungen!");
		}
	}
}
