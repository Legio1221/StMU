package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeTest {

	@Test
	public void testIsPrime() {
		assertTrue(Prime.isPrime(7));
		assertTrue(Prime.isPrime(67));
		assertTrue(Prime.isPrime(167));
		assertTrue(Prime.isPrime(521));
		assertTrue(Prime.isPrime(1601));
		assertTrue(Prime.isPrime(2));
		assertTrue(Prime.isPrime(3));
		
		
		assertFalse(Prime.isPrime(10));
		assertFalse(Prime.isPrime(254));
		assertFalse(Prime.isPrime(660));
	}
	
	@Test
	public void testIsMersennePrime(){
		assertTrue(Prime.isMersennePrime(3));
		assertTrue(Prime.isMersennePrime(7));
		assertTrue(Prime.isMersennePrime(31));
		assertTrue(Prime.isMersennePrime(127));
		assertTrue(Prime.isMersennePrime(8191));
		assertTrue(Prime.isMersennePrime(131071));
		
		assertFalse(Prime.isMersennePrime(100));
		assertFalse(Prime.isMersennePrime(880));
		assertFalse(Prime.isMersennePrime(444));
	}

}
