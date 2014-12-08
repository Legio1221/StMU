package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathOperationsTest {

	@Test
	public void testMathOperations() {
		MathOperations m = new MathOperations();
		assertEquals(4, m.x);
		assertEquals(5, m.y);
	}

	@Test
	public void testAdd() {
		MathOperations m = new MathOperations();
		int z;
		
		assertEquals(9,MathOperations.add(m.x, m.y));
	}

	@Test
	public void testMul() {
		MathOperations m = new MathOperations();
		assertEquals(20,MathOperations.mul(m.x, m.y));
	}

}
