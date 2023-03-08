package InvoicingSystemDB;

import java.util.Scanner;

public class ShopMainClassDB {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in).useDelimiter("\n");
		Scanner scanner = new Scanner(System.in);
		
		 boolean exit = false;
	        while (!exit) {
    	// Application Main Menu 
		
    	System.out.println("⫸⫸⫸⫸⫸⫸⫸⫸👉 Welcome to Groceries Shop System 👈⫷⫷⫷⫷⫷⫷⫷⫷");
        System.out.println("\n1- Shop Settings");
        System.out.println("2- Manage Shop Items");
        System.out.println("3- Create New Invoice");
        System.out.println("4- Report: Statistics");
        System.out.println("5- Report: All Invoices");
        System.out.println("6- Search (1) Invoice");
        System.out.println("7- Program Statistics");
        System.out.println("8- Exit");
        System.out.print  ("Enter your choice: ");
        
        
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
            	// Shop Settings Menu
            	System.out.println("1. Load Data (Items and invoices)");
                System.out.println("2. Set Shop Name");
                System.out.println("3. Set Invoice Header");
                System.out.println("4. Go Back");
                System.out.print  ("Enter your choice: ");

                int subChoice = scanner.nextInt();
                switch (subChoice) {
                    case 1:
                    	 // Load Data (Items and invoices)
                        
                        break;
                       
                    case 2:
                        // Set Shop Name 
                        
                        break;
                    case 3:
                    	 // Set Invoice Header
                        
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number.");
                }
                break;
            case 2:
            	//Manage Shop Items Menu
            	System.out.println("1. Add Items");
                System.out.println("2. Delete Items");
                System.out.println("3. Change Item Price");
                System.out.println("4. Report All Items");
                System.out.println("5. Go Back");
                System.out.print("Enter your choice: ");
                
                subChoice = scanner.nextInt();
                switch (subChoice) {
                    case 1:
                    	// Add Items
                    	
                        break;
                    case 2:
                    	 // Delete Items
                       
                        break;
                    case 3:
                        // Change Item Price
                        
                    	break;
                    case 4:
                        // Report All Items
                       
                    	break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number.");
                }
                break;
            case 3:
                // Create New Invoice

                break;
            case 4:
                // Report: Statistics
            	
                break;
            case 5:
                // Report: All Invoices
            	
                break;
            case 6:
                // Search (1) Invoice
            	
                break;
            case 7:
                // Program Statistics
            	
                break;
            case 8:
                System.out.print("Are you sure you want to exit? (yes/no): ");
                String confirm = scanner.next();
                if (confirm.equalsIgnoreCase("yes")) {
                    exit = true;
                }
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid number.");
        }
     }      
        
  }

}
