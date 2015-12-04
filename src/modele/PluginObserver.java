package modele;
import java.util.Set;
import java.io.File;

public interface PluginObserver {
	public void update(Set<File> plugins);
}
