import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Expenditures {

	float input = 1;
	
	public void getInput() throws IOException {
		
		Scanner tastatur = new Scanner(System.in);
        FileWriter editor = new FileWriter("Ausgaben.txt", true);
    	
		System.out.println("a) Ausgaben eintragen:");
		while(input != 0) {  			
			System.out.println("Betrag:");   			
            input = tastatur.nextFloat();
            editor.write(input +"");
            
            
            // Date is added

            Date quarter = java.util.Calendar.getInstance().getTime();
            SimpleDateFormat quarterFormatter = new SimpleDateFormat("dd");
            
            String quarterString = quarterFormatter.format(quarter);
            Files.write(Paths.get("Datum.txt"), Arrays.asList(quarterString), StandardOpenOption.APPEND);
	        
            
            // Choose category
            
            if(input != 0) {
            System.out.println("Kategorie: \na) Essen    b) Technik   c) Sonstiges");

            
            String kategorie = tastatur.next();
            
            if(kategorie.contentEquals("a")){
            	editor.write(" - Essen\n");
            } else if(kategorie.contentEquals("b")) {
            	editor.write(" - Technik\n");
            } else if(kategorie.contentEquals("c")) {
            	editor.write(" - Sonstiges\n");
            }
            }
            
		}
		tastatur.close();
		editor.close();

	}

}
