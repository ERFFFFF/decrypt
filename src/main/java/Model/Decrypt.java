package Model;

public class Decrypt {
	
	public static String decrypte(String inputString, String key) {
		StringBuilder sb1;
		char c1;
		char c2;
		char c3;
		int i;
		int ii = 0;
		sb1 = new StringBuilder();
		for (i = 0; i < inputString.length(); i++) {
			c1 = inputString.charAt(i);
			c2 = key.charAt(ii);
			c3 = (char) (c1 ^ c2);
			sb1.append(c3);
			if (ii == key.length()) {
				ii = 0;
			}
		}
		return sb1.toString();

	}

}
