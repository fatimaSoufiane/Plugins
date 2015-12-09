package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.RemoveSpacesPlugin;
import plugins.ReverseCase;

@SuppressWarnings("unused")
public class ReverseCaseTest {

	@Test
	public void transformTest() {
		
		ReverseCase reverseCase = new ReverseCase();
		
		String result = reverseCase.transform("abc");
		
		assertEquals("ABC",result);
			}
	}

	
	
	

