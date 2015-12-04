package plugins;

import modele.Plugin;

public class RemoveVoyels implements Plugin {

	@Override
	public String getLabel() {
		return "Remove Voyels";
	}

	@Override
	public String transformString(String input) {
		return input.replaceAll("[AEIOUaeiou]", "");
	}

	@Override
	public String helpMessage() {
		return "Remove all voyels from the text";
	}

}
