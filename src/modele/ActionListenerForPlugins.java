package modele;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerForPlugins implements ActionListener {
	
	PluginFinder pluginFinder;
	
	public ActionListenerForPlugins(PluginFinder pluginFinder) {
		this.pluginFinder = pluginFinder;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pluginFinder.notifyObservers();
	}
}
