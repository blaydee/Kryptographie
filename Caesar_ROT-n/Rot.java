public abstract class Rot {
	
	/**
	 * Encryption and decryption utilizing the ROT-n cipher.
	 * Case sensitive and supports special characters but only encrypts letters.
	 * 
	 * @Version 1.0
	 * @author Sami
	 */
	
	//Test
	public static void main(String[] args) {
		decrypt(encrypt("hallo sup!? ABCD!", 1), 1);
	}

	//Encryption
	public static String encrypt(String message, int key) {
		char[] chars = message.toCharArray();
		String enc = "";
		for(char c : chars) {
			if(Character.isUpperCase(c)) {
				enc += (char) (((c - 'A' + key)) % 26 + 'A');
			} else if(Character.isLowerCase(c)){
				enc += (char) (((c - 'a' + key)) % 26 + 'a');
			} else {
				enc += c;
			}
		}
		System.out.println("Encrypted String \"" + message + "\" with key " + key + " to String \"" + enc + "\".");
		return enc;
	}
	
	//Decryption
	public static String decrypt(String enc, int key) {
		char[] chars = enc.toCharArray();
		String message = "";
		for(char c : chars) {
			if(Character.isUpperCase(c)) {
				message += (char) (((c - 'A' - key)) % 26 + 'A');
			} else if(Character.isLowerCase(c)){
				message += (char) (((c - 'a' - key)) % 26 + 'a');
			} else {
				message += c;
			}
		}
		System.out.println("Decrypted String \"" + enc + "\" with key " + key + " to String \"" + message + "\".");
		return message;
	}
	
}
