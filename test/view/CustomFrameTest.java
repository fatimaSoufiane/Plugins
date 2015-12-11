package view;

import static org.junit.Assert.*;

import javax.swing.JMenu;

import org.junit.Before;
import org.junit.Test;

public class CustomFrameTest {
	CustomFrame frame;
	
	@Before
	public void setUp() throws Exception {
		frame = new CustomFrame();
	}

	@Test
	public void testAddJmenuFile() {
		frame.addJmenuFile();
		JMenu jmFile = frame.jMenuBar.getMenu(0);
		assertEquals(2, jmFile.getItemCount());
	}

	@Test
	public void testAddJmenuHelp() {
		frame.addJmenuHelp();
		JMenu jmHelp = frame.jMenuBar.getMenu(0);
		assertEquals(2, jmHelp.getItemCount());
	}


}
