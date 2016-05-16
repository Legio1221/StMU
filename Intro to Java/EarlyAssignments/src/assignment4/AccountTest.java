package assignment4;

public class AccountTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account a = new Account(1122, 20000.00 , .045, null);
		
		a.setId(a.id);
		a.setAnnualInterestRate(a.annualInterestRate);
		a.setBalance(a.balance);
		System.out.println("The Account "+a.getId()+" has a balance of " + (a.balance - a.withdraw(2500.00)+a.deposit(3000.00)));
		System.out.println("The monthly interest is " + a.getMonthlyInterest());
		System.out.println("The account was created " + a.getDateCreated());
		
		
	}

}