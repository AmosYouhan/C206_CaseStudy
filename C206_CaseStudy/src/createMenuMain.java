import java.util.ArrayList;

public class createMenuMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ArrayList<createMenu> menuList = new ArrayList<createMenu>();
		
		menuList.add(new createMenu(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", 3.50));
	    menuList.add(new createMenu(1008, "Char Kway Teow, Coke, Papyaya", 4.00));
	    menuList.add(new createMenu(1009, "Fish & Chips, Ice Lemon Tea, Apple", 5.00));
	    
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
					for(int i = 0; i< menuList.size(); i++) {
						if(menuList.get(i).getMenuID() == orderApplicable) {
							System.out.println("Menu ID already existed");
							
						}else {
							createMenu newOrderMenu = createMenuSet();
							createMenuMain.newlyAddedMenu(menuList, newOrderMenu);
							System.out.println("Created new order Menu");
							break;
						}
					}
		      }
		      	else if(option == 2) {
		  			
		    	  createMenuMain.viewMenu(menuList);
					
		      	}
				else if(option == 3) {
					createMenuMain.deleteMenu(menuList);
				
					
				}else if(option == 4) {
					System.out.println("Thank you for your time!");
				}
			  else {
					System.out.println("The number you entered is invalid");
				}
		    }

		  }
	    public static void newlyAddedMenu(ArrayList<createMenu> menuList, createMenu newOrderMenu) {
	    	menuList.add(newOrderMenu);
	}
	
	


		public static String getMenuInfo(ArrayList<createMenu> menuList) {
				String menuOutput = "";
				
				for(int i = 0; i< menuList.size(); i++) {
					
					menuOutput += String.format("%-15s %-50s %-15s\n", menuList.get(i).getMenuID(),menuList.get(i).getMenuItems(),
							menuList.get(i).getMenuPrice());
				}
				return menuOutput;
			}
		 
			
			public static void viewMenu(ArrayList<createMenu> menuList) {
				String menuOutput = String.format("%-15s %-50s %-15s\n","Menu ID","Menu Item" ,"Menu Price");
				menuOutput += getMenuInfo(menuList);
				System.out.println(menuOutput);
			}
			

			
			


			public static createMenu createMenuSet() {
				int menuID = Helper.readInt("Enter Menu ID: ");
				String menuItem = Helper.readString("Enter Menu Item: ");
				double menuPrice = Helper.readDouble("Enter Menu Price: ");

				
				createMenu addMenu = new createMenu(menuID, menuItem, menuPrice);
				return addMenu;
			}

		
		
			
			public static void deleteMenu(ArrayList<createMenu> menuList) {
				int menuID = Helper.readInt("Enter Menu ID:");
				for (int i = 0; i< menuList.size(); i++ ) {
					if(menuList.get(i).getMenuID() == menuID) {
						menuList.remove(i);
						System.out.println("Menu ID " + menuID + " deleted!");
						
					}	
				}
			}	

}
