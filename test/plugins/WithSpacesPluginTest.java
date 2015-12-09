package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.WithSpacesPlugin;

public class WithSpacesPluginTest {

	@Test
	public void transformTest() {
		
		WithSpacesPlugin withSpacesPlugin = new WithSpacesPlugin();
		String result = withSpacesPlugin.transform("abcdef");
		assertEquals("a b c d e f ",result);		
	}
}
