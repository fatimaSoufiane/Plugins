package modele;
/**
 * an instance of this class is call when a change in a list of plugin is observed
 */
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
