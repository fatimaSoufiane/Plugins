package plugins;

import modele.Plugin;

public class ToUpperPlugin implements Plugin {


	@Override
	public String getLabel() {
		return "To Upper";
	}


	@Override
	public String transform(String input) {
		String output = input.toUpperCase();
		return output;
	}


	@Override
	public String helpMessage() {
		return "Transform all letters to capital letters";
	}

}
