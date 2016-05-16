package assignment2;

import java.util.*;

public class TestEssay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		double input;
		
		Essay e = new Essay();
		
		System.out.println("Please enter the amount of points from the grammar section." +
		 " A maximum of 25 points may be entered");
		input = keyboard.nextDouble();
		if(input < 0 || input > 25){
			System.out.println("A number below 0 or above 25 has been entered." + 
		" A default value of 0 has been entered.");
		}else{
			e.setGrammar(input);
		}
			
		System.out.println("Please enter the amount of points from the spelling section." + 
		"A maximum of 35 points may be entered.");
		input = keyboard.nextDouble();
		if(input < 0 || input > 35){
			System.out.println("A number below 0 or above 35 has been entered." + 
		" A default value of 0 has been entered.");
		}else{
			e.setSpelling(input);
		}
		
		System.out.println("Please enter the amount of points from the content section." + 
		"A maximum of 40 points may be entered");
		input = keyboard.nextDouble();
		if(input < 0 || input > 40){
			System.out.println("A number below 0 or above 40 has been entered." + 
		"A default value of 0 has been entered.");
		}else{
			e.setContent(input);
		}
		
		System.out.println("The amount of points for the grammar section is: " + e.getGrammar());
		System.out.println("The amount of points for the spelling section is: " + e.getSpelling());
		System.out.println("The amount of points for the content section is: " + e.getContent());
		e.setEssay();
		System.out.println("The total amount of points is: " + e.getScore());
		System.out.println("The letter grade is: " + e.getGrade());
	}

}
