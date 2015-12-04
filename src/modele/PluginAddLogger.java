package modele;

import java.io.File;
import java.util.Set;
/**
 * this class just displays the list of plugin at each change
 *
 */
public class PluginAddLogger implements PluginObserver {

	@Override
	public void update(Set<File> plugins) {
		for (File file : plugins) {
			System.out.println(file.toString());
		}
		
	}
	
	public static void main(String[] args) {
		PluginFinder pluginFinder = new PluginFinder(new File("dropins"), new PluginFilter());
		pluginFinder.addObserver(new PluginAddLogger());
		pluginFinder.startToFindPlugins();
		while (true);
	}

}
