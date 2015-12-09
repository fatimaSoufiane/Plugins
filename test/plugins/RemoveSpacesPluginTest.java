package plugins;
import static org.junit.Assert.*;
import org.junit.Test;
import plugins.RemoveSpacesPlugin;

public class RemoveSpacesPluginTest {

	@Test
	public void transformTest() {
		
		RemoveSpacesPlugin removeSpacesplugin = new RemoveSpacesPlugin();
		String result = removeSpacesplugin.transform("r a c h i d");
		assertEquals("rachid",result);		
	}

}
