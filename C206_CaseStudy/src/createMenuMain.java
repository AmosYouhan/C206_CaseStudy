import java.util.ArrayList;

public class createMenuMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ArrayList<createMenu> menuList = new ArrayList<createMenu>();
		
		menuList.add(new createMenu(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", "Healthy", 3.50));
	    menuList.add(new createMenu(1008, "Char Kway Teow, Coke, Papyaya", "Refreshing", 4.00));
	    menuList.add(new createMenu(1009, "Fish & Chips, Ice Lemon Tea, Apple", "Premium", 5.00));
	    Systen.out.println("Hi");
	   int option = 0;
	   
	   while (option != 4) {
		   	Helper.line(50, "=");
		    System.out.println("Monthly Menu");
			System.out.println("1. Create monthly menu");					
			System.out.println("2. View monthly menu");
			System.out.println("3. Delete monthly menu");
			System.out.println("4. Quit");
			Helper.line(50, "=");
		    option = Helper.readInt("Enter option number from monthly menu: ");
		   
		    if(option == 1) {
		    	  
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
		      	else if(option == 2) {
		  			
		    	  createMenuMain.viewMonthlyMenu(menuList);
					
		      	}
				else if(option == 3) {
					createMenuMain.deleteMonthlyMenu(menuList);
				
					
				}else if(option == 4) {
					System.out.println("Thank you for your time!");
				}
			  else {
					System.out.println("The number you entered is invalid");
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
