package plugins;

import modele.Plugin;

public class RemoveVoyels implements Plugin {


	public String getLabel() {
		return "Remove Voyels";
	}


	public String transform(String input) {
		return input.replaceAll("[AEIOUaeiou]", "");
	}


	public String helpMessage() {
		return "Remove all voyels from the text";
	}

}
