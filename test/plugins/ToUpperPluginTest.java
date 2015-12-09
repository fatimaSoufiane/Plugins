package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.ToUpperPlugin;

public class ToUpperPluginTest {

	@Test
	public void transformTest() {
		
		ToUpperPlugin toupperPlugin = new ToUpperPlugin();
		
		String result = toupperPlugin.transform("abc");
		
		assertEquals("ABC",result);
			}

}
