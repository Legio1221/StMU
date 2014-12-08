package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals((Integer)10000,SEK100.getAmount());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK,SEK100.getCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("10000 SEK\n",SEK100.toString());
	}

	@Test
	public void testGlobalValue() {
		assertEquals((Integer)1500,SEK100.getCurrency().universalValue(10000));
	}

	@Test
	public void testEqualsMoney() {
		assertTrue(SEK100.equals(EUR10));
	}

	@Test
	public void testAdd() {
		Money test = SEK100.add(EUR10);
		assertEquals((Integer)20000,test.getAmount());
	}

	@Test
	public void testSub() {
		Money test = SEK100.sub(EUR10);
		assertEquals((Integer)0,test.getAmount());
	}

	@Test
	public void testIsZero() {
		assertTrue(EUR0.isZero());
		assertFalse(EUR10.isZero());
	}

	@Test
	public void testNegate() {
		Integer x = -1000;
		assertEquals(x,EUR10.negate().getAmount());
	}

	@Test
	public void testCompareTo() {
		assertEquals(-10000,SEK100.compareTo(EUR20));
	}
}
