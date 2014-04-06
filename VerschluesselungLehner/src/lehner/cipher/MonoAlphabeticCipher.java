package lehner.cipher;

/**
 * In dieser Klasse sind setter und getter Methoden für das secret Alphabet und die
 * Methodendeklarationen, die für das Interface Cipher benötigt werden
 * 
 * @author Cindy Lehner
 * @version 2014-04-06
 */
public class MonoAlphabeticCipher implements Cipher{

	//Attribute
	private String secretAlphabet;
	
	//Konstruktor
	public MonoAlphabeticCipher(){
		this.secretAlphabet="abcdefghijklmnopqrstuvwxyzäöüß"; //Setzen des Alphabets
	}
	
	 /**
	  * Diese Methode gibt das geheime Alphabet zurück
	  * 
	  * @return  das Geheimalphabet
	  */
	public String getSecretAlphabet(){
		return this.secretAlphabet;
	}
	
	 /**
	  * Diese Methode setzt das geheime Alphabet auf ein neu eingegebenes Alphabet
	  * 
	  * @param secretAlphabet  das neue Alphabet
	  * @throws IllegalArgumentException  wenn zu wenige, zu viele oder doppelte Buchstaben vorkommen
	  */
	protected void setSecretAlphabet(String secretAlphabet) throws IllegalArgumentException{
		if(secretAlphabet.length()!=30){
			throw new IllegalArgumentException("Kein gültiges Alphabet angegeben");
		}
		for(int i=0;i<secretAlphabet.length()-1;i++){
			char buchstabe=secretAlphabet.charAt(i);
			for(int j=i+1;j<secretAlphabet.length();j++){
				if(buchstabe==secretAlphabet.charAt(j)){
					throw new IllegalArgumentException("Buchstaben dürfen nicht mehrmals vorkommen!");
				}
			}
		}
		this.secretAlphabet=secretAlphabet;
	}
	
	 /**
	  * Diese Methode verschlüsselt einen eingegeben Stringwert mit Hilfe von einem angegebenen
	  * secret Alphabet
	  * 
	  * @param text  der zu verschlüsselnde Text
	  * @return  der verschlüsselte Text
	  * @throws IllegalArgumentException  wenn ein Zeichen eingegeben wird, welches nicht im Alphabet
	  * enthalten ist
	  */
	@Override
	public String encrypt(String text) throws IllegalArgumentException{
		String textEncrypt = "";
		String textKlein = text.toLowerCase();
		String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		for(int i=0;i<textKlein.length();i++){
			char buchstabe = textKlein.charAt(i);
			int stelle = alphabet.indexOf(buchstabe);
			if(stelle==-1){
				throw new IllegalArgumentException("Kein registrierter Buchstabe angegeben!");
			}
			char b2 = this.secretAlphabet.charAt(stelle);
			textEncrypt+=b2;
		}
		return textEncrypt;
	}
	
	/**
	 * Diese Methode entschlüsselt einen eingegebenen Stringwert mit Hilfe von einem angegebenen
	 * secret Alphabet
	 * 
	 * @param text  der zu entschlüsselnde Text
	 * @return  der entschlüsselte Text
	 * @throws IllegalArgumentException  wenn ein Zeichen eingegeben wird, welches nicht im Alphabet
	  * enthalten ist
	 */
	@Override
	public String decrypt(String text) throws IllegalArgumentException{
		String textDecrypt = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		String textKlein = text.toLowerCase();
		for(int i=0;i<textKlein.length();i++){
			char buchstabe = textKlein.charAt(i);
			int stelle = this.secretAlphabet.indexOf(buchstabe);
			if(stelle==-1){
				throw new IllegalArgumentException("Kein registrierter Buchstabe angegeben!");
			}
			char b2 = alphabet.charAt(stelle);
			textDecrypt+=b2;
		}
		return textDecrypt;
	}
}
