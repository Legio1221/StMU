package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class RepeatLetterTest {

	@Test
	public void test() {
		//Boom, should return repeated letters once. 
		//Character, should return repeated words 0. 
		char[] word = {'b','o','o','m'};
		char[] word2 = {'c','h','a','r','a','c','t','e','r'};
		assertEquals(1,RepeatLetter.repeat(word));
		assertEquals(0,RepeatLetter.repeat(word2));
	}

}