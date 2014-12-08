package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals("SEK",SEK.getName());
	}
	
	@Test
	public void testGetRate() {
		assertEquals((Double).15,SEK.getRate());
	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(.17);
		assertEquals((Double).17,SEK.getRate());
	}
	
	@Test
	public void testGlobalValue() {
		assertEquals((Integer)15,SEK.universalValue(100));
	}
	
	@Test
	public void testValueInThisCurrency() {
		assertEquals((Integer)10,SEK.valueInThisCurrency(100, EUR));
	}

}
