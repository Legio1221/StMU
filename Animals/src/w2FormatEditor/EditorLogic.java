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
	private String companyName;
	final private String W2_2015 = "W2 2015";
	
	public EditorLogic(int companyNum, int programNum, int programFormatNum, String companyName){
		this.companyNum = companyNum;
		this.programNum = programNum;
		this.programFormatNum = programFormatNum;
		this.companyName = companyName;
		
	}
	
	public String writeW2Format(){
		String str = "G\nSA11\nC\nPR\n" + companyNum + 
				"\n" + programNum + "\n" 
				+ programFormatNum + "\n" 
				+ companyName + "\n"
				+ W2_2015 + "\n" 
				+ "\n";
		
		return str;
	}
}
