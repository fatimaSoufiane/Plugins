package plugins;

/*
 * This class remove all vowels from the text
 */
import modele.Plugin;

public class RemoveVoyels implements Plugin {

	@Override
	public String getLabel() {
		return "Remove Voyels";
	}

	@Override
	public String transform(String input) {
		return input.replaceAll("[AEIOUaeiou]", "");
	}

	@Override
	public String helpMessage() {
		return "Remove all vowels from the text";
	}

}
