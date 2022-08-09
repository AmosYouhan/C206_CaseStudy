import java.util.ArrayList;

public class C206_CaseStudy {
		
		public static void main(String[] args) {

			ArrayList<Menu>menuList = new ArrayList<Menu>();
			ArrayList<Account> accountList = new ArrayList<Account>();
			ArrayList<Order>orderList = new ArrayList<Order>();
			
			menuList(new Menu("m301", "White Behoon, Ice Lemon Tea, Watermelon"));
			menuList(new Menu("m302", "Black Pepper Chicken Chop, Coke, Apple"));
			menuList(new Menu("m303", "Vegetarian Chicken Rice, fruit juice, papaya"));
			
			int option = 0;
			
			while (option != 4) {
				Helper.line(40, "=");
				System.out.println("1. View Menulist");
				System.out.println("2. Add Menu Items");
				System.out.println("3. Delete Menu Items");
				System.out.println("4. Quit");
				
				option = Helper.readInt("Enter your option: ");
				
				if (option == 1) {
					viewAll(menuList);
				}
				
				else if (option == 2) {
					addAll(menuList);
				}
				
				else if (option == 3) {
					deleteAll(menuList);	
				}
				
				else if (option == 4) {
					System.out.println("quit");
				}
				
				else {
					System.out.println("Invalid option");
				}
			}
		}

		private static void menuList(Menu menu) {
			// TODO Auto-generated method stub
			
			
			
		}
}	