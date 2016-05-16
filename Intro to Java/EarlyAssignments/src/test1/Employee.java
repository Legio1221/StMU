package test1;

import java.util.Scanner;

public class Employee {
	Scanner keyboard = new Scanner(System.in);

	private int id;
	private String name;

	Employee(int i, String n) {
		id/*Original Variable*/ = i;/*Variable within Scope*/
		name = n;
	}

	public void setId(int i) {
		id = i;
	}

	public void setName(String n) {
		name = n;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setChoice(String s) {
		if (name.equals(s) == true) {
			int i;
			System.out.println("Enter new Id.");
			i = keyboard.nextInt();
			setId(i);
		}
	}
}
