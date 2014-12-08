package a_Introductory;


import org.junit.Before;
import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {
	Point p1, p2, p3;
	
	@Before
	public void setUp()	{
		p1 = new Point(7, 9);
		p2 = new Point(-3, -30);
		p3 = new Point(-10, 3);
		
	}
	
	@Test
	public void testAdd() {
		Integer xResult,yResult;
		Point res1 = new Point(5,5);
		res1 = res1.add(res1, 3, 2);
		Point res2 = p1.add(p3, 4,4);
		
		xResult = 8;
		assertEquals(xResult ,res1.x);
		yResult = 7;
		assertEquals(yResult, res1.y);
		xResult = -6;
		assertEquals(xResult, res2.x);
		yResult = 7;
		assertEquals(yResult, res2.y);
	}
	
	@Test
	public void testSub() {
		Point res1 = p1.sub(p2, 2,3);
		Point res2 = p1.sub(p3,4,5);
		Integer xResult, yResult;
		
		xResult = 5;
		assertEquals(xResult, res1.x);
		yResult = 33;
		assertEquals(yResult, res1.y);
		xResult = 14;
		assertEquals(xResult, res2.x);
		yResult = 2;
		assertEquals(yResult, res2.y);
	}

}
