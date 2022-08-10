import java.util.ArrayList;

public class C206_CaseStudy {
	private static final int OPTION_DELETE = 4;
	private static final int OPTION_ADD = 1;
	private static final int OPTION_VIEW = 2;
	private static final int OPTION_UPDATE= 3;
	private static final int OPTION_QUIT = 5;
		public static void main(String[] args) {

			ArrayList<Menu>menuList = new ArrayList<Menu>();
			ArrayList<Account> accountList = new ArrayList<Account>();
			ArrayList<Order>orderList = new ArrayList<Order>();
			
			menuList(new Menu("m301", "White Behoon, Ice Lemon Tea, Watermelon"));
			menuList(new Menu("m302", "Black Pepper Chicken Chop, Coke, Apple"));
			menuList(new Menu("m303", "Vegetarian Chicken Rice, fruit juice, papaya"));
			
			int option = 0;

			while (option != OPTION_QUIT) {

				C206_CaseStudy.menu();
				option = Helper.readInt("Enter an option > ");

				if (option == OPTION_VIEW) {
					// View all items
					C206_CaseStudy.viewAllMenu(menuList);
					C206_CaseStudy.viewAllAccount(accountList);
					C206_CaseStudy.viewAllOrder(orderList);

				} else if (option == OPTION_ADD) {
					// Add a new item
					C206_CaseStudy.setHeader("ADD");			
				}else if(option == OPTION_UPDATE) {
					
				}else if (option == OPTION_DELETE) {
					
				}
			}
		}

		private static void menuList(Menu menu) {
			// TODO Auto-generated method stub
			
			
			
		}
}	