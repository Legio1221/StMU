package general_Ledger;

import genLedgerExceptions.NegativeAmountException;

import java.util.ArrayList;
import java.util.Date;
/*//---------------------------------------------------------------------------------------
// Check Ledger is for inputting checks into database. For now, I'll use an array list.  |
// As of now, I'll be using a bank reference number to differentiate between bank        |
// accounts. Eventually there'll be some GUI implementation of sorts to ease the work    |
// flow between bank accounts. Should come in handy for companies that work with 2-3 or  |
// checking/saving/etc. accounts.                                                        |
// -Legio1221                                                                            |
//---------------------------------------------------------------------------------------*/
public class CheckLedger {
	
	private int coaNum, bankNum;
	ArrayList<Check> checkList;
	Accountant accountant;
	Company company;
	Employee emp;
	/* * * * * * * * * * * * * * * * * * * * * * *
	 * The previous fields are the input fields. *
	 * Date - self explanatory                   *
	 * coaNum - Chart of Account Number          *
	 * docNum - Document Code/Number             *
	 * bankNum - Bank Reference Number           *
	 * checkAmount - Net Amount of Check         *
	 *                                           *
	 *  Assumptions:                             *
	 *  User has access to all of the above.     *
	 *  BankNum is already in COA database.      *
	 *  COA database is established.             *
	 *  Company 'X' has been established.        *
	 * * * * * * * * * * * * * * * * * * * * * * */
	
	public int getCoaNum() {
		return coaNum;
	}

	public void setCoaNum(int coaNum) {
		this.coaNum = coaNum;
	}

	public int getBankNum() {
		return bankNum;
	}

	public void setBankNum(int bankNum) {
		this.bankNum = bankNum;
	}

	public ArrayList<Check> getCheckList() {
		return checkList;
	}

	public void setCheckList(ArrayList<Check> checkList) {
		this.checkList = checkList;
	}

	public Accountant getAccountant() {
		return accountant;
	}

	public void setAccountant(Accountant accountant) {
		this.accountant = accountant;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public void inputCheck(int docNum, int amount, String payableTo, Date date){
		Check ck = null;
		try {
			ck = new Check(docNum, amount, payableTo, date);
		} catch (NegativeAmountException e) {
			e.getMessage();
		}
		//User will supply Company and accountant
		checkList.add(ck);
		coaNum = 500110;
		company = new Company();
		accountant = new Accountant();
	}
	
	private class Check{
		//Need to find out how to properly set dates.
		private int docNum, amount;
		private String payableTo;
		private Date date;
		
		public Check(int docNum, int amount, String payableTo, Date date) throws NegativeAmountException{
			if(amount <= 0){
				throw new NegativeAmountException(amount);
			}
			this.docNum = docNum;
			this.amount = amount;
			this.payableTo = payableTo;
			this.date = date;
		}
		
		public int getDocNum() {
			return docNum;
		}
		public void setDocNum(int docNum) {
			this.docNum = docNum;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			amount = amount;
		}
		public String getPayableTo() {
			return payableTo;
		}
		public void setPayableTo(String payableTo) {
			this.payableTo = payableTo;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		
		
		
	}
	
}
