package modele;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Timer;

public class PluginFinder {
	protected static final int refresh_Interval_ms = 1000;
	protected Set<File> knownPlugins = new HashSet<File>();
	protected Set<PluginObserver> observers = new HashSet<PluginObserver>();
	protected final File directory;
	protected FilenameFilter filter;
	protected Timer timer =  new Timer(refresh_Interval_ms, new ActionListenerForPlugins(this));
	public PluginFinder(File directory, FilenameFilter filter) {
		this.directory = directory;
		this.filter = filter;
	}
	
	protected Set<File> givePluginsInTheDirectory() {
		Set<File> pluginsInTheDirectory = new HashSet<>();
		pluginsInTheDirectory.addAll(Arrays.asList(directory.listFiles(filter)));
		return pluginsInTheDirectory;
	}
	
	protected Boolean theyAreNewsPlugins(){
		Set<File> pluginsInTheDirectory = givePluginsInTheDirectory();
		if (pluginsInTheDirectory.size() == knownPlugins.size())
			return pluginsInTheDirectory.retainAll(knownPlugins);
		else 
			return true;
	}
	
	public void notifyObservers(){
		if (theyAreNewsPlugins()){
			knownPlugins = givePluginsInTheDirectory();
			for (PluginObserver observer : observers){
				observer.update(knownPlugins);
			}
		}
	}
	
	public void addObserver(PluginObserver observer){
		observers.add(observer);
	}
	
	public void startToFindPlugins(){
		timer.start();
	}
	
}
