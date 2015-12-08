package plugins;

import modele.Plugin;

public class RemoveSpacesPlugin implements Plugin {


	@Override
	public String getLabel() {
		return "Remove Spaces";
	}


	@Override
	public String transform
	(String input) {
		return input.replace(" ", "");
	}

	@Override
	public String helpMessage() {
		return "Removes all spaces from text area";
	}

}
