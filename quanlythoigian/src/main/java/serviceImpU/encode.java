package serviceImpU;

import java.util.Random;

public class encode {
	public String encodepass() {
		int length = 12;
		String text = "123456789abcdef@uizH";
		Random rd = new Random();
		StringBuilder randomString = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int index = rd.nextInt(text.length());
			char randomChar = text.charAt(index);
			randomString.append(randomChar);
		}
		return randomString.toString();
	}

}
