package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.RemoveVoyels;

public class RemoveVoyelsTest {

	@Test
	public void transformTest() {
		
		RemoveVoyels removeVoyels = new RemoveVoyels();
		String result = removeVoyels.transform("abacidef");
		assertEquals("bcdf",result);		
	}
}
