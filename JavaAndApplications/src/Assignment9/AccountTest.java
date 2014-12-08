package Assignment9;

/**
This program demonstrates how the BankAccount
class constructor throws custom exceptions.
*/

public class AccountTest
{
public static void main(String [] args)
{
   // Force a NegativeStartingBalance exception.
   try
   {
      BankAccount account =
                  new BankAccount(-100.0,5.4);
   }
   catch(NegativeStartingBalance | NegativeInterestRate e)
   {
      System.out.println(e.getMessage());
   }
   
   try
   {
      BankAccount account2 =
                  new BankAccount(100.0,-4.4);
   }
   catch(NegativeStartingBalance | NegativeInterestRate e)
   {
      System.out.println(e.getMessage());
   }
   
}
}