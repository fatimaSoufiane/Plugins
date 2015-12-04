package plugins;

import modele.Plugin;

public class ToUpperPlugin implements Plugin {


	public String getLabel() {
		return "To Upper";
	}


	public String transform(String input) {
		String output = input.toUpperCase();
		return output;
	}


	public String helpMessage() {
		return "Transform all letters to capital letters";
	}

}
