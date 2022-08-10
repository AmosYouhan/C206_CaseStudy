import java.util.ArrayList;

public class menuItems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<menuClass> newMenuItems = new ArrayList<menuClass>();
		
		newMenuItems.add(new menuClass(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", 3.50));
	    newMenuItems.add(new menuClass(1008, "Char Kway Teow, Coke, Papyaya", 4.00));
	    newMenuItems.add(new menuClass(1009, "Fish & Chips, Ice Lemon Tea, Apple", 5.00));
	    
	   int option = 0;
	   
	   while (option != 4) {
		   	Helper.line(50, "=");
		    System.out.println("Menu Items");
			System.out.println("1. Add menu items");					
			System.out.println("2. View menu items");
			System.out.println("3. Delete menu items");
			System.out.println("4. Quit");
			Helper.line(50, "=");
		    option = Helper.readInt("Enter option number from menu items: ");
		   
		    if(option == 1) {
		    	  
		    	  int orderApplicable = Helper.readInt("Enter menu ID check whether it is applicable: ");
					for(int i = 0; i<newMenuItems.size(); i++) {
						if(newMenuItems.get(i).getMenuID() == orderApplicable) {
							System.out.println("Menu ID already existed");
							
						}else {
							menuClass newOrderMenu = createMenuItems();
							newMenuItems.newlyAddedMenu(newMenuItems, newOrderMenu);
							System.out.println("Created new order Menu");
							break;
						}
					}
		      }
		      	else if(option == 2) {
		  			
		    	  menuItems.viewMenuItems(newMenuItems);
					
		      	}
				else if(option == 3) {
					menuItems.deleteMenuItems(newMenuItems);
				
					
				}else if(option == 4) {
					System.out.println("Thank you for your time!");
				}
			  else {
					System.out.println("The number you entered is invalid");
				}
		    }

		  }
		 
		  
		  public static String getMenuInfo(ArrayList<menuClass> newMenuItems) {
				String menuOutput = "";
				
				for(int i = 0; i<newMenuItems.size(); i++) {
					
					menuOutput += String.format("%-15s %-20s %-20s %-15s\n", newMenuItems.get(i).getMenuID(),newMenuItems.get(i).getMenuItem(),
							newMenuItems.get(i).getMenuPrice());
				}
				return menuOutput;
			}
		 
			
			public static void viewMenuItems(ArrayList<menuClass> newMenuItems) {
				String menuOutput = String.format("%-15s %-20s %-20s %-15s\n","Menu ID","Menu Item" ,"Menu Price");
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

			
			public static void newlyAddedMenu(ArrayList<menuClass> newMenuItems, menuClass newMenu) {
				newMenuItems.add(newMenu);
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
		}

	  

