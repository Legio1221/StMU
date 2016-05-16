package assignment4;
import java.util.Date;

public class Account {

	int id;
	double balance;
	double annualInterestRate;
	Date dateCreated;
	
	Account(){
	}
	
	Account(int newId, double newBalance, double newAnnualInterestRate, Date newDateCreated){
		id = newId;
		balance = newBalance;
		annualInterestRate = newAnnualInterestRate;
		dateCreated = newDateCreated;
	}
	
	void setId(int i){
		id = i;
	}
	
	void setBalance(double b){
		balance = b;
	}
	
	void setAnnualInterestRate(double a){
		annualInterestRate = a;
	}
	
	int getId(){
		return id;
	}
	
	double getBalance(){
		return balance;
	}

	double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
	Date getDateCreated(){
		Date dateCreated = new Date();
		return dateCreated;
	}
	
	double getMonthlyInterest(){
		return annualInterestRate/12;
	}
	
	double withdraw(double w){
		return balance - w;
	}
	
	double deposit(double d){
		return balance + d;
	}
}
