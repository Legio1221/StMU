package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {	
		assertEquals("SweBank",SweBank.getName());
		System.out.println(SweBank.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK,SweBank.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		try{
			SweBank.openAccount("Johannes");
		} catch (AccountExistsException e){ //Didn't need ACDNEE
			System.out.println(e.getMessage());
		}
		assertEquals((Integer)0,SweBank.getBalance("Johannes"));
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		Money test = new Money(1000, SEK);
		try{
			SweBank.deposit("Bob", test);
		} catch ( AccountDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		assertEquals((Integer)1000,SweBank.getBalance("Bob"));
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		Money test = new Money(10000, SEK);
		try{
			SweBank.withdraw("Bob", test);
		}
		catch (AccountDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		Money test = new Money(20000,SEK);
		SweBank.deposit("Bob", test);
		assertEquals((Integer)20000,SweBank.getBalance("Bob"));
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		Money m = new Money(15000, SEK);
		Money m2 = new Money(35000, SEK);
		try {
			SweBank.transfer("Bob", "Ulrika", m);
			DanskeBank.transfer("Gertrud", Nordea, "Bob", m2);
		}
		catch (AccountDoesNotExistException e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		Money test = new Money(22222,SEK);
		try{
		SweBank.addTimedPayment("Bob", "while", 3, 24, test, SweBank, "Ulrika");
		}
		catch ( AccountDoesNotExist e ){
			System.out.println(e.getMessage());
		}
		
		assertEquals((Integer)22222,SweBank.getBalance("Ulrika"));
	}
	
}
