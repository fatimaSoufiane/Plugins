package modele;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class PluginFinderTest {
	protected PluginFinderMook pluginFinder; 

	@Before
	public void setUp() throws Exception {
		pluginFinder = new PluginFinderMook();
	}

	@Test
	public void testTheyAreNewsPlugins() {
		assertFalse(pluginFinder.theyAreNewsPlugins());
		pluginFinder.addFile(new File("ab"));
		assertTrue(pluginFinder.theyAreNewsPlugins());
		pluginFinder.knownPlugins.add(new File("z"));
		assertTrue(pluginFinder.theyAreNewsPlugins());
	}

	@Test
	public void testNotifyObservers() throws InterruptedException {
		PluginObserverMook pluginObserver = new PluginObserverMook();
		pluginFinder.addObserver(pluginObserver);
		pluginFinder.notifyObservers();
		assertFalse(pluginObserver.getHasBeenUpdate());
		pluginFinder.addFile(new File("ab"));
		pluginFinder.notifyObservers();
		assertTrue(pluginObserver.getHasBeenUpdate());		
	}

}
