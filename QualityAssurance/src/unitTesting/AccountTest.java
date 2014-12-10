package unitTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	
	Account acc;
	
	@Before
	public void setUp()throws Exception{
		acc = new Account(572389,10000.00,1.75);
	}

	@Test
	public void accountTest(){
		assertEquals(572389,acc.getId());
		assertEquals(10000.00,acc.getBalance(),.001);
		assertEquals(1.75,acc.getAnnualInterestRate(),.001);
	}

	@Test
	public void getMonthlyInterestRateTest(){
		assertEquals(.1458,acc.getMonthlyInterest(),0001);
	}
	
	@Test
	public void withdrawTest(){
		acc.withdraw(965.17);
		assertEquals(9034.83,acc.getBalance(),.01);
	}
	
	@Test
	public void depositTest(){
		acc.deposit(734.57);
		assertEquals(10734.57,acc.getBalance(),.01);
	}
}
