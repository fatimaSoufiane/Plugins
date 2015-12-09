package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.ToLowerPlugin;

public class ToLowerPluginTest {
	
	@Test
	public void transformString() {
		ToLowerPlugin tolowerPlugin=new ToLowerPlugin();

		String result = tolowerPlugin. transform("ABC");
		
	    assertEquals("abc",result);
	}
}
