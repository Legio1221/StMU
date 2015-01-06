package pseudoLedger;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import pseudoExceptions.IllegalAmountException;
import pseudoExceptions.IllegalCoaException;
import pseudoExceptions.IllegalDateException;
import pseudoExceptions.IllegalDescriptionException;

public class CheckRegisterTest {
	
	int docNum, coa, bankCoa;
	double amount;
	char[] description;
	Date checkDate;
	
	@Before
	public void setUp() throws Exception {
			/*
			 * Check 8776
			 * 12/31/14
			 * $220.39
			 * Sprint PCS
			 * 6900102
			 * 1100120
			 */
		
		checkDate = new Date(122);
		checkDate = Date.valueOf("2014-12-31");
		description = new char[] {'S','p', 'r', 'i', 'n', 't', ' ', 'P', 'C', 'S'};
		
	}

	@Test
	public void addCheckTest() {
		CheckRegister ckRegister = new CheckRegister();
		try {
			ckRegister.addCheck(checkDate, 6900102, 220.39, 1100120, description);
		} catch (IllegalAmountException | IllegalCoaException
				| IllegalDescriptionException | IllegalDateException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		String str;
		str = "Check details\nDate:2014-12-31\nChart of Account: 6900102\nAmount: 220.39\nBank CoA 1100120\nDescription: Sprint PCS";
		assertEquals(str, ckRegister.getCheckList().get(0).toString());
	}

}
