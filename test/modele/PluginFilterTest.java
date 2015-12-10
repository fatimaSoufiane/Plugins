package modele;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PluginFilterTest {
	protected PluginFilter filter;
	protected Class<?> classRespectsContraint;
	protected Class<?> classNotRespectsContraint;

	@Before
	public void setUp() throws Exception {
		filter = new PluginFilter();
		classRespectsContraint = Class.forName("plugins.PluginRespectsConstraintMooc");
		classNotRespectsContraint = Class.forName("modele.PluginNotRespectsConstraintMooc");
	}


	@Test
	public void testAccept() {
		assertTrue(filter.accept(null,"PluginRespectsConstraintMooc.class"));
		assertFalse(filter.accept(null,"PluginNotRespectsConstraintMooc.class"));
	}

	@Test
	public void testFileExtensionIsClass() {
		assertTrue(filter.fileExtensionIsClass("fichier.class"));
		assertFalse(filter.fileExtensionIsClass("fichier.nope"));
	}
	
	@Test
	public void testGetClassFileString() {
		assertNotNull(filter.getClass("PluginRespectsConstraintMooc.class"));
		assertNull(filter.getClass("abcd"));
	}

	@Test
	public void testInheritFromPlugin() {
		assertTrue(filter.inheritFromPlugin(classRespectsContraint));
		assertFalse(filter.inheritFromPlugin(classNotRespectsContraint));
	}

	@Test
	public void testClassInPluginsPackage() {
		assertTrue(filter.classInPluginsPackage(classRespectsContraint));
		assertFalse(filter.classInPluginsPackage(classNotRespectsContraint));
	}

	@Test
	public void testClassHasParameterlessConstructor() {
		assertTrue(filter.classHasParameterlessConstructor(classRespectsContraint));
		assertFalse(filter.classHasParameterlessConstructor(classNotRespectsContraint));
	}

}
