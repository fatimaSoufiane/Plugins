package plugins;

import modele.Plugin;

public class WithSpacesPlugin implements Plugin {


	public String getLabel() {
		return "Add Spaces";
	}


	public String transform(String input) {
		String output = "";
		for (int i = 0; i < input.length(); ++i)
			output += input.charAt(i) + " ";
		return output;
	}

	public String helpMessage() {
		return "Add one space after each letter";
	}

}
