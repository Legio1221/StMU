package w2FormatEditor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class EditorLogic {

	private int companyNum;
	private int programNum;
	private int programFormatNum;
	private int destinyCompanyNum;
	
	final private String W2_2015 = "W2 2015";
	final private String novaLine = "\r\n";
	final private String Y = "Y";
	
	public EditorLogic(int companyNum, int programNum, int programFormatNum, int destinyCompanyNum){
		this.companyNum = companyNum;
		this.programNum = programNum;
		this.programFormatNum = programFormatNum;
		this.destinyCompanyNum = destinyCompanyNum;
		
	}
	public void fileLogic(){
		try{
			//Whatever the file path is.
			File statText = new File("C:/Users/miriam/Desktop/statsTest.txt");
			FileOutputStream is = new FileOutputStream(statText);
			OutputStreamWriter osw = new OutputStreamWriter(is);    
			Writer w = new BufferedWriter(osw);
			w.write(writeW2Format());
			
			w.close();
		} catch (IOException e) {
			System.err.println("Problem writing to the file statsTest.txt");
		}
	}
	
	public String writeW2Format(){
		String str = 
				"G" + novaLine 
				+ "SA11" + novaLine
				+ "C" + novaLine
				+ "PR" + novaLine
				+ companyNum 
				+ novaLine + programNum + novaLine 
				+ programFormatNum + novaLine 
				+ destinyCompanyNum + novaLine
				+ W2_2015 + novaLine + novaLine;
		
		return str;
	}
	
	public String go2PR(){
		String str = 
				"G" + novaLine
				+ "PR" + novaLine;
		return str;
	}
	
	public String inputPRCheck(int date, int empNum, int checkNum){
		String str = 
				"G" +  "14" + novaLine
				+ novaLine + date
				+ empNum + novaLine + novaLine + Y + novaLine
				+ checkNum + novaLine + novaLine;
		return str;
	}
}
