import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Revenues {

	float input = 1;
	public void getInput() throws IOException {
		Scanner keyboard = new Scanner(System.in);
		FileWriter editorRevenues = new FileWriter("Einnahmen.txt", true);
		
		System.out.println("b) Einnahmen eintragen:");
		while(input != 0) {
    	input = keyboard.nextFloat();
    	editorRevenues.write(input + "\n");
    	}
		editorRevenues.close();
		keyboard.close();
	}
}
