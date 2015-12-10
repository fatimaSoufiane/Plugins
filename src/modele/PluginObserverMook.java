package modele;

import java.io.File;
import java.util.Set;

public class PluginObserverMook implements PluginObserver {
	protected Boolean HasBeenUpdate = false;

	@Override
	public void update(Set<File> plugins) {
		this.HasBeenUpdate = true;	
	}

	public Boolean getHasBeenUpdate() {
		return HasBeenUpdate;
	}

}
