package pseudoLedger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CheckFileLogic {
	public CheckFileLogic(){
		try{
			//Whatever the file path is.
            File statText = new File("C:/Program Files/WorkSpaceZ/statsTest.txt");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            w.write("Shizukaaaa, Naoshi-saaaaan");
            w.write("Shitzu cuntaking");
            w.close();
		} catch (IOException e) {
			System.err.println("Problem writing to the file statsTest.txt");
		}
	}
}