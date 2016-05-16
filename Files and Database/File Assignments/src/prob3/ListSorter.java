package prob3;
/*
 * Oscar Guillermo Castro
 * Files & Databases
 * Assignment 5
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ListSorter {
	ArrayList<Transaction> arrayMajoris;
	int pages;
	
	public ListSorter(){
		arrayMajoris = new ArrayList<Transaction>();
		pages = 0;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub
		
		ListSorter sort = new ListSorter(); //Create instance of object.
		
		sort.readRecords(); //Read records
		
		//Begin Sorting Logic
		ArrayList<Transaction> store100 = new ArrayList<Transaction>();
		ArrayList<Transaction> store200 = new ArrayList<Transaction>();
		ArrayList<Transaction> store300 = new ArrayList<Transaction>();
		ArrayList<Transaction> store400 = new ArrayList<Transaction>();
		ArrayList<Transaction> store500 = new ArrayList<Transaction>();
		
		for(int i = 0; i < sort.arrayMajoris.size(); i++){
			switch(sort.arrayMajoris.get(i).getStore()){
			case 100: store100.add(sort.arrayMajoris.get(i));
					  	break;
			case 200: store200.add(sort.arrayMajoris.get(i));
						break;
			case 300: store300.add(sort.arrayMajoris.get(i));
						break;
			case 400: store400.add(sort.arrayMajoris.get(i));
						break;
			case 500: store500.add(sort.arrayMajoris.get(i));
						break;
			default: System.out.println("Some error occured where Array Majoris could not store / load / retreive information");
			}
		}
		//Theoretically each store "should" have its transactions.
		//Begin sorting each store's transactions.
		
		bubbleSort(store100);
		bubbleSort(store200);
		bubbleSort(store300);
		bubbleSort(store400);
		bubbleSort(store500);
		//Finish sorting each store by its store number.
		//Begin to print each array. 
		
		String filePath = "E:/Problem5.list";
		try{
			File list = new File(filePath);
			FileOutputStream OS = new FileOutputStream(list);
			OutputStreamWriter OSW = new OutputStreamWriter(OS);
			Writer w = new BufferedWriter(OSW);
			
			sort.printTopHeader(w, store100, sort);
			sort.printRecord(w, store100, sort);
			sort.printTotals(w, store100);
			
			sort.printTopHeader(w, store200, sort);
			sort.printRecord(w, store200, sort);
			sort.printTotals(w, store200);
			
			sort.printTopHeader(w, store300, sort);
			sort.printRecord(w, store300, sort);
			sort.printTotals(w, store300);
			
			sort.printTopHeader(w, store400, sort);
			sort.printRecord(w, store400, sort);
			sort.printTotals(w, store400);
			
			sort.printTopHeader(w, store500, sort);
			sort.printRecord(w, store500, sort);
			sort.printTotals(w, store500);
			
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error occured trying to write information to file!");
		}
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------//
	//-----------------------------------------------------------------------------------------------------------------------------------------------//
	//-----------------------------------------------------------------------------------------------------------------------------------------------//
	//This bubble sort concept has been obtained from http://www.java2novice.com/java-sorting-algorithms/bubble-sort/
	public static void bubbleSort(ArrayList<Transaction> transList){
		int n = transList.size();
		int k;
		for(int m = n; m >= 0; m--){
			for(int i = 0; i < n - 1; i++){
				k = i + 1;
				if(transList.get(i).getNumber() > transList.get(k).getNumber()){
					swapNumbers(i,k,transList);
				}
			}
		}
	}
	
	public static void swapNumbers(int i, int j, ArrayList<Transaction> transList){
		int temp;
		temp = transList.get(i).getNumber();
		transList.get(i).setNumber(transList.get(j).getNumber());
		transList.get(j).setNumber(temp);
		//transList.get(i).number = transList.get(j).number;
		//transList.get(j).number = temp;
	}
	
	public void printTopHeader(Writer w, ArrayList<Transaction> transList, ListSorter sort){
		int mm = Calendar.MONTH;
		int dd = Calendar.DAY_OF_MONTH;
		int yyyy = Calendar.YEAR + 1900;
		String str1 = "Problem5 " + mm + "/" + dd + "/" + yyyy + "                                    " + "Page " + sort.pages;
		String novaLine = "\r\n"; //Windows requires the '\r' to place a new line.
		String str2 = "   #  Store  Dept  Date        Part Name   Code          Amount";
		String str3 = "----  -----  ----  ----------  ----------  ----  --------------";
		try {
			w.write(str1);
			w.write(novaLine);
			w.write(str2);
			w.write(novaLine);
			w.write(str3);
			w.write(novaLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("An error occured trying to print the top header");
		}
	}
	
	public void printRecord(Writer w, ArrayList<Transaction> transList, ListSorter sort){
		int lines = 0;
		for(int i = 0; i<transList.size();i++){
			if( lines > 50 ){
				sort.pages++;
				printTopHeader(w, transList, sort);
			}
			String str1 = transList.get(i).getNumber() + "    " + transList.get(i).getStore() + "    " + transList.get(i).getDept() + "  " + transList.get(i).getMm() + "/" + 
			transList.get(i).getDd() + "/" + transList.get(i).getYyyy() + "  " + transList.get(i).getPartNum() + "     " + transList.get(i).getCode() + "       " + "$" + 
			transList.get(i).amount + "\r\n";
			
			try {
				w.write(str1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error occured trying to write record to file!");
			}
		}
	}
	
	public void readRecords(){
		
		String filePath = "E:/Transactions.text";

		try {
			FileReader IN = new FileReader(filePath);
			BufferedReader bufferReader = new BufferedReader(IN);
			String line;
			
			//While loop is used to read lines of the 'database' and convert them into something Java can use.
			while ((line = bufferReader.readLine()) != null) {
				// The following obtains the data from the list.
				char[] num = { line.charAt(0), line.charAt(1), line.charAt(2),
						line.charAt(3) };
				String num2 = String.copyValueOf(num);
				int number = Integer.parseInt(num2);

				char[] stor = { line.charAt(4), line.charAt(5), line.charAt(6) };
				String stor2 = String.copyValueOf(stor);
				int store = Integer.parseInt(stor2);

				char[] dep = { line.charAt(7), line.charAt(8) };
				String dep2 = String.copyValueOf(dep);
				int dept = Integer.parseInt(dep2);

				char[] m = { line.charAt(9), line.charAt(10) };
				String m2 = String.copyValueOf(m);
				int mm = Integer.parseInt(m2);

				char[] d = { line.charAt(11), line.charAt(12) };
				String d2 = String.copyValueOf(d);
				int dd = Integer.parseInt(d2);

				char[] yy = { line.charAt(13), line.charAt(14),
						line.charAt(15), line.charAt(16) };
				String yy2 = String.copyValueOf(yy);
				int yyyy = Integer.parseInt(yy2);

				char[] part = { line.charAt(17), line.charAt(18),
						line.charAt(19), line.charAt(20), line.charAt(21),
						line.charAt(22), line.charAt(23), line.charAt(24),
						line.charAt(25), line.charAt(26) };
				String partNum = String.copyValueOf(part);

				char[] cod = { line.charAt(27) };
				String cod2 = String.copyValueOf(cod);
				int code = Integer.parseInt(cod2);

				char[] amoun = { line.charAt(28), line.charAt(29),
						line.charAt(30), line.charAt(31), line.charAt(32),
						line.charAt(33), line.charAt(34) };
				String amoun2 = String.copyValueOf(amoun);
				double amount = Double.parseDouble(amoun2);	
				
				Transaction trans = new Transaction( number,  store,  dept,  mm,  dd,  yyyy, partNum,  code,  amount);
				
				arrayMajoris.add(trans);
			}
			
			bufferReader.close();
			
		} catch(Exception e){
	          System.out.println("Error while reading file line by line:" + e.getMessage());                      
	    }
		
		
	}
	
	public static double getTotalTransactionAmount(ArrayList<Transaction> transList){
		double amount = 0;
		for(int i = 0; i<transList.size();i++){
			amount += transList.get(i).getAmount();
		}
		return amount;
	}
	
	public void printTotals(Writer w, ArrayList<Transaction> transList){
		String str1 = "                                                 ==============";
		String novaLine = "\r\n";
		String str2 = "                        " + transList.size() + "Total Store                $" + getTotalTransactionAmount(transList) + "\r\n";
		try {
			w.write(str1);
			w.write(novaLine);
			w.write(str2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error detected in printing totals!");
			e.printStackTrace();
		}
	}
	 
}
