package modele;

/**
 * this interface represent the observers of pluginFinder
 *
 */
import java.util.Set;
import java.io.File;

public interface PluginObserver {
	/**
	 * Method update(), should be used to warn/fire the observer from the
	 * Observable
	 */
	public void update(Set<File> plugins);
}
