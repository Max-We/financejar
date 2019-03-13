import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Report {

	// To get the data of the expenses / revenues using the DataCounter class (provides Sum of both)
	DataCounter ExpensesRevenues = new DataCounter();
	float expensesA;
	float revenuesA;
	
	public void compareFinances() throws FileNotFoundException {
		
		expensesA = ExpensesRevenues.countExpenses();
		revenuesA = ExpensesRevenues.countRevenues();
		if(revenuesA > expensesA) {
        	System.out.println("> You have " + (revenuesA - expensesA) + "€ remaining this month.\n");
        }
        else if(expensesA > revenuesA) {
        	System.out.println("> You have spent " + (expensesA - revenuesA) + "€ too much this month.\n");
        }
        else {
        	System.out.println("> You haven't spent or earned any money yet.\n");
        }
	}
	
	public void viewStats() throws FileNotFoundException {
		expensesA = ExpensesRevenues.countExpenses();
		revenuesA = ExpensesRevenues.countRevenues();
		
        System.out.println("Expenditures:  +" + expensesA + "€");
        System.out.println("Revenues:   -" + revenuesA + "€");
	}
	
	public void listQuarters() throws FileNotFoundException {
        File Dates = new File("Datum.txt");
        File Expenditures = new File("Ausgaben.txt");
        
		Scanner expenditureScanner = new Scanner(Expenditures).useLocale(Locale.US);
		Scanner dateScanner = new Scanner(Dates).useLocale(Locale.US);
		
		float dateValue = 0;
		float expValue = 0;
		int counter = -1;
		
		// Values for the total of each quarter
		float q1 = 0;
		float q2 = 0;
		float q3 = 0;
		float q4 = 0;
		
		// Runs through all expenses and lists them in order based on their linked date in the date txt file
		// Q1: 0-7   Q2: 8-17   Q3: 18-23   Q4: 24-31
		// Then it prints the Sum of all the expenses in one quarter
		System.out.println("[Expenditures Q1]");
		while(dateValue < 8 && dateScanner.hasNextFloat()) {
			counter ++;
			
			if (counter % 2 == 0) {
			dateValue = dateScanner.nextFloat();
			expValue = expenditureScanner.nextFloat();
			
			q1 += expValue;
			if(expValue != 0) {
			System.out.println(expValue);
			}
			} else {
				expenditureScanner.next();
			}
		}
		System.out.println(">Total:: " + q1 + "€");
		
		if(dateValue > 7) {
		System.out.println("\n[Expenditures Q2]");
		while(dateValue > 7 && dateValue < 18 && dateScanner.hasNextFloat()) {
			counter ++;
			
			if (counter % 2 == 0) {
			dateValue = dateScanner.nextFloat();
			expValue = expenditureScanner.nextFloat();
			
			q2 += expValue;
			if(expValue != 0) {
			System.out.println(expValue);
			}
			} else {
				expenditureScanner.next();
			}
		}
		System.out.println(">Total:: " + q2 + "€");
		} else if (dateValue > 17) {
		System.out.println("\n[Expenditures Q3]");
		while(dateValue > 17 && dateValue < 24 && dateScanner.hasNextFloat()) {
			counter ++;
			
			if (counter % 2 == 0) {
			dateValue = dateScanner.nextFloat();
			expValue = expenditureScanner.nextFloat();
			
			q3 += expValue;
			if(expValue != 0) {
			System.out.println(expValue);
			}
			} else {
				expenditureScanner.hasNext();
			}
		}   
		System.out.println(">Total:: " + q3 + "€");
		} else if (dateValue > 23) {
		System.out.println("\n[Expenditures Q4]");
		while(dateValue > 23 && dateValue < 32 && dateScanner.hasNextFloat()) {
			counter ++;
			
			if (counter % 2 == 0) {
			dateValue = dateScanner.nextFloat();
			expValue = expenditureScanner.nextFloat();
			q4 += expValue;
			if(expValue != 0) {
			System.out.println(expValue);
			}
			} else {
				expenditureScanner.next();
			}
		}       
		System.out.println(">Total:: " + q4 + "€");
		}
		expenditureScanner.close();
		dateScanner.close();
	}
	
}
