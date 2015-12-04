package plugins;

import modele.Plugin;

public class CaesarCipher3 implements Plugin {

	static char[] alphabet = { 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
			't', 'u', 'v', 'w' };

	@Override
	public String getLabel() {
		return "Caesar Cipher (-3)";
	}

	@Override
	public String transformString(String input){
		char[] tab = input.toCharArray();
		for (int i = 0; i < tab.length; ++i)
			if (Character.isLetter(tab[i]))
				tab[i] = alphabet[((int) tab[i]) - ((Character.isLowerCase(tab[i])) ? 97 : 65)];
		return new String(tab);
	}

	@Override
	public String helpMessage() {
		return "Replace each letter with a left shift of 3.";
	}
}
