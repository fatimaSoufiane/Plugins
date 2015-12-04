package plugins;

import modele.Plugin;

public class ToLowerPlugin implements Plugin {


	public String getLabel() {
		return "To Lower";
	}

	public String transform(String input) {
		String output = input.toLowerCase();
		return output;
	}


	public String helpMessage() {
		return "Transform all capital letters to normal letters";
	}

}
