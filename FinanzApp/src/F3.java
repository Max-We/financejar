import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class F3 {

    public static void main(String[] args) throws IOException {
        
        // Lesen
        
        String inhalt = new String ( Files.readAllBytes(Paths.get("Ausgaben.txt")));
 
        // Datum Modul
        Date date = java.util.Calendar.getInstance().getTime();
        SimpleDateFormat dateFormatter = 
                  new SimpleDateFormat("dd.MM.yyyy");
        String dateString = dateFormatter.format(date);
        System.out.println(dateString);

        
        // Budget Modul
        File Budget = new File("Budget.txt");
        Scanner checkBudget = new Scanner(Budget);
        String budget;
        
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
        float budgetFloat = Float.parseFloat(budget);
        
        // Input - Hauptmenü
        
        System.out.println("Willkommen, was willst du tun? \n a) Ausgaben eintragen \n b) Einnahmen eintragen \n c) Bericht abrufen");
        Scanner tastatur = new Scanner(System.in);
        FileWriter editor = new FileWriter("Ausgaben.txt", true);
    	FileWriter editorEinnahmen = new FileWriter("Einnahmen.txt", true);
    	float input = 1;
    	String mode = tastatur.nextLine();
    	
    	// Hauptmenü a / b / c
    	switch (mode) {
    	case "a":
    		
    		// Betrag wählen
    		input = 1;
    		System.out.println("a) Ausgaben eintragen:");
    		while(input != 0) {  			
    			System.out.println("Betrag:");   			
                input = tastatur.nextFloat();
                editor.write(input +"");
                
                // Datum wird hinzugefügt

                Date quarter = java.util.Calendar.getInstance().getTime();
                SimpleDateFormat quarterFormatter = new SimpleDateFormat("dd");
                
                String quarterString = quarterFormatter.format(quarter);
                Files.write(Paths.get("Datum.txt"), Arrays.asList(quarterString), StandardOpenOption.APPEND);
 	        
                // Kategorie wählen
                if(input != 0) {
                System.out.println("Kategorie: \na) Essen    b) Technik   c) Sonstiges");
                Scanner kategorieTastatur = new Scanner(System.in);
                String kategorie = kategorieTastatur.next();
                
                if(kategorie.contentEquals("a")){
                	editor.write(" - Essen\n");
                } else if(kategorie.contentEquals("b")) {
                	editor.write(" - Technik\n");
                } else if(kategorie.contentEquals("c")) {
                	editor.write(" - Sonstiges\n");
                }
                }
                
    		}
    		editor.close();

    	case "b": 		
    		input = 1;
    		System.out.println("b) Einnahmen eintragen:");
    		while(input != 0) {
        	input = tastatur.nextFloat();
        	editorEinnahmen.write(input + "\n");
        	}
    		editorEinnahmen.close();
    		
    	case "c":	
    		tastatur.close();
    		File Gesamtausgaben = new File("Ausgaben.txt");
            Scanner ErgebnisLeser = new Scanner(Gesamtausgaben).useLocale(Locale.US);
            
            float Summe = 0;
            while(ErgebnisLeser.hasNextFloat()) {
            Summe += ErgebnisLeser.nextFloat();
            }
            
            
            File GesamtEinnahmen = new File("Einnahmen.txt");
            Scanner EinnahmenLeser = new Scanner(GesamtEinnahmen).useLocale(Locale.US);
            
            float Einnahmen = 0;
            while(EinnahmenLeser.hasNextFloat()) {
            Einnahmen += EinnahmenLeser.nextFloat();
                }
            
            ErgebnisLeser.close();
            EinnahmenLeser.close();
            
            // Bericht
            
            System.out.println("[]============[Bericht]============[] \n ");
            System.out.println(dateString);
            System.out.println("Einnahmen:  +" + Einnahmen + "€");
            System.out.println("Ausgaben:   -" + Summe + "€");
            
            // Analyse Ausgabe - Einnahme
            if(Einnahmen > Summe) {
            	System.out.println("> Du hast diesen Monat " + (Einnahmen - Summe) + "€ übrig.\n");
            }
            else if(Summe > Einnahmen) {
            	System.out.println("> Du hast diesen Monat " + (Summe - Einnahmen) + "€ zuviel ausgegeben.\n");
            }
            else {
            	System.out.println("> Du hast bisher nichts ausgegeben oder verdient.\n");
            }
            
            // Budget
            System.out.println("Budget:     [" + Summe + "/" + budgetFloat + "€]");
            if(Summe < budgetFloat) {
            	System.out.println("> Du hast noch " + (budgetFloat - Summe) + "€ übrig bis dein Budget voll ist.");
            } else if(budgetFloat < Summe) {
            	System.out.println("> Du hast dein Budget um " + (Summe- budgetFloat) + "€ überschritten.\n");
            } else {
            	System.out.println("> Du hast dein Bugdet erreicht.");
            }
           
            // Quarter Analysis
            File datum = new File("Datum.txt");
            File ausgabenQ = new File("Ausgaben.txt");
    		Scanner ausgabenQuarter = new Scanner(ausgabenQ).useLocale(Locale.US);
    		Scanner datumQuarter = new Scanner(datum).useLocale(Locale.US);
    		
    		float qZahl = 0;
    		float qAus = 0;
    		
    		float q1 = 0;
    		float q2 = 0;
    		float q3 = 0;
    		float q4 = 0;
    		
    		System.out.println("[Ausgaben Q1]");
    		while(qZahl < 8 && datumQuarter.hasNextFloat()) {
    			qZahl = datumQuarter.nextFloat();
    			qAus = ausgabenQuarter.nextFloat();
    			q1 += qAus;
    			if(qAus != 0) {
    			System.out.println(qAus);
    			}
    		}
			System.out.println(">Gesamtausgaben: " + q1 + "€");
			
    		if(qZahl > 7) {
    		System.out.println("\n[Ausgaben Q2]");
    		while(qZahl > 7 && qZahl < 18 && datumQuarter.hasNextFloat()) {
    			qZahl = datumQuarter.nextFloat();
    			qAus = ausgabenQuarter.nextFloat();
    			q2 += qAus;
    			if(qAus != 0) {
    			System.out.println(qAus);
    			}
    		}
			System.out.println(">Gesamtausgaben: " + q2 + "€");
    		} else if (qZahl > 17) {
    		System.out.println("\n[Ausgaben Q3]");
    		while(qZahl > 17 && qZahl < 24 && datumQuarter.hasNextFloat()) {
    			qZahl = datumQuarter.nextFloat();
    			qAus = ausgabenQuarter.nextFloat();
    			q3 += qAus;
    			if(qAus != 0) {
    			System.out.println(qAus);
    			}
    		}   
			System.out.println(">Gesamtausgaben: " + q3 + "€");
    		} else if (qZahl > 23) {
    		System.out.println("\n[Ausgaben Q4]");
    		while(qZahl > 23 && qZahl < 32 && datumQuarter.hasNextFloat()) {
    			qZahl = datumQuarter.nextFloat();
    			qAus = ausgabenQuarter.nextFloat();
    			q4 += qAus;
    			if(qAus != 0) {
    			System.out.println(qAus);
    			}
    		}       
			System.out.println(">Gesamtausgaben: " + q4 + "€");
    		}
    	}
        
    }
}
