package drift;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class HowdyIO {

	private static final String howdy = "Howdy, rowdy!";
	private static final String novaLine = "\r\n";
	//Windows requires the use of "\r\n" for a new line.
	
	public static void main(String[] args){
		System.out.println("File path?");
		// E:/ASTRA/StMU/BombOmb/src/drift/text
		Scanner scan = new Scanner(System.in);
		String path = scan.nextLine();
		System.out.println("n? (Repition amount of howdy string.)");
		int count = scan.nextInt();
		
		try{
			//Argument MUST include path to the text file.
			File statText = new File(path);
			FileOutputStream os = new FileOutputStream(statText);
			OutputStreamWriter osw = new OutputStreamWriter(os);    
			Writer w = new BufferedWriter(osw);
			for(int j = 0; j < count; j++){
				w.write(howdy);
				if(j < (count -1)){
					w.write(novaLine);
				}
			}
			
			w.close();
		} catch (IOException e) {
			System.err.println("Problem writing to the file statsTest.txt");
		}
	}
}
