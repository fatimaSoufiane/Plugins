package modele;

/**
 * represent a plugins which can transform a string to an another string /**
 * represents a plugin that can be dynamiccaly added to the extendable editor. A
 * plugin can perform a transformation on a String. A menu item corresponds to a
 * plugin in the customFrame
 */
public interface Plugin {

	/**
	 * performs a transformation on a string
	 * 
	 * @param s the string to be transformed
	 *             
	 * @return the transformed string
	 */
	public String transform(String s);

	/**
	 * returns a label associated to this plugin.
	 * 
	 * @return a label associated to this plugin.
	 */

	public String getLabel();

	/**
	 * a help message describing the plugin tranformation operation
	 * 
	 * @return a help message describing the plugin tranformation operation
	 */
	public String helpMessage();
}
