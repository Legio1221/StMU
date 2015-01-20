package prob2;

import java.io.*;
import java.util.ArrayList;

public class TimeFormater {
	
	public static void main(String[] args){
		
		ArrayList<String> novaFormate = new ArrayList<String>();
		
		 String filePath="E:/ASTRA/StMU/BombOmb/src/prob2/CopyProblem2.data";
	     //Name of the file
	      
	       try{

	          FileReader in = new FileReader(filePath);
	          // E:/ASTRA/StMU/BombOmb/src/prob2/CopyProblem2.data
	          
	          BufferedReader bufferReader = new BufferedReader(in);
	          String line;
	          
	          while((line = bufferReader.readLine()) != null){
	        	 char[] hh = {line.charAt(0), line.charAt(1)};
	        	 String hour = String.copyValueOf(hh);
	        	//Get the first set of hours.
	        	 
	        	 char[] mm = {line.charAt(3), line.charAt(4)};
	        	 String minute = String.copyValueOf(mm);
	        	//Get the first set of minutes.
	        	 
	        	 String antePost = null;
	        	 //Get the first am or pm.
	        	 if(line.charAt(5) == 'A'){
	        		 antePost = "AM";
	        	 } else if(line.charAt(5) == 'P'){
	        		 antePost = "PM";
	        	 } else {
	        		System.err.println("Error! A or P not detected.");
	        	 }
	        	 
	        	 char[] hh2 = {line.charAt(6), line.charAt(7)};
	        	 String hour2 = String.copyValueOf(hh2);
	        	 //Get the second set of hours.
	        	 
	        	 char[] mm2 = {line.charAt(9), line.charAt(10)};
	        	 String minute2 = String.copyValueOf(mm2);
	        	 //Get the second set of minutes.
	        	 
	        	 //Get the second set of AM or PM
	        	 String antePost2 = null;
	        	 if(line.charAt(11) == 'A'){
	        		 antePost2 = "AM";
	        	 } else if(line.charAt(11) == 'P'){
	        		 antePost2 = "PM";
	        	 } else {
	        		System.err.println("Error! A or P not detected.");
	        	 }
	        	 
	        	 String str = hour + ":" + minute + antePost + "-" + hour2 + ":" + minute2 + antePost2;
	        	novaFormate.add(str);
	          }
	         
	          bufferReader.close();
	       }catch(Exception e){
	          System.out.println("Error while reading file line by line:" + e.getMessage());                      
	       }
	       
	       try{
				//Argument MUST include path to the text file.
	    	    filePath = "E:/ASTRA/StMU/BombOmb/src/prob2/dataTest.data";
				File statText = new File(filePath);
				FileOutputStream os = new FileOutputStream(statText);
				OutputStreamWriter osw = new OutputStreamWriter(os);    
				Writer w = new BufferedWriter(osw);
				
				for(int i = 0; i < novaFormate.size(); i++){
					w.write(novaFormate.get(i));
					if( i < novaFormate.size() - 1)
					w.write("\r\n");
					// backslash 'r' and backslash 'n' are needed for new line in Windows.
				}
				w.close();
			} catch (IOException e) {
				System.err.println("Problem writing to the file problem2.data");
			}
	}
}
