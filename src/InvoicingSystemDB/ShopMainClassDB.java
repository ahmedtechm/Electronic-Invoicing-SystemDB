package InvoicingSystemDB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ShopMainClassDB {

	public static void main(String[] args) {

		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=InvoicingDB;" + "encrypt=true;"
				+ "trustServerCertificate=true";

		String userID = "sa";
		String passID = "root";

		ArrayList<ItemDB> itemList = new ArrayList<ItemDB>();

		Scanner scan = new Scanner(System.in).useDelimiter("\n");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Connecting to database...");

		boolean passwordCondition = true;
		while (passwordCondition) {
			System.out.println("\nEnter User ID: ");
			userID = scanner.nextLine();
			System.out.println("Enter User password: ");
			passID = scanner.nextLine();

			if (userID.equals("sa") && passID.equals("root")) {
				passwordCondition = false;
			} else {
				System.out.println("Wrong username or password");
			}
		}

		Connection connection = null;

		boolean exit = false;

		InvoiceDB invoiceobj = new InvoiceDB();

		int createTablesCount = 0;
		int shopSettingsCount = 0;
		int manageItemsCount = 0;
		int createInvoiceCount = 0;
		int statisticsCount = 0;
		int allInvoicesCount = 0;
		int searchInvoiceCount = 0;
		int programStatsCount = 0;
		int exitCount = 0;

		while (!exit) {
			// Application Main Menu

			System.out.println("\n⫸⫸⫸⫸⫸⫸⫸⫸👉 Welcome to Groceries Shop System 👈⫷⫷⫷⫷⫷⫷⫷⫷");

			System.out.println("\n0- Create Tables");
			System.out.println("1- Shop Settings");
			System.out.println("2- Manage Shop Items");
			System.out.println("3- Create New Invoice");
			System.out.println("4- Report: Statistics");
			System.out.println("5- Report: All Invoices");
			System.out.println("6- Search (1) Invoice");
			System.out.println("7- Program Statistics");
			System.out.println("8- Exit");
			System.out.print("\nEnter your choice: ");

			int choice = scanner.nextInt();
			switch (choice) {

			case 0:
				try {
					Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
							.newInstance();
					DriverManager.registerDriver(driver);
					connection = DriverManager.getConnection(url, userID, passID);
					Statement statement = connection.createStatement();

					String Item = "CREATE TABLE Item (" + "itemID INT PRIMARY KEY, " + " itemName VARCHAR(255), "
							+ " itemPrice FLOAT , " + "itemQuantity INT, " + "qtyAmountPrice FLOAT  " + ")";

					// statement.executeUpdate(Item);

					String Shop = "CREATE TABLE Shop (" + " telephone INT, " + " fax VARCHAR(255), "
							+ "email VARCHAR(255), " + "webSite VARCHAR(255), " + "shopName VARCHAR(255) " + ")";

					// statement.executeUpdate(Shop);

					String Invoice = "CREATE TABLE Invoice (" + "invoiceId INT, " + " invoiceDate int, "
							+ " customerFullName VARCHAR(255), " + "phoneNumber INT, " + "numberOfItem INT, "
							+ "totalAmount FLOAT , " + "paidAmount FLOAT , " + "balance FLOAT " + ")";

					// statement.executeUpdate(Invoice);

					System.out.println("\nexecute completed ");

				} catch (Exception ex) {
					System.err.println(ex);
				}
				createTablesCount++;

			case 1:
				// Shop Settings Menu
				System.out.println("\n1. Load Data (Items and invoices)");
				System.out.println("2. Set Shop Name");
				System.out.println("3. Set Invoice Header");
				System.out.println("4. Go Back");
				System.out.print("Enter your choice: ");

				shopSettingsCount++;

				int subChoice = scanner.nextInt();
				switch (subChoice) {
				case 1:
					// Load Data (Items and invoices)
					System.out.println("Loading data...");

					try {

						connection = DriverManager.getConnection(url, userID, passID);
						Statement statement = connection.createStatement();

						String query = "SELECT * FROM Item, Invoice";

						ResultSet resultSet = statement.executeQuery(query);

						// Loop through the result set and print out each invoice
						while (resultSet.next()) {
							int itemID = resultSet.getInt("itemID");
							String itemName = resultSet.getString("itemName");
							double itemPrice = resultSet.getDouble("itemPrice");

							int invoiceId = resultSet.getInt("invoiceId");
							String customerFullName = resultSet.getString("customerFullName");
							int phoneNumber = resultSet.getInt("phoneNumber");
							int invoiceDate = resultSet.getInt("invoiceDate");
							int numberOfItem = resultSet.getInt("numberOfItem");
							float totalAmount = resultSet.getFloat("totalAmount");
							float paidAmount = resultSet.getFloat("paidAmount");
							float balance = resultSet.getFloat("balance");

							System.out.print("\nItem ID: " + itemID);
							System.out.print("\nItem Name: " + itemName);
							System.out.println("\nItem Price: " + itemPrice);

							System.out.println("Invoice ID: " + invoiceId);
							System.out.println("Customer Full Name: " + customerFullName);
							System.out.println("Phone Number: " + phoneNumber);
							System.out.println("Invoice Date: " + invoiceDate);
							System.out.println("Number of Item: " + numberOfItem);
							System.out.println("Total Amount: " + totalAmount);
							System.out.println("Paid Amount: " + paidAmount);
							System.out.println("Balance: " + balance);
						}
						System.out.println("\nLoaded All Data Successfully...");

					} catch (Exception e) {
						// TODO: handle exception
					}

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

					try {
						String shopName1 = invoiceobj.shopobj.getShopName();

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

						Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
								.newInstance();
						DriverManager.registerDriver(driver);
						connection = DriverManager.getConnection(url, userID, passID);
						Statement statement = connection.createStatement();

						String sql = "INSERT INTO Shop (shopName, telephone, fax, email, webSite) " +

								"VALUES (" + "'" + shopName1 + "'," + telephone + "," + fax + ",'" + email + "','"
								+ webSite + "')";

						statement.executeUpdate(sql);

						System.out.println("saved successfully...");

					} catch (Exception e) {
						// TODO: handle exception
					}

					break;
				case 4:
					break;
				default:
					System.out.println("Invalid choice. Please enter a valid number.");
				}
				break;
			case 2:
				// Manage Shop Items Menu
				System.out.println("1. Add Items");
				System.out.println("2. Delete Items");
				System.out.println("3. Change Item Price");
				System.out.println("4. Report All Items");
				System.out.println("5. Go Back");
				System.out.print("Enter your choice: ");

				manageItemsCount++;

				subChoice = scanner.nextInt();
				switch (subChoice) {
				case 1:
					// Add Items
					try {
						ItemDB itemobj = new ItemDB();

						System.out.print("Enter item ID: ");
						Integer itemID = scanner.nextInt();
						invoiceobj.shopobj.itemobj.setItemID(itemID);

						System.out.print("Enter item name: ");
						String itemName = scan.next();
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

						System.out.println("item ID saved : " + itemID);
						System.out.println("item name saved : " + itemName);
						System.out.println("item price saved : " + itemPrice);
						System.out.println("Item Quantity saved: " + itemQuantity);
						System.out.println("Item qty Amount Price saved: " + qtyAmountPrice);

						Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
								.newInstance();
						DriverManager.registerDriver(driver);
						connection = DriverManager.getConnection(url, userID, passID);
						Statement statement = connection.createStatement();

						String sql1 = "INSERT INTO Item (itemID, itemName, itemPrice, itemQuantity, qtyAmountPrice) "
								+ "VALUES(" + itemID + ",'" + itemName + "'," + itemPrice + "," + itemQuantity + ","
								+ qtyAmountPrice + ")";

						statement.executeUpdate(sql1);

						System.out.println("saved successfully...");
					} catch (Exception e) {
						// TODO: handle exception
					}

					break;
				case 2:
					// Delete Items
					try {
						Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
								.newInstance();
						DriverManager.registerDriver(driver);
						connection = DriverManager.getConnection(url, userID, passID);
						Statement statement = connection.createStatement();

						System.out.print("Enter Item ID you want to Delete : ");
						int delete = scanner.nextInt();
						String sqldelete = "DELETE FROM Item WHERE itemID = " + delete;
						statement.executeUpdate(sqldelete);

						System.out.println("Deleted successfully...");
					} catch (Exception e) {
						// TODO: handle exception
					}

					break;
				case 3:
					// Change Item Price

					try {
//					Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
//							.newInstance();
						// DriverManager.registerDriver(driver);
						connection = DriverManager.getConnection(url, userID, passID);
						Statement statement = connection.createStatement();

						System.out.print("Enter Item ID you want to change its Price: ");
						int itemID = scanner.nextInt();

						System.out.print("Enter new Item Price: ");
						double newPrice = scanner.nextDouble();

						String sqlch = "UPDATE Item SET itemPrice = " + newPrice + " WHERE itemID = " + itemID;

						PreparedStatement statement1 = connection.prepareStatement(sqlch);
						statement1.setDouble(1, newPrice);
						statement1.setInt(2, itemID);

						statement.executeUpdate(sqlch);

						System.out.println("updated successfully...");
					} catch (SQLException ex) {
						System.out.println("An error occurred while updating the item price: " + ex.getMessage());
						// TODO: handle exception
					}

					break;
				case 4:
					// Report All Items
					try {
						connection = DriverManager.getConnection(url, userID, passID);
						Statement statement = connection.createStatement();
						String sql;
						sql = "SELECT * FROM Item";
						ResultSet rs = statement.executeQuery(sql);

						while (rs.next()) {

							int itemID = rs.getInt("itemID");
							String itemName = rs.getString("itemName");
							double itemPrice = rs.getDouble("itemPrice");

							System.out.print("\nItem ID: " + itemID);
							System.out.print("\nItem Name: " + itemName);
							System.out.println("\nItem Price: " + itemPrice);
						}

						System.out.println("\nReported All Items successfully...");
					} catch (Exception e) {
						// TODO: handle exception
					}

					break;
				case 5:
					break;
				default:
					System.out.println("Invalid choice. Please enter a valid number.");
				}
				break;
			case 3:
				// Create New Invoice
				try {

					System.out.print("\nEnter Invoice ID Number : ");
					Integer invoiceId = scanner.nextInt();
					invoiceobj.setPhoneNumber(invoiceId);

					System.out.print("\nEnter Customer Full Name : ");
					String customerFullName = scan.next();
					invoiceobj.setCustomerFullName(customerFullName);

					System.out.print("\nEnter Customer Phone Number : ");
					Integer phoneNumber = scanner.nextInt();
					invoiceobj.setPhoneNumber(phoneNumber);

					System.out.print("\nEnter Invoice Date : ");
					Integer invoiceDate = scanner.nextInt();
					invoiceobj.setInvoiceDate(invoiceDate);

					System.out.print("\nEnter Number of Item : ");
					Integer numberOfItem = scanner.nextInt();
					invoiceobj.setNumberOfItem(numberOfItem);

					System.out.print("\nEnter Total Amount : ");
					float totalAmount = scanner.nextFloat();
					invoiceobj.setTotalAmount(totalAmount);

					System.out.print("\nEnter Paid Amount : ");
					float paidAmount = scanner.nextFloat();
					invoiceobj.setPaidAmount(paidAmount);

					System.out.print("\nEnter Balance : ");
					float balance = scanner.nextFloat();
					invoiceobj.setBalance(balance);

					System.out.println("Customer Phone Number saved : " + invoiceId);
					System.out.println("Customer Full Name saved : " + customerFullName);
					System.out.println("Customer Phone Number saved : " + phoneNumber);
					System.out.println("Invoice Date saved : " + invoiceDate);
					System.out.println("Number of Item saved: " + numberOfItem);
					System.out.println("Total Amount saved: " + totalAmount);
					System.out.println("Paid Amount saved : " + paidAmount);
					System.out.println("Balance saved : " + balance);

					Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
							.newInstance();
					DriverManager.registerDriver(driver);
					connection = DriverManager.getConnection(url, userID, passID);
					Statement statement = connection.createStatement();

					String sqlInvoice = "INSERT INTO Invoice (invoiceId, invoiceDate, customerFullName, phoneNumber, numberOfItem, totalAmount, paidAmount, balance)"
							+ "VALUES (" + invoiceId + "," + invoiceDate + ",'" + customerFullName + "'," + phoneNumber
							+ "," + numberOfItem + "," + totalAmount + "," + paidAmount + "," + balance + ")";

					statement.executeUpdate(sqlInvoice);

					System.out.println("saved successfully...");
				} catch (Exception e) {
					// TODO: handle exception
				}
				createInvoiceCount++;

				break;
			case 4:
				// Report: Statistics(No Of Items, No of Invoices, Total Sales)

				try {
					connection = DriverManager.getConnection(url, userID, passID);
					Statement statement = connection.createStatement();

					String sql = "SELECT COUNT(DISTINCT itemID) AS NumberOfItems, COUNT(DISTINCT invoiceId) AS NumberOfInvoice, SUM(totalAmount) AS total_sales FROM Item, Invoice ";

					ResultSet result = statement.executeQuery(sql);
					while (result.next()) {
						String NumberOfInvoice = result.getString("NumberOfInvoice");
						String NumberOfItems = result.getString("NumberOfItems");
						String TotalSales = result.getString("total_sales");

						System.out.println("Number of Invoice : " + NumberOfInvoice + ", Number of Items : "
								+ NumberOfItems + ", Total Sales : " + TotalSales);

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				statisticsCount++;

				break;
			case 5:
				// Report: All Invoices
				try {

					connection = DriverManager.getConnection(url, userID, passID);
					Statement statement = connection.createStatement();

					String query = "SELECT * FROM Invoice";

					ResultSet resultSet = statement.executeQuery(query);

					// Loop through the result set and print out each invoice
					while (resultSet.next()) {
						int invoiceId = resultSet.getInt("invoiceId");
						String customerFullName = resultSet.getString("customerFullName");
						int phoneNumber = resultSet.getInt("phoneNumber");
						int invoiceDate = resultSet.getInt("invoiceDate");
						int numberOfItem = resultSet.getInt("numberOfItem");
						float totalAmount = resultSet.getFloat("totalAmount");
						float paidAmount = resultSet.getFloat("paidAmount");
						float balance = resultSet.getFloat("balance");

						System.out.println("\nInvoice ID: " + invoiceId);
						System.out.println("Customer Full Name: " + customerFullName);
						System.out.println("Phone Number: " + phoneNumber);
						System.out.println("Invoice Date: " + invoiceDate);
						System.out.println("Number of Item: " + numberOfItem);
						System.out.println("Total Amount: " + totalAmount);
						System.out.println("Paid Amount: " + paidAmount);
						System.out.println("Balance: " + balance);
					}
					System.out.println("\nReported All Invoice successfully...");

				} catch (Exception e) {
					// TODO: handle exception
				}
				allInvoicesCount++;

				break;
			case 6:
				// Search (1) Invoice
				try {

					connection = DriverManager.getConnection(url, userID, passID);
					Statement statement = connection.createStatement();

					System.out.print("Enter Invoice ID to search for: ");
					int invoiceId = scanner.nextInt();

					String sqlSearch = "SELECT * FROM Invoice WHERE invoiceId = " + invoiceId;

					ResultSet resultSet = statement.executeQuery(sqlSearch);

					// print out the results
					while (resultSet.next()) {
						System.out.println("Invoice ID: " + resultSet.getInt("invoiceId"));
						System.out.println("Invoice Date: " + resultSet.getInt("invoiceDate"));
						System.out.println("Customer Full Name: " + resultSet.getString("customerFullName"));
						System.out.println("Customer Phone Number: " + resultSet.getInt("phoneNumber"));
						System.out.println("Number of Item: " + resultSet.getInt("numberOfItem"));
						System.out.println("Total Amount: " + resultSet.getFloat("totalAmount"));
						System.out.println("Paid Amount: " + resultSet.getFloat("paidAmount"));
						System.out.println("Balance: " + resultSet.getFloat("balance"));
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				searchInvoiceCount++;

				break;
			case 7:
				// Program Statistics

				System.out.println("//---------Program Statistics:-----------//");
				System.out.println("0- Create Tables: " + createTablesCount);
				System.out.println("1- Shop Settings: " + shopSettingsCount);
				System.out.println("2- Manage Shop Items: " + manageItemsCount);
				System.out.println("3- Create New Invoice: " + createInvoiceCount);
				System.out.println("4- Report: Statistics: " + statisticsCount);
				System.out.println("5- Report: All Invoices: " + allInvoicesCount);
				System.out.println("6- Search (1) Invoice: " + searchInvoiceCount);
				System.out.println("7- Program Statistics: " + programStatsCount);
				System.out.println("8- Exit: " + exitCount);

				programStatsCount++;

				break;

			case 8:
				exitCount++;

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
