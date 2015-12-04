package plugins;

import modele.Plugin;

public class ReverseCase implements Plugin {


	public String getLabel() {
		return "Reverse Case";
	}


	public String transform(String input) {
		char[] output = input.toCharArray();
		for (int i = 0; i < output.length; i++) {
			char c = output[i];
			if (Character.isUpperCase(c)) {
				output[i] = Character.toLowerCase(c);
			} else if (Character.isLowerCase(c)) {
				output[i] = Character.toUpperCase(c);
			}
		}
		return new String(output);
	}


	public String helpMessage() {
		return "Reverse capital and normal letters";
	}

}
