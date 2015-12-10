package modele;

import java.io.File;
/**
 * this class represent the constraints format on the file that are plugins
 */
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

/**
 * A simple FilenameFilter, searching for .class, in a specified folder.
 */
public class PluginFilter implements FilenameFilter {

	/**
	 * Method accept() is expecting to find .class in the directory specified at
	 * instantiation.
	 */

	@Override
	public boolean accept(File dir, String name) {
		if (!fileExtensionIsClass(name)) {
			return false;
		}
		Class<?> theClass = getClass(name);
		if (theClass == null) {
			return false;
		}
		return inheritFromPlugin(theClass) && classInPluginsPackage(theClass)
				&& classHasParameterlessConstructor(theClass);
	}

	/**
	 * Check if the file's extension is a .class
	 * 
	 * @param filename
	 *            with extension included
	 * @return true if correct extension
	 */
	protected boolean fileExtensionIsClass(String filename) {
		return filename.endsWith(".class");
	}

	/**
	 * Returns the class by its path and name
	 * 
	 * @param dir
	 *            directory examined
	 * @param filename
	 *            file name
	 * @return class
	 */
	protected Class<?> getClass(String filename) {
		String classname = filename.replaceFirst("\\.class$", "");
		try {
			return Class.forName("plugins." + classname);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	/**
	 * Check if given class is inherited from the interface "Plugin"
	 * 
	 * @param theClass
	 *            to test
	 * @return true is it inherits from Plugin
	 */
	protected boolean inheritFromPlugin(Class<?> theClass) {
		return Plugin.class.isAssignableFrom(theClass);
	}

	/**
	 * Check the package of the class
	 * 
	 * @param theClass
	 *            to test
	 * @return true if in package "plugins"
	 */
	protected boolean classInPluginsPackage(Class<?> theClass) {
		return theClass.getPackage().getName().equals("plugins");
	}

	/**
	 * Check if the class can be instancied without parameter
	 * 
	 * @param theClass
	 *            to test
	 * @return true if has a parameterless constructor
	 */
	protected boolean classHasParameterlessConstructor(Class<?> theClass) {
		for (Constructor<?> contructor : theClass.getConstructors()) {
			if (contructor.getParameterTypes().length == 0) {
				return true;
			}
		}
		return false;
	}

}
