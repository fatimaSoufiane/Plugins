package modele;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * an instance of this class is call when a change in a list of plugin is
 * observed
 */
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
