package general_Ledger;
//---------------------------------------------------------------------------------------
// Check Ledger is for inputting checks into database. For now, I'll use an array list.  |
// As of now, I'll be using a bank reference number to differentiate between bank        |
// accounts. Eventually there'll be some GUI implementation of sorts to ease the work    |
// flow between bank accounts. Should come in handy for companies that work with 2-3 or  |
// checking/saving/etc. accounts.                                                        |
// -Legio1221
//---------------------------------------------------------------------------------------
public class CheckLedger {
	
	int checkNum, date, coaNum, docNum, bankNum, checkAmount;
	/* 
	 * The previous fields are the input fields. 
	 * checkNum - Check Number
	 * Date - self explanatory
	 * coaNum - Chart of Account Number
	 * docNum - Document Code/Number
	 * bankNum - Bank Reference Number
	 * checkAmount - Net Amount of Check
	 * 
	 *  Assumptions:
	 *  User has access to all of the above. 
	 *  BankNum is already in COA database.
	 *  COA database is established.
	 *  Company 'X' has been established.
	 *  
	 * 
	 * */
	 
}
