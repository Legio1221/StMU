package a_Introductory;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Vector2DTest {
	Vector2D v1, v2, v3;
	Point p1, p2, p3, p4;

	@Before
	public void setUp() throws Exception {
		/* v1 and v3 are orthogonal, v1 and v2 aren't. */
		
		//Vector 2 Points
		p1 = new Point(20,20);
		p2 = new Point(50,50);
		//Vector 3 Points
		p3 = new Point(50,10);
		p4 = new Point(50,100);
		
		v1 = new Vector2D();
		v2 = new Vector2D(p1, p2);
		v3 = new Vector2D(p3, p4);
	}

	@Test
	public void testDotProduct() {
		assertEquals("v1 and v3 are orthogonal. The dot product should be zero.", 0, v1.dotProduct(v3));
		assertEquals("The dot product of v1 and v2 should be (-2 * 1) + (4 * 2) = 6", 3000, v1.dotProduct(v2));
	}
	
	@Test
	public void testOrthogonality() {
		assertFalse("v1 should not be orthogonal to v2", v1.isOrthogonalTo(v2));
		assertTrue("v1 should be orthogonal to v3", v1.isOrthogonalTo(v3));
	}
}
