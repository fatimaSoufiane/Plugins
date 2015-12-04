package plugins;

import modele.Plugin;

public class WithSpacesPlugin implements Plugin {

	@Override
	public String getLabel() {
		return "Add Spaces";
	}

	@Override
	public String transformString(String input) {
		String output = "";
		for (int i = 0; i < input.length(); ++i)
			output += input.charAt(i) + " ";
		return output;
	}

	@Override
	public String helpMessage() {
		return "Add one space after each letter";
	}

}
