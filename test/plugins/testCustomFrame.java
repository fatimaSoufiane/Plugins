package plugins;

import static org.junit.Assert.*;

import java.io.File;

import javax.swing.text.BadLocationException;

import org.junit.Test;

import view.CustomFrame;

public class testCustomFrame {
	@Test
	public void testUpdateTitle() {
		CustomFrame CF = new CustomFrame();
		assertFalse(CF.jFrame.getTitle().contains("*"));

		CF.updateTitle();
		assertTrue(CF.jFrame.getTitle().contains("*"));
		CF.file = new File("test/EditorTest.java");
		CF.updateTitle();
		assertTrue(CF.jFrame.getTitle().contains("EditorTest.java"));
	}

	@Test
	public void testReset() throws BadLocationException {
		CustomFrame CF = new CustomFrame();
		CF.file = new File("test/EditorTest.java");
		assertTrue(CF.jFrame.getTitle().contains("*"));
		assertTrue(CF.jFrame.getTitle().contains("EditorTest.java"));
		CF.reset();
		assertFalse(CF.jFrame.getTitle().contains("*"));
		assertFalse(CF.jFrame.getTitle().contains("EditorTest.java"));
		assertEquals(0, CF.textArea.getDocument().getLength());
	}

}
