package plugins;

import modele.Plugin;

public class ToLowerPlugin implements Plugin {


	@Override
	public String getLabel() {
		return "To Lower";
	}

	@Override
	public String transform(String input) {
		String output = input.toLowerCase();
		return output;
	}


	@Override
	public String helpMessage() {
		return "Transform all capital letters to normal letters";
	}

}
