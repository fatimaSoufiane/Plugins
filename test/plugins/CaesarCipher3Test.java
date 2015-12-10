package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.CaesarCipher3;

public class CaesarCipher3Test {

	@Test
	public void transformTest() {		
		CaesarCipher3 caesarCipher3 = new CaesarCipher3();
		String result = caesarCipher3.transform("def");
		assertEquals("abc",result);		
	}
	
	


}
