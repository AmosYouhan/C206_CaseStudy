import java.util.ArrayList;

public class C206_CaseStudy {

		private static final int OPTION_ADD = 1;
		private static final int OPTION_VIEW = 2;
		private static final int OPTION_DELETE = 3;
		private static final int OPTION_QUIT = 4;
		public static void main(String[] args) {

			ArrayList<Menu>menuList = new ArrayList<Menu>();
			ArrayList<Account> accountList = new ArrayList<Account>();
			ArrayList<Order>orderList = new ArrayList<Order>();
			
			menuList.add(new Menu("Black Pepper Chicken Chop", "Coke", "Apples"));
			menuList.add(new Menu("Fried Bee Hoon", "Ice Lemon Tea", "Grapes");
			menuList.add(new Menu("Vegetarian Chicken Rice", "Fruit Juice", "Watermelon"));

			int option = 0;

			while (option != OPTION_QUIT) {

				 C206_CaseStudy.menuList();
				option = Helper.readInt("Enter an option > ");

				if (option == OPTION_VIEW) {
					// View all items
					 C206_CaseStudy.menuList(menuList);
					 C206_CaseStudy.Order(orderList);

				} else if (option == OPTION_ADD) {
					// Add a new item
					 C206_CaseStudy.setHeader("ADD");			
					itemTypeMenu();
					
					int menuItem = Helper.readInt("Enter option to select item type > ");

					if (menuItem == 1) {
						// Add a menu
						menu m = menuItem();
						 C206_CaseStudy.Menu(menuList, m);
						System.out.println("menu items added");

					} else if (itemType == 2) {
						// Add order
						order od = inputorder();
						 C206_CaseStudy.addChromebook(orderList, od);
						System.out.println("order added");

					} else {
						System.out.println("Invalid type");
					}

				} else if (option == OPTION_DELETE) {
					// Loan item
					C206_CaseStudy.setHeader("DELETE");			
					itemTypeMenu();
					
					int menuItem = Helper.readInt("Enter option to select item type > ");

					if (itemType == 1) {
						// Loan menu
						C206_CaseStudy.menu(menuList);
					} else if (itemType == 2) {
						// Loan order
						C206_CaseStudy.order(orderList);
					} else {
						System.out.println("Invalid type");
					}

				} else if (option == OPTION_QUIT) {
					System.out.println("Bye!");
				} else {
					System.out.println("Invalid option");
				}

			}

		}

		private static void orderList() {
			C206_CaseStudy.setHeader("Order List");
			System.out.println("1. First Choice");
			System.out.println("2. Second Choice");
			System.out.println("3. Third Choice");
			
		}

		public static void menuList() {
			C206_CaseStudy.setHeader("Menu List");
			System.out.println("1. Western Food");
			System.out.println("2. Asian Food");
			System.out.println("3. Vegetarian Food");
			System.out.println("4. Quit");
			Helper.line(80, "-");

		}
		
		public static void setHeader(String header) {
			Helper.line(80, "-");
			System.out.println(header);
			Helper.line(80, "-");
		}

		public static String showAvailability(boolean isAvailable) {
			String avail;

			if (isAvailable == true) {
				avail = "Yes";
			} else {
				avail = "No";
			}
			return avail;
		}

		//================================= Option 1 View (CRUD - Read) =================================
		public static String retrieveAllCamcorder(ArrayList<Camcorder> camcorderList) {
			String output = "";

			for (int i = 0; i < camcorderList.size(); i++) {

				output += String.format("%-84s \n", camcorderList.get(i).toString());
			}
			return output;
		}
		public static void viewAllCamcorder(ArrayList<Camcorder> camcorderList) {
			C206_CaseStudy.setHeader("CAMCORDER LIST");
			String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
					"AVAILABLE", "DUE DATE","OPTICAL ZOOM");
			 output += retrieveAllCamcorder(camcorderList);	
			System.out.println(output);
		}

		public static String retrieveAllChromebook(ArrayList<Chromebook> chromebookList) {
			String output = "";
			// write your code here
			for (int i = 0; i < chromebookList.size(); i++) {

				output += String.format("%-84s \n" , chromebookList.get(i).toString());
			}
			return output;
		}
		public static void viewAllChromebook(ArrayList<Chromebook> chromebookList) {
			
			C206_CaseStudy.setHeader("CHROMEBOOK LIST");
			String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
					 "AVAILABLE", "DUE DATE","OPERATING SYSTEM");
			 output += retrieveAllChromebook(chromebookList);
			System.out.println(output);
		}

		//================================= Option 2 Add (CRUD - Create)=================================
		public static Camcorder inputCamcorder() {
			String tag = Helper.readString("Enter asset tag > ");
			String description = Helper.readString("Enter description > ");
			int zoom = Helper.readInt("Enter optical zoom > ");

			Camcorder cc= new Camcorder(tag, description, zoom);
			return cc;
			
		}
		public static void addCamcorder(ArrayList<Camcorder> camcorderList, Camcorder cc) {
			
			camcorderList.add(cc);
			
		}
		
		public static Chromebook inputChromebook() {
			String tag = Helper.readString("Enter asset tag > ");
			String description = Helper.readString("Enter description > ");
			String os = Helper.readString("Enter operating system > ");

			Chromebook cb= new Chromebook(tag, description, os);
			return cb;
			
		}	
		public static void addChromebook(ArrayList<Chromebook> chromebookList, Chromebook cb) {

			chromebookList.add(cb);
			
		}
		
		//================================= Option 3 Loan (CURD- Update) =================================
		public static boolean doLoanCamcorder(ArrayList<Camcorder> camcorderList, String tag, String dueDate) {
			
			boolean isLoaned = false;

			for (int i = 0; i < camcorderList.size(); i++) {
				
				
				if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())				
						&& camcorderList.get(i).getIsAvailable() == true) {
					
					camcorderList.get(i).setIsAvailable(false);
					camcorderList.get(i).setDueDate(dueDate);
					
					isLoaned = true;
					
				}
			}
			return isLoaned;
		}

		public static void loanCamcorder(ArrayList<Camcorder> camcorderList) {
			C206_CaseStudy.viewAllCamcorder(camcorderList);
			String tag = Helper.readString("Enter asset tag > ");
			String due = Helper.readString("Enter due date > ");
			Boolean isLoaned =doLoanCamcorder(camcorderList, tag, due);
			if (isLoaned == false) {
				System.out.println("Invalid asset tag");
			} else {
				System.out.println("Camcorder " + tag + " loaned out");
			}
		}
		

		public static boolean doLoanChromebook(ArrayList<Chromebook> chromebookList, String tag, String dueDate) {
			// comments: write your code here
			boolean isLoaned = false;

			for (int i = 0; i < chromebookList.size(); i++) {

				if (tag.equalsIgnoreCase(chromebookList.get(i).getAssetTag())
						
						&& chromebookList.get(i).getIsAvailable() == true) {
					
					chromebookList.get(i).setIsAvailable(false);
					chromebookList.get(i).setDueDate(dueDate);
					
					isLoaned = true;
					
				}
			}
			return isLoaned;
		}

		public static void loanChromebook(ArrayList<Chromebook> chromebookList) {
			// write your code here
			C206_CaseStudy.viewAllChromebook(chromebookList);
			String tag = Helper.readString("Enter asset tag > ");
			String due = Helper.readString("Enter due date > ");
			Boolean isLoaned =doLoanChromebook(chromebookList, tag, due);
			if (isLoaned == false) {
				System.out.println("Invalid asset tag");
			} else {
				System.out.println("Chromebook " + tag + " loaned out");
			}	
			
		}
		//================================= Option 4 Return (CURD- Update)=================================
		public static boolean doReturnCamcorder(ArrayList<Camcorder> camcorderList,String tag) {
			boolean isReturned = false;

			for (int i = 0; i < camcorderList.size(); i++) {
				String assetTag = camcorderList.get(i).getAssetTag();
				if (tag.equalsIgnoreCase(assetTag)
						&& camcorderList.get(i).getIsAvailable() == false) {
					camcorderList.get(i).setIsAvailable(true);
					camcorderList.get(i).setDueDate("");
					isReturned = true;
					
				}
			}
			return isReturned;
			
		}

		public static void returnCamcorder(ArrayList<Camcorder> camcorderList) {
			C206_CaseStudy.viewAllCamcorder(camcorderList);
			String tag = Helper.readString("Enter asset tag > ");
			Boolean isReturned = doReturnCamcorder(camcorderList, tag);
			
			if (isReturned == false) {
				System.out.println("Invalid asset tag");
			} else {
				System.out.println("Camcorder " + tag + " returned");
			}
		}
		// write your doReturnChromebook code here
		public static boolean doReturnChromebook(ArrayList<Chromebook> chromebookList,String tag) {
			boolean isReturned = false;

			for (int i = 0; i < chromebookList.size(); i++) {
				String assetTag = chromebookList.get(i).getAssetTag();
				if (tag.equalsIgnoreCase(assetTag)
						&& chromebookList.get(i).getIsAvailable() == false) {
					chromebookList.get(i).setIsAvailable(true);
					chromebookList.get(i).setDueDate("");
					isReturned = true;
					
				}
			}
			return isReturned;
			
		}
		public static void returnChromebook(ArrayList<Chromebook> chromebookList) {
			// write your code here
			C206_CaseStudy.viewAllChromebook(chromebookList);
			String tag = Helper.readString("Enter asset tag > ");
			Boolean isReturned = doReturnChromebook(chromebookList, tag);
			
			if (isReturned == false) {
				System.out.println("Invalid asset tag");
			} else {
				System.out.println("Chromebook " + tag + " returned");
			}
		}
		
		public static void UpChromebook() {
			System.out.println("Hello");
		}


	}

