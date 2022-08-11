import java.util.ArrayList;

public class C206_CaseStudy {
	
		public static void main(String[] args) {

			ArrayList<Account> newAccount = new ArrayList<Account>();
			ArrayList<menuClass> newMenuItems = new ArrayList<menuClass>();
			ArrayList<lunchboxOrderClass> newOrder = new ArrayList<lunchboxOrderClass>();
			ArrayList<orderClass> newBill = new ArrayList<orderClass>();
			ArrayList<createMenu> menuList = new ArrayList<createMenu>();
			
			newAccount.add(new Account(1000, "alpha", "Jack", "Reacher"));
		    newAccount.add(new Account(1001, "beta", "John", "Wick"));
		    newAccount.add(new Account(1002, "charlie", "James", "Bond"));
		    
		    newMenuItems.add(new menuClass(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", 3.50));
		    newMenuItems.add(new menuClass(1008, "Char Kway Teow, Coke, Papyaya", 4.00));
		    newMenuItems.add(new menuClass(1009, "Fish & Chips, Ice Lemon Tea, Apple", 5.00));
		    
		    newOrder.add(new lunchboxOrderClass(1007, "2022-08-09", 3.50,"Vegetarian Bee Hoon, Apple Juice, Watermelon"));
		    newOrder.add(new lunchboxOrderClass(1008, "2022-08-10", 5.50,"Char Kway Teow, Coke, Papyaya"));
		    newOrder.add(new lunchboxOrderClass(1009, "2022-08-11", 4.50,"Fish & Chips, Ice Lemon Tea, Apple"));
		    
		    newBill.add(new orderClass(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", 3.50, "Processing"));
		    newBill.add(new orderClass(1008, "Char Kway Teow, Coke, Papyaya", 4.00, "Processing"));
		    newBill.add(new orderClass(1009, "Fish & Chips, Ice Lemon Tea, Apple", 5.00, "Processing"));
		    
		    menuList.add(new createMenu(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", "Healthy", 3.50));
		    menuList.add(new createMenu(1008, "Char Kway Teow, Coke, Papyaya", "Refreshing", 4.00));
		    menuList.add(new createMenu(1009, "Fish & Chips, Ice Lemon Tea, Apple", "Premium", 5.00));
		    
			int enterOption = 0;
			int option1 = 0;
			int option2 = 0;
			int option3 = 0;
			int option4 = 0;
			int option5 = 0;
			
			while (enterOption != 6) {

				System.out.println("1. User Account");
				System.out.println("2. Menu Items");
				System.out.println("3. Lunch Box Order");
				System.out.println("4. Order Bills");
				System.out.println("5. Monthly Menu");
				System.out.println("6. Quit");
				
				enterOption = Helper.readInt("Enter an option: ");

				if (enterOption == 1) {
					Helper.line(50, "=");
				    System.out.println("Account");
					System.out.println("1. Add Account");
					System.out.println("2. View Accounts");
					System.out.println("3. Delete Account");
					System.out.println("4. Quit");
					Helper.line(50, "=");
				    option1 = Helper.readInt("Enter option number from the account menu: ");
				    
				    if(option1 == 1) {
				    	  
				    	  int accountApplicable = Helper.readInt("Enter Account ID check whether it is applicable: ");
							for(int i = 0; i<newAccount.size(); i++) {
								
								if(newAccount.get(i).getAccId() == accountApplicable) {
									System.out.println("Account ID already exists");
									
								}else {
									Account newAccountUser = createAccount();
									AccountClass.newlyAddedAccount(newAccount,newAccountUser);
									System.out.println("Created new Account");
									break;
								}
							}
				      }
				    else if (option1 == 2) {
				    	AccountClass.viewAccount(newAccount);
				    }
				    else if (option1 == 3) {
				    	AccountClass.deleteAccount(newAccount);
				    }
				    else if (option1 == 4) {
				    	System.out.println("Thank you for your time!");
				    }
				    else {
				    	System.out.println("The number you entered is invalid");
				    }
		      }
				else if (enterOption == 2) {
					Helper.line(50, "=");
				    System.out.println("Menu Items");
					System.out.println("1. Add menu items");					
					System.out.println("2. View menu items");
					System.out.println("3. Delete menu items");
					System.out.println("4. Quit");
					Helper.line(50, "=");
				    option2 = Helper.readInt("Enter option number from menu items: ");
				    
				    if(option2 == 1) {
				    	int orderApplicable = Helper.readInt("Enter menu ID check whether it is applicable: ");
						for(int i = 0; i<newMenuItems.size(); i++) {
							if(newMenuItems.get(i).getMenuID() == orderApplicable) {
								System.out.println("Menu ID already existed");
								
							}else {
								menuClass newOrderMenu = createMenuItems();
								menuItems.newlyAddedMenu(newMenuItems, newOrderMenu);
								System.out.println("Created new order Menu");
								break;
							}
						}
				    }
				    else if(option2 == 2) {
				    	menuItems.viewMenuItems(newMenuItems);
				    }
				    else if(option2 == 3) {
				    	menuItems.deleteMenuItems(newMenuItems);
				    }
				    else if(option2 == 4) {
				    	System.out.println("Thank you for your time!");
				    }
				    else {
				    	System.out.println("The number you entered is invalid");

				    }
				}
				else if(enterOption == 3) {
					Helper.line(50, "=");
				    System.out.println("LunchBox Order");
					System.out.println("1. Add LunchBox Order");
					System.out.println("2. View LunchBox Order");
					System.out.println("3. Delete LunchBox Order");
					System.out.println("4. Quit");
					Helper.line(50, "=");
				    option3 = Helper.readInt("Enter Option(1,2,3,4)>  ");
				    
				    if(option3 == 1) {
				    	int id = Helper.readInt("Enter new lunch box ID");
				    	 String date = Helper.readString("Enter new lunchbox order date");
				    	 double price = Helper.readDouble("Enter lunch box price");
				    	 String items = Helper.readString("Enter lunchbox items");
							boolean isAdded = lunchboxOrder.AddlunchboxOrder(newOrder, id, date,price,items);
							if(isAdded) {
								System.out.println("New member added.");
							} else {
								System.out.println("Failed to add.");
							}
				    }
				    else if(option3 == 2) {
				    	lunchboxOrder.ViewLunchBoxOrder(newOrder);
				    }
				    else if(option3 == 3) {
				    	lunchboxOrder.DeleteLunchBoxOrder(newOrder);
				    }
				    else if(option3 == 4) {
				    	System.out.println("Thanyou for using our app!");
				    }
				    else {
				    	System.out.println("Invalid Option!");
				    }
				}
				else if(enterOption == 4) {
					Helper.line(50, "=");
				    System.out.println("Order Bills");
					System.out.println("1. Add order bill");
					System.out.println("2. View order bill");
					System.out.println("3. Delete order bill");
					System.out.println("4. Quit");
					Helper.line(50, "=");
				    option4 = Helper.readInt("Enter option number from order menu: ");
				    
				    if(option4 == 1) {
				    	int orderApplicable = Helper.readInt("Enter order ID check whether it is applicable: ");
						for(int i = 0; i<newBill.size(); i++) {
							
							if(newBill.get(i).getOrderID() == orderApplicable) {
								System.out.println("Order ID already existed");
								
							}else {
								orderClass newOrderBill = createOrderBill();
								orderBill.newlyAddedBill(newBill, newOrderBill);
								System.out.println("Created new order bill");
								break;
							}
						}
				    }
				    else if(option4 == 2) {
				    	orderBill.viewOrderBill(newBill);
				    }
				    else if(option4 == 3) {
				    	orderBill.deleteOrderBill(newBill);
				    }
				    else if(option4 == 4) {
				    	System.out.println("Thank you for your time!");
				    }
				    else {
				    	System.out.println("The number you entered is invalid");
				    }
				}
				else if(enterOption == 5) {
					Helper.line(50, "=");
				    System.out.println("Monthly Menu");
					System.out.println("1. Create monthly menu");					
					System.out.println("2. View monthly menu");
					System.out.println("3. Delete monthly menu");
					System.out.println("4. Quit");
					Helper.line(50, "=");
				    option5 = Helper.readInt("Enter option number from monthly menu: ");
				    
				    if(option5 == 1) {
				    	int monthlyApplicable = Helper.readInt("Enter monthly menu ID to check whether it is applicable: ");
						for(int i = 0; i< menuList.size(); i++) {
							if(menuList.get(i).getMenuID() == monthlyApplicable) {
								System.out.println("Monthly Menu ID already existed");
								
							}else {
								createMenu newMonthlyMenu = createMenuSet();
								createMenuMain.newlyMonthlyMenu(menuList, newMonthlyMenu);
								System.out.println("Created New Monthly Menu");
								break;
							}
						}
				    }
				    else if(option5 == 2) {
				    	createMenuMain.viewMonthlyMenu(menuList);
				    }
				    else if(option5 == 3) {
				    	createMenuMain.deleteMonthlyMenu(menuList);
				    }
				    else if(option5 == 4) {
				    	System.out.println("Thank you for your time!");
				    }
				    else {
				    	System.out.println("The number you entered is invalid");
				    }
				}
				else {
					System.out.println("Thank you for your time!");
				}
				
				
			}
		}
		
		public static String getAccountInfo(ArrayList<Account> newAccount) {
			String accountOutput = "";
			
			for(int i = 0; i<newAccount.size(); i++) {
				
				accountOutput += String.format("%-15s %-20s %-20s %-15s\n", newAccount.get(i).getAccId(),newAccount.get(i).getPassword(),
						newAccount.get(i).getpName(),newAccount.get(i).getsName());
			}
			return accountOutput;
		}
	 
		
		public static void viewAccount(ArrayList<Account> newAccount) {
			String accountOutput = String.format("%-15s %-20s %-20s %-15s\n","Account ID","Password" ,"Parent's Name" ,"Student's Name");
			accountOutput += getAccountInfo(newAccount);
			System.out.println(accountOutput);
		}

		public static Account createAccount() {
			int accID = Helper.readInt("Enter Account ID: ");
			String Password = Helper.readString("Enter Password: ");
			String pName = Helper.readString("Enter Parent's Name: ");
			String sName = Helper.readString("Enter Student's Name: ");

			Account addAccount = new Account(accID, Password, pName, sName) ;
			return addAccount;
		}


		public static void newlyAddedAccount(ArrayList<Account> Account, Account newAccountUser) {
			Account.add(newAccountUser);
		}
		
		
		public static void deleteAccount(ArrayList<Account> Account) {
			int accID = Helper.readInt("Enter Account ID:");
			for (int i = 0; i< Account.size(); i++ ) {
				if(Account.get(i).getAccId() == accID) {
					Account.remove(i);
					System.out.println("Account ID" + accID + "deleted!");
					
				}
			
			}	
		}
		
		public static String getMenuInfo(ArrayList<menuClass> newMenuItems) {
			String menuOutput = "";
			
			for(int i = 0; i<newMenuItems.size(); i++) {
				
				menuOutput += String.format("%-15s %-50s %-15s\n", newMenuItems.get(i).getMenuID(),newMenuItems.get(i).getMenuItem(),
						newMenuItems.get(i).getMenuPrice());
			}
			return menuOutput;
		}
	 
		
		public static void viewMenuItems(ArrayList<menuClass> newMenuItems) {
			String menuOutput = String.format("%-15s %-50s %-15s\n","Menu ID","Menu Item" ,"Menu Price");
			menuOutput += getMenuInfo(newMenuItems);
			System.out.println(menuOutput);
		}

		public static menuClass createMenuItems() {
			int menuID = Helper.readInt("Enter Menu ID: ");
			String menuItem = Helper.readString("Enter Menu Item: ");
			double menuPrice = Helper.readDouble("Enter Menu Price: ");

			
			menuClass addMenu = new menuClass(menuID, menuItem, menuPrice);
			return addMenu;
		}

	
		public static void newlyAddedMenu(ArrayList<menuClass> newMenuItems, menuClass newOrderMenu) {
			newMenuItems.add(newOrderMenu);
		}
		
		public static void deleteMenuItems(ArrayList<menuClass> newMenuItems) {
			int menuID = Helper.readInt("Enter Menu ID:");
			for (int i = 0; i< newMenuItems.size(); i++ ) {
				if(newMenuItems.get(i).getMenuID() == menuID) {
					newMenuItems.remove(i);
					System.out.println("Menu ID " + menuID + " deleted!");
					
				}	
			}
		}	
		
		public static void DeleteLunchBoxOrder(ArrayList<lunchboxOrderClass> newOrder) {
		    // TODO Auto-generated method stub
		    int orderID = Helper.readInt("Enter Order ID:");
		    for (int i = 0; i< newOrder.size(); i++ ) {
		      if(newOrder.get(i).getLBorderId() == orderID) {
		        newOrder.remove(i);
		        System.out.println("Order ID " + orderID + "deleted!");
		      }
		    }
		  }

		  public static void ViewLunchBoxOrder(ArrayList<lunchboxOrderClass> newOrder) {
		    // TODO Auto-generated method stub
		    Helper.line(50,  "=");
		      System.out.println(" VIEW LUNCHBOX ORDER");
		      Helper.line(50,  "=");
		      //print header
		      
		      String output = String.format("%-10s %-10s %-15s %-10s\n", "ID" , "DATE" , "PRICE" , "ITEMS");
		      //using String.format print out the input order
		      
		      int orderID = Helper.readInt("Find LunchBox Order> Key in order id > ");
		      //ask user to input the age they want to find older than
		      for (int i = 0; i<newOrder.size(); i++)
		        //using for loop to run the  list
		      {
		        if(newOrder.get(i).getLBorderId() == orderID){
		          lunchboxOrderClass LB = newOrder.get(i);
		          output += String.format("%-10d %-10.2f %-15s %-10s\n", LB.getLBorderId(), LB.getLBOrderDate(), LB.getLBOrderPrice(),LB.getLBItems());
		           
		        }
		      }
		      System.out.println(output);
		      //print the output
		        }
		    

		  public static boolean AddlunchboxOrder(ArrayList<lunchboxOrderClass> newOrder, int id, String date,
		      double price, String items) {
		    boolean isAdded = false;
		    //creating a boolean to check if is added 
		    //initialised to false
		    
		    newOrder.add(new lunchboxOrderClass(id,date,price,items));
		    //add in the member using .add method
		    
		    isAdded = true;  
		    //when its added isAdded is true
		    
		    return isAdded;
		    //return isAdded
		    
		  }
		
		public static String getOrderInfo(ArrayList<orderClass> newBill) {
			String billOutput = "";
			
			for(int i = 0; i<newBill.size(); i++) {
				
				billOutput += String.format("%-15s %-50s %-50s %-15s\n", newBill.get(i).getOrderID(),newBill.get(i).getOrderItem(),
						newBill.get(i).getOrderPrice(),newBill.get(i).getOrderStat());
			}
			return billOutput;
		}
	 
		
		public static void viewOrderBill(ArrayList<orderClass> newBill) {
			String billOutput = String.format("%-15s %-50s %-50s %-15s\n","Order ID","Order Item" ,"Order Price" ,"Order Status");
			billOutput += getOrderInfo(newBill);
			System.out.println(billOutput);
		}

		public static orderClass createOrderBill() {
			int orderID = Helper.readInt("Enter Order ID: ");
			String orderItem = Helper.readString("Enter Order Item: ");
			double orderPrice = Helper.readDouble("Enter Order Price: ");
			String orderStat = Helper.readString("Enter Order Status: ");

			orderClass addOrder = new orderClass(orderID, orderItem, orderPrice, orderStat);
			return addOrder;
		}


		public static void newlyAddedBill(ArrayList<orderClass> newBill, orderClass newOrderBill) {
			newBill.add(newOrderBill);
		}
		
		
		public static void deleteOrderBill(ArrayList<orderClass> newBill) {
			int orderID = Helper.readInt("Enter Order ID:");
			for (int i = 0; i< newBill.size(); i++ ) {
				if(newBill.get(i).getOrderID() == orderID) {
					newBill.remove(i);
					System.out.println("Order ID " + orderID + "deleted!");
				}
			
			}	
		}
		
		public static void newlyMonthlyMenu(ArrayList<createMenu> menuList, createMenu newMonthlyMenu) {
	    	menuList.add(newMonthlyMenu);
	}
	
	


		public static String getMonthly(ArrayList<createMenu> menuList) {
				String menuOutput = "";
				
				for(int i = 0; i< menuList.size(); i++) {
					
					menuOutput += String.format("%-15s %-50s %-50s %-15s\n", menuList.get(i).getMenuID(),menuList.get(i).getMenuItems(),
							menuList.get(i).getMenuDescription(),menuList.get(i).getMenuPrice());
				}
				return menuOutput;
			}
		 
			
			public static void viewMonthlyMenu(ArrayList<createMenu> menuList) {
				String menuOutput = String.format("%-15s %-50s %-50s %-15s\n","Menu ID","Menu Item" , "Menu Description","Menu Price");
				menuOutput += getMonthly(menuList);
				System.out.println(menuOutput);
			}
			

			
			


			public static createMenu createMenuSet() {
				int menuID = Helper.readInt("Enter Menu ID: ");
				String menuItem = Helper.readString("Enter Menu Item: ");
				String menuDescription = Helper.readString("Enter Menu Description: ");
				double menuPrice = Helper.readDouble("Enter Menu Price: ");

				
				createMenu addMenu = new createMenu(menuID, menuItem,menuDescription, menuPrice);
				return addMenu;
			}

		
		
			
			public static void deleteMonthlyMenu(ArrayList<createMenu> menuList) {
				int monthlymenuID = Helper.readInt("Enter Monthly Menu ID:");
				for (int i = 0; i< menuList.size(); i++ ) {
					if(menuList.get(i).getMenuID() == monthlymenuID) {
						menuList.remove(i);
						System.out.println("Menu ID " + monthlymenuID + " deleted!");
						
					}	
				}
			}		
}	