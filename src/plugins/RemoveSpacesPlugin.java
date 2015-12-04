package plugins;

import modele.Plugin;

public class RemoveSpacesPlugin implements Plugin {


	public String getLabel() {
		return "Remove Spaces";
	}


	public String transform
	(String input) {
		return input.replace(" ", "");
	}

	public String helpMessage() {
		return "Removes all spaces from text area";
	}

}
