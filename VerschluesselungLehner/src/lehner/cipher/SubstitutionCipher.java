package lehner.cipher;

/**
 * Diese Klasse erbt von MonoAlphabeticCipher und setzt das geheime Alphabet
 * 
 * @author Cindy Lehner
 * @version 2014-04-06
 */
public class SubstitutionCipher extends MonoAlphabeticCipher {

	//Konstruktor
	public SubstitutionCipher(String secretAlphabet){
		setSecretAlphabet(secretAlphabet);
	}
	
	/**
	 * Setzt das geheime Alphabet
	 * 
	 * @param secretAlphabet  das geheime Alphabet
	 */
	public void setSecretAlphabet(String secretAlphabet){
		super.setSecretAlphabet(secretAlphabet);
	}
}
