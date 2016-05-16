package test1;
import java.util.Scanner;

public class TestEmployee {
	private static Scanner keyboard;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		keyboard = new Scanner(System.in);
		
		 int id1;
		 String name1;
		 int id2;
		 String name2;
		 String choose;
		 
		 System.out.println("Please enter employee id");
		 id1 = keyboard.nextInt();
		 System.out.println(id1);
		 keyboard.nextLine();
		 
		 System.out.println("Please enter employee name");
		 name1 = keyboard.nextLine();
		 System.out.println(name1);
		 
		 Employee one = new Employee(id1, name1);
		 
		 System.out.println("Please enter employee id");
		 id2 = keyboard.nextInt();
		 System.out.println(id2);
		 keyboard.nextLine();
		 
		 System.out.println("Please enter employee name");
		 name2 = keyboard.nextLine();
		 System.out.println(name2);
		 Employee two = new Employee(id2, name2);
		 
		 System.out.println("First employee's name and id is "+name1+" and "+id1);
		 System.out.println("Second employee's name and id is "+name2+" and " +id2);
		 
		 System.out.println("Which Employee's id would you like to change?");
		
		 choose = keyboard.nextLine();
		 
		 one.setChoice(choose);
		 two.setChoice(choose);
		 
		 System.out.println("After id change, this is the new information.");
		 System.out.println("First employee's name is "+one.getName()+" and id is "+one.getId());
		 System.out.println("Second employee's name is "+two.getName()+" and id is "+two.getId());
	}

}
