package a_Introductory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuadrilateralTest {
	Quadrilateral square1, square2, rectangle1, rectangle2, quad;
	
	@Before
	public void setUp() throws Exception {
		/* Set up two squares,
		 * two rectangles that are not squares,
		 * and a quad that is neither a rectangle nor a square. */
		square1 = new Quadrilateral(new Point(-3, 1), new Point(-3, 4), new Point(0, 4), new Point(0, 1));	//was not a square
		square2 = new Quadrilateral(new Point(-1, -1), new Point(-1, 1), new Point(1, 1), new Point(1, -1)); //is a square
		rectangle1 = new Quadrilateral(new Point(1, 1), new Point(1, 3), new Point(4, 3), new Point(4, 1)); //was not a rectangle
		rectangle2 = new Quadrilateral(new Point(-2, -1), new Point(-2, 1), new Point(2, 1), new Point(2, -1)); //is a rectangle
		quad = new Quadrilateral(new Point(-2, -2), new Point(-1, 1), new Point(1, 1), new Point(1, -1)); 
	}
	
	@Test
	public void test123()	{
		String msg = "Should rectangle";
		assertTrue(msg,rectangle2.isRectangle());
		
	}
	
	@Test
	public void testRectangle() {
		String msg = "Should be a rectangle";
		assertFalse(msg, square1.isRectangle()); //Should be assert False
		assertFalse(msg, square2.isRectangle());// same as above
		assertTrue(msg, rectangle1.isRectangle());
		assertTrue(msg, rectangle2.isRectangle());
		assertFalse("Should not be a rectangle", quad.isRectangle());
	}
	
	@Test
	public void testSquare() {
		String tmsg = "Should be a square";
		String fmsg = "Should not be a square";
		assertTrue(tmsg, square1.isSquare());
		assertTrue(tmsg, square2.isSquare());
		assertFalse(fmsg, rectangle1.isSquare());
		assertFalse(fmsg, rectangle2.isSquare());
		assertFalse(fmsg, quad.isSquare());
	}
}
