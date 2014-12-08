package notes;
import java.io.*;
import java.util.*;

public class FileWriting {
	public static void main(String[] args) throws FileNotFoundException{
PrintWriter outputFile = new PrintWriter("E:\\text2.txt");

outputFile.println("Texas");
outputFile.close();
File myFile = new File("E:\\text2.txt");
Scanner inputFile = new Scanner(myFile);
String str = inputFile.nextLine();
inputFile.close();
	}
}
