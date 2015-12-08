package plugins;

import modele.Plugin;

public class ReverseCase implements Plugin {


	@Override
	public String getLabel() {
		return "Reverse Case";
	}


	@Override
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


	@Override
	public String helpMessage() {
		return "Reverse capital and normal letters";
	}

}
