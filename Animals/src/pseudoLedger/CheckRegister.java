package pseudoLedger;

import java.sql.Date;
import java.util.ArrayList;

import pseudoExceptions.*;

/*
 * ADV interpreter Check Register Logic. 
 * coded by yours truly,
 * Legio1221
 */

public class CheckRegister {
	ArrayList<Check> checkList = new ArrayList<Check>();
	
	public void addCheck(Date date, int coa, double amount, int bankCoa, char[] description) throws 
	IllegalAmountException, IllegalCoaException, IllegalDescriptionException, IllegalDateException {
		if(amount < 0)	{
			throw new IllegalAmountException(amount);
		}
		if(coa < 100000 || coa > 9999999)	{
			throw new IllegalCoaException(coa);
		}
		if(bankCoa < 100000 || bankCoa > 9999999){
			throw new IllegalCoaException(bankCoa);
		}
		if(description.length > 25){
			throw new IllegalDescriptionException(description);
		}
		Check ck = new Check(date, coa, amount, bankCoa, description);
		checkList.add(ck);
	}
	
	
	
	public ArrayList<Check> getCheckList() {
		return checkList;
	}



	public void setCheckList(ArrayList<Check> checkList) {
		this.checkList = checkList;
	}

	class Check {
		
		/*
		 * Date MMDDYYY
		 * CoA 7 Digits
		 * Amount 16-32 bit integer?
		 * Description 25 Characters
		 * Bank CoA 7 Digits
		 */
		
		private Date date;
		private int coa, bankCoa;
		double amount;
		private char[] description;
		
		
		
		public Date getDate() {
			return date;
		}



		public void setDate(Date date) {
			this.date = date;
		}



		public int getCoa() {
			return coa;
		}



		public void setCoa(int coa) {
			this.coa = coa;
		}



		public double getAmount() {
			return amount;
		}



		public void setAmount(double amount) {
			this.amount = amount;
		}



		public int getBankCoa() {
			return bankCoa;
		}



		public void setBankCoa(int bankCoa) {
			this.bankCoa = bankCoa;
		}



		public char[] getDescription() {
			return description;
		}



		public void setDescription(char[] description) {
			this.description = description;
		}



		public Check(Date date, int coa, double amount, int bankCoa, char[] description)	{ 
			this.date = date;
			this.coa = coa;
			this.amount = amount;
			this.bankCoa = bankCoa;
			this.description = description;
		}
		
		public String toString()	{
			String str;
			String str2;
			
			str2 = String.valueOf(description);
			str = "Check details\nDate:" + date.toString() + "\nChart of Account: " + coa + "\nAmount: " + amount + "\nBank CoA " + bankCoa +
					"\nDescription: " + str2;
			System.out.println(str);
			return str;
		}
		
		
	}
	
	
}
