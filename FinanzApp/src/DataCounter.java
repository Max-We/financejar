import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DataCounter {

	public float countExpenses() throws FileNotFoundException {
		File Expenses = new File("Ausgaben.txt");
		Scanner sc = new Scanner(Expenses).useLocale(Locale.US);

		float sum = 0;		
		int zähler = -1;
		
		while(sc.hasNext()) {
			
			zähler ++;
			if (zähler % 2 == 0) {
				sum = sum + sc.nextFloat();
			} else {
				sc.next();
			}
		}
		sc.close();
		return sum;
	}
	
	public float countRevenues() throws FileNotFoundException {
		File Revenues = new File("Einnahmen.txt");
        Scanner revenueScanner = new Scanner(Revenues).useLocale(Locale.US);
        
        float Sum = 0;
        while(revenueScanner.hasNextFloat()) {
        Sum += revenueScanner.nextFloat();
        }
        revenueScanner.close();
        return Sum;
	}

}
