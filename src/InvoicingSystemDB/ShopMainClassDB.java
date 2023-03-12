package InvoicingSystemDB;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;



public class ShopMainClassDB {

	public static void main(String[] args) {
		
		String url = "jdbc:sqlserver://localhost:1433;" 
				   + "databaseName=InvoicingDB;" 
				   + "encrypt=true;" 
				   + "trustServerCertificate=true";
		
        String user = "sa";
        String pass = "root";
        
		ArrayList <ItemDB> itemList=new ArrayList<ItemDB>();

     
		Scanner scan = new Scanner(System.in).useDelimiter("\n");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter User ID : ");
		String userID = scanner.nextLine();
		System.out.print("Enter User password : ");
		String passID = scanner.nextLine();
		
	      Connection connection = null;
		
	      boolean exit = false;

	      try {
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				connection = DriverManager.getConnection(url, user, pass);
				Statement statement = connection.createStatement();
	        
	      }catch (Exception ex) {
		    		System.err.println(ex);
		  }
	        
				InvoiceDB invoiceobj= new InvoiceDB();
				
	        while (!exit) {
    	// Application Main Menu 
		
    	System.out.println("\n⫸⫸⫸⫸⫸⫸⫸⫸👉 Welcome to Groceries Shop System 👈⫷⫷⫷⫷⫷⫷⫷⫷");
        
    	System.out.println("\n1- Shop Settings");
        System.out.println("2- Manage Shop Items");
        System.out.println("3- Create New Invoice");
        System.out.println("4- Report: Statistics");
        System.out.println("5- Report: All Invoices");
        System.out.println("6- Search (1) Invoice");
        System.out.println("7- Program Statistics");
        System.out.println("8- Exit");
        System.out.print  ("\nEnter your choice: ");
	     
	
        
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
                    	
                    	System.out.println("Enter shop name:");
        				String shopName = scan.next();
        				invoiceobj.shopobj.setShopName(shopName);
                        
                        System.out.println("Shop name saved : " + shopName);
                        
                        break;
                    case 3:
                    	 // Set Invoice Header
                    	
                        System.out.print("Enter telephone number: ");
                        Integer telephone = scanner.nextInt();	              
        				invoiceobj.shopobj.setTelephone(telephone);                                                     
                        
        				System.out.print("Enter fax number: ");
                        String fax = scanner.next();
                        invoiceobj.shopobj.setFax(fax);	                                                      
                        
                        System.out.print("Enter new email Id: ");
                        String email = scanner.next();
                        invoiceobj.shopobj.setEmail(email);	                       
                        
                        System.out.print("Enter webSite: ");
                        String webSite = scanner.next();
                        invoiceobj.shopobj.setWebSite(webSite);

                        System.out.println("Invoice telephone saved : " + telephone);
                        System.out.println("Invoice fax saved : " + fax);
                        System.out.println("Invoice email saved : " + email);
                        System.out.println("Invoice webSite saved: " + webSite);
                        
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
                    	
                    	ItemDB itemobj = new ItemDB();
                    	
                    	System.out.print("Enter item ID: ");
                    	Integer itemID = scanner.nextInt();
                        invoiceobj.shopobj.itemobj.setItemID(itemID);
                    	                                              	
                        System.out.print("Enter item name: ");
                        String itemName = scanner.next();
                        invoiceobj.shopobj.itemobj.setItemName(itemName);
                        
                        System.out.print("Enter item price: ");
                        float itemPrice = scanner.nextFloat();
                        invoiceobj.shopobj.itemobj.setItemPrice(itemPrice);
                        
                        System.out.print("Enter Item Quantity: ");
                    	Integer itemQuantity = scanner.nextInt();
                        invoiceobj.shopobj.itemobj.setItemQuantity(itemQuantity);
                        
                        System.out.print("Enter qty Amount Price: ");
                        float qtyAmountPrice = scanner.nextFloat();
                        invoiceobj.shopobj.itemobj.setQtyAmountPrice(qtyAmountPrice);
                        
                        itemList.add(itemobj);
                    	
                    	
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
        
	   
	}}





