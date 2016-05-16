package assignment10;

import java.io.*;
import java.util.*;

public class FileLogic {

	File f;

	FileLogic(String s) throws FileNotFoundException{
		f = new File(s);
	}

	public void ReadFile() throws FileNotFoundException{
		
		Scanner s = new Scanner(f);
		
			while(s.hasNext()){
				String p = s.next();
				System.out.println(p);
			}
			s.close();
	}
	
	public void WriteFile() throws FileNotFoundException{
		
	
		PrintWriter output = new PrintWriter(f);
		Scanner keyboard = new Scanner(System.in);
		
		int num = 0;
		
		System.out.println("Enter any set of numbers. Enter -1 to escape.");
		
		while(num != -1){
			num = keyboard.nextInt();
			if(num != -1){
			output.println(num);
			}
		}
		
		output.close();
		keyboard.close();
	}
	
	public double getAverage() throws FileNotFoundException{
		ArrayList list = new ArrayList();
		Scanner s = new Scanner(f);
		double sum = 0;
		double avg;
		
		while(s.hasNext()){
			String p = s.next();
			list.add(Integer.parseInt(p));
		}
		s.close();
		
		for(int i = 0; i < list.size();i++){
			sum+=(int)list.get(i);
		}
		
		avg = sum / list.size();
		return avg;
	}
}
