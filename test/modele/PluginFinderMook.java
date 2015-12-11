package modele;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class PluginFinderMook extends PluginFinder {

	public PluginFinderMook() {
		super(null, null);
		this.timer = null;
	}
	protected Set<File> files = new HashSet<File>(); 

	@Override
	protected Set<File> givePluginsInTheDirectory() {
		return files;
	}
	
	public void addFile(File file){
		this.files.add(file);
	}
	
	
	
	

}
