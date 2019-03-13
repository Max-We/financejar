import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Budget {

    String budget;
    float budgetFloat;
    
	public float printBudget() throws IOException {
		File Budget = new File("Budget.txt");
        Scanner checkBudget = new Scanner(Budget);

        
        if (checkBudget.hasNext()) {
        	budget = checkBudget.next();
        	System.out.println("\n[Budget] " + budget + "€\n");    	
        } else {
        	Scanner budgetEingabe = new Scanner(System.in);
        	FileWriter budgetWriter = new FileWriter("Budget.txt");
        	
        	System.out.println("Lege dein Budget fest:");
        	
        	budget = "123.32";
        	while(budget == "123.32") {
        		budget = budgetEingabe.next();
        		budgetWriter.write(budget + "\n");
        	}
        	budgetEingabe.close();
        	budgetWriter.close();
        }
        checkBudget.close();
        budgetFloat = Float.parseFloat(budget);
        return budgetFloat;

	}
	public float budgetValue() {
		return budgetFloat;
	}

	public void budgetReport() throws FileNotFoundException {
		DataCounter Expenses = new DataCounter();		
		float expensesA = Expenses.countExpenses();
		
		System.out.println("Budget:     [" + expensesA + "/" + budgetFloat + "€]");
        if(expensesA < budgetFloat) {
        	System.out.println("> You have " + (budgetFloat - expensesA) + "€ remaining until you reach your budget.");
        } else if(budgetFloat < expensesA) {
        	System.out.println("> You have exceeded your budget by " + (expensesA- budgetFloat) + "€.\n");
        } else {
        	System.out.println("> You have reached your Budget.");
        }
	}
}
