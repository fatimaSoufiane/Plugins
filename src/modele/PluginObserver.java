package modele;
import java.util.Set;
import java.io.File;
/**
 * this interface represent the observers of pluginFinder 
 *
 */
public interface PluginObserver {
	public void update(Set<File> plugins);
}
