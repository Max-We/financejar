import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		// Date Module
		
		Datum date = new Datum();
		System.out.println(date.dateValue());
		
		
				
		// Budget Module
		
		// Searching for budget value and prints it if available, if not it asks for input
		Budget budgetModule = new Budget();
		budgetModule.printBudget();
		
		// The budget value as a float alone:
		// float budgetFloat = budgetModul.budgetValue();
		
			
		
		// Main Menu
		System.out.println("Welcome, what do you want to do? \n a) Add Expenditures \n b) Add Revenues \n c) Read Report");
		
		Scanner keyboard = new Scanner(System.in);
		String mode = keyboard.nextLine();
		
		switch (mode) {
		
		// User gives input: Expenses
    	case "a":
    		Expenditures ExpenseModule = new Expenditures();
    		ExpenseModule.getInput();
	
    	// User gives input: Revenues
    	case "b":
    		Revenues RevenueModule = new Revenues();
    		RevenueModule.getInput();
    		
    	case "c":
    		// Prints Date and Sum of all Expenses and Revenues
    		System.out.println("\n\n[]============[Report]============[] \n ");
    		System.out.println(date.dateValue());
    		
		}
		
		// Reads Expenses and Revenues and creates the sum of all values (expensesA and revenuesA) (A for "All")
		Report reportModule = new Report();
		reportModule.viewStats();
		
		
		
		// Compares Expenses & Revenues and gives the user feedback - Prints result
		reportModule.compareFinances();
		
		// Checks if users budget has been exceeded - Prints result
		budgetModule.budgetReport();
            
		// Lists expenses based on date (Q1,2,3,4)
		reportModule.listQuarters();
    	
    	keyboard.close();
    	
    		

	}

}
