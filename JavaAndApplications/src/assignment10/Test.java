package assignment10;

import java.io.*;
import java.util.*;

public class Test {
	
	public static void main(String[] args){
		//E/JavaFiles
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter file location.");
		String s = keyboard.next();
		
		
		try{
		FileLogic file = new FileLogic(s);
		file.WriteFile();
		System.out.println(file.getAverage());
		}
		catch(FileNotFoundException  e){
			System.out.println("File not found!");
		}
		
		keyboard.close();
	}

}
