import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;



public class C206_CaseStudyTest {
	
	// prepare test data
		private Account ac1;
		private Account ac2;
		private Account ac3;
		
		private menuClass mc1;
		private menuClass mc2;
		private menuClass mc3;
		
		private lunchboxOrderClass lb1;
		private lunchboxOrderClass lb2;
		private lunchboxOrderClass lb3;
		
		private orderClass newOrderBill;
		private orderClass newOrderBill2;
		private orderClass newOrderBill3;
		
		private createMenu cm1;
		private createMenu cm2;
		private createMenu cm3;
		
		private ArrayList<Account> accountList;
		private ArrayList<menuClass> menuItemList;
		private ArrayList<lunchboxOrderClass> lblist;
		private ArrayList<orderClass> orderBillList;
		private ArrayList<createMenu> monthlyList;
		
		
		public C206_CaseStudyTest() {
			super();
		}
		
		@Before
		public void setUp() throws Exception {
			// prepare test data
			ac1 = new Account(1000, "alpha", "Jack", "Reacher");
			ac2 = new Account(1001, "beta", "John", "Wick");
			ac3 = new Account(1002, "charlie", "James", "Bond");
			
			accountList = new ArrayList<Account>();
			
			mc1 = new menuClass(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", 3.50);
			mc2 = new menuClass(1008, "Char Kway Teow, Coke, Papaya", 4.00);
			mc3 = new menuClass(1009, "Fish & Chips, Ice Lemon Tea, Apple", 5.00);
			
			menuItemList = new ArrayList<menuClass>();
			
			lb1 = new lunchboxOrderClass(1007, "2022-08-09", 3.50,"Vegetarian Bee Hoon, Apple Juice, Watermelon");
			lb2 = new lunchboxOrderClass(1008, "2022-08-10", 5.50,"Char Kway Teow, Coke, Papyaya");
			lb3 = new lunchboxOrderClass(1009, "2022-08-11", 4.50,"Fish & Chips, Ice Lemon Tea, Apple");
			
			lblist = new ArrayList<lunchboxOrderClass>();
			
			newOrderBill = new orderClass(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", 3.50, "Processing");
			newOrderBill2 = new orderClass(1008, "Char Kway Teow, Coke, Papyaya", 4.00, "Processing");
			newOrderBill3 = new orderClass(1009, "Fish & Chips, Ice Lemon Tea, Apple", 5.00, "Processing");
			
			orderBillList = new ArrayList<orderClass>();
			
			cm1 = new createMenu(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", "Healthy", 3.50);
			cm2 = new createMenu(1008, "Char Kway Teow, Coke, Papyaya", "Refreshing", 4.00);
			cm3 = new createMenu(1009, "Fish & Chips, Ice Lemon Tea, Apple", "Premium", 5.00);
			
			monthlyList = new ArrayList<createMenu>();
			
		}

		@Test
		public void testAddAccount() {
			// Account list is not null, so that can add a new account
			assertNotNull("Test if there is valid account arraylist to add to", accountList);
			
			//Given an empty list, after adding 1 account, the size of the list is 1
			C206_CaseStudy.newlyAddedAccount(accountList, ac1);		
			assertEquals("Test if that account arraylist size is 1?", 1, accountList.size());
			
			//The account just added is as same as the first account of the list
			assertSame("Test that account is added same as 1st account of the list?", ac1, accountList.get(0));
			
			//Add another account, test The size of the list is 2?
			C206_CaseStudy.newlyAddedAccount(accountList, ac2);
			C206_CaseStudy.newlyAddedAccount(accountList, ac3);
			assertEquals("Test that account arraylist size is 3?", 3, accountList.size());
			assertSame("Test that account is added same as 3rd account of the list?", ac3, accountList.get(2));
		}
		
		@Test
		public void testRetrieveAllAccount() {
			// Test if account list is not null but empty, so that can add a new account
					assertNotNull("Test if there is valid account arraylist to add to", accountList);
					
					//test if the list of account retrieved from the CaseStudy is empty
					String allAccount= C206_CaseStudy.getAccountInfo(accountList);
					String testOutput = "";
					assertEquals("Check that account list", testOutput, allAccount);
							
					//Given an empty list, after adding 2 account, test if the size of the list is 2
					C206_CaseStudy.newlyAddedAccount(accountList, ac1);
					C206_CaseStudy.newlyAddedAccount(accountList, ac2);
					assertEquals("Test if that account arraylist size is 2?", 2, accountList.size());
					
					//test if the expected output string same as the list of account retrieved from the CaseStudy
					allAccount= C206_CaseStudy.getAccountInfo(accountList);

					testOutput = String.format("%-15s %-20s %-20s %-15s\n",1000, "alpha", "Jack", "Reacher");
					testOutput += String.format("%-15s %-20s %-20s %-15s\n",1001, "beta", "John", "Wick");
					
				
					assertEquals("Check that account list", testOutput, allAccount);
			
		}
		
		@Test
		
		public void testDeleteAccount() {
			// account list is not null, so that can delete a account
			assertNotNull("Test if there is valid account arraylist to add to", accountList);
					
			//Given an empty list, after adding 3 account, the size of the list is 3
			C206_CaseStudy.newlyAddedAccount(accountList, ac1);	
			C206_CaseStudy.newlyAddedAccount(accountList, ac2);	
			C206_CaseStudy.newlyAddedAccount(accountList, ac3);	
			assertEquals("Test if that account arraylist size is 3?", 3, accountList.size());
					
			//The account just added is as same as the first account of the list
			assertSame("Test that account is added same as 1st account of the list?", ac1, accountList.get(0));
					
			//Given that the size of the list is now 3, want to delete one of it to revert back list size to 2
			C206_CaseStudy.doDeleteAccount(accountList,ac1.getPassword());
			assertEquals("Test that account arraylist size is 2?", 2, accountList.size());
			assertSame("Test that the second account now is the first account in the list?", ac2, accountList.get(0));
			assertSame("Test that the third account now is the second account in the list?", ac3, accountList.get(1));
			
		}
		
		@Test
		public void testAddMenuItem() {
			// Menu Item list is not null, so that can add a new menu item
			assertNotNull("Test if there is valid menu item arraylist to add to", menuItemList);
			
			//Given an empty list, after adding 1 Menu Item, the size of the list is 1
			C206_CaseStudy.newlyAddedMenu(menuItemList, mc1);		
			assertEquals("Test if that menu item arraylist size is 1?", 1, menuItemList.size());
			
			//The menu item just added is as same as the first menu item of the list
			assertSame("Test that menu item is added same as 1st menu item of the list?", mc1, menuItemList.get(0));
			
			//Add another menu item, test The size of the list is 2?
			C206_CaseStudy.newlyAddedMenu(menuItemList, mc2);
			C206_CaseStudy.newlyAddedMenu(menuItemList, mc3);
			assertEquals("Test that menu item arraylist size is 3?", 3, menuItemList.size());
			assertSame("Test that menu item is added same as 3rd menu item of the list?", mc3, menuItemList.get(2));
		}
		
		@Test
		public void testRetrieveAllMenuItem() {
			// Test if menu item list is not null but empty, so that can add a new menu item
					assertNotNull("Test if there is valid menu item arraylist to add to", menuItemList);
					
					//test if the list of menu item retrieved from the CaseStudy is empty
					String allMenuItem= C206_CaseStudy.getMenuInfo(menuItemList);
					String testOutput = "";
					assertEquals("Check that menu item list", testOutput, allMenuItem);
							
					//Given an empty list, after adding 2 menu item, test if the size of the list is 2
					C206_CaseStudy.newlyAddedMenu(menuItemList, mc1);
					C206_CaseStudy.newlyAddedMenu(menuItemList, mc2);
					assertEquals("Test if that menu item arraylist size is 2?", 2, menuItemList.size());
					
					//test if the expected output string same as the list of menu item retrieved from the CaseStudy
					allMenuItem= C206_CaseStudy.getMenuInfo(menuItemList);

					testOutput = String.format("%-15s %-50s %-15s\n",1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", 3.50);
					testOutput += String.format("%-15s %-50s %-15s\n",1008, "Char Kway Teow, Coke, Papaya", 4.00);
					
				
					assertEquals("Check that menu item list", testOutput, allMenuItem);
			
		}
		
		
		
		@Test
		
		public void testDeleteMenuItem() {
			// Menu Item list is not null, so that can delete a menu item
			assertNotNull("Test if there is valid menu item arraylist to add to", menuItemList);
					
			//Given an empty list, after adding 3 menu item, the size of the list is 3
			C206_CaseStudy.newlyAddedMenu(menuItemList, mc1);	
			C206_CaseStudy.newlyAddedMenu(menuItemList, mc2);	
			C206_CaseStudy.newlyAddedMenu(menuItemList, mc3);	
			assertEquals("Test if that menu item arraylist size is 3?", 3, menuItemList.size());
					
			//The menu item just added is as same as the first menu item of the list
			assertSame("Test that menu item is added same as 1st menu item of the list?", mc1, menuItemList.get(0));
					
			//Given that the size of the list is now 3, want to delete one of it to revert back list size to 2
			C206_CaseStudy.doDeleteMenuItem(menuItemList,mc1.getMenuItem());
			assertEquals("Test that menu item arraylist size is 2?", 2, menuItemList.size());
			assertSame("Test that the second menu item now is the first menu item in the list?", mc2, menuItemList.get(0));
			assertSame("Test that the third menu item now is the second menu item in the list?", mc3, menuItemList.get(1));
			
		}
		
		@Test
		public void testAddLB() {
			// LB Order list is not null, so that can add a LB order
			assertNotNull("Test if there is valid LB order arraylist to add to", lblist);
			
			//Given an empty list, after adding 1 LB order , the size of the list is 1
			C206_CaseStudy.newlyAddedLBOrder(lblist, lb1);		
			assertEquals("Test if that lb order arraylist size is 1?", 1, lblist.size());
			
			//The LB order just added is as same as the first LB order of the list
			assertSame("Test that lb order is added same as 1st lb order of the list?", lb1, lblist.get(0));
			
			//Add another LB order, test The size of the list is 2?
			C206_CaseStudy.newlyAddedLBOrder(lblist, lb2);
			C206_CaseStudy.newlyAddedLBOrder(lblist, lb3);
			assertEquals("Test that lb order arraylist size is 3?", 3, lblist.size());
			assertSame("Test that lb order is added same as 3rd lb order of the list?", lb3, lblist.get(2));
		}
		
		@Test
		public void testRetrieveAllLBOrder() {
					// Test if LB order list is not null but empty, so that can add a LB order
					assertNotNull("Test if there is valid LB order arraylist to add to", lblist);
					
					//test if the list of LB order retrieved from the CaseStudy is empty
					String allMonthlyMenu= C206_CaseStudy.getLBOrder(lblist);
					String testOutput = "";
					assertEquals("Check that lb order list", testOutput, allMonthlyMenu);
							
					//Given an empty list, after adding 2 LB order, test if the size of the list is 2
					C206_CaseStudy.newlyAddedLBOrder(lblist, lb1);
					C206_CaseStudy.newlyAddedLBOrder(lblist, lb2);
					assertEquals("Test if that lb order arraylist size is 2?", 2, lblist.size());
					
					//test if the expected output string same as the list of LB order retrieved from the CaseStudy
					allMonthlyMenu= C206_CaseStudy.getLBOrder(lblist);

					testOutput = String.format("%-10d %-10s %-15s %-10s\n",1007, "2022-08-09", 3.50,"Vegetarian Bee Hoon, Apple Juice, Watermelon");
					testOutput += String.format("%-10d %-10s %-15s %-10s\n",1008, "2022-08-10", 5.50,"Char Kway Teow, Coke, Papyaya");
					
				
					assertEquals("Check that lb order list", testOutput, allMonthlyMenu);
			
		}
		
		@Test
		
		public void testDeleteLB() {
			// LB order list is not null, so that can delete a LB order
			assertNotNull("Test if there is valid LB order arraylist to add to", lblist);
					
			//Given an empty list, after adding 3 LB order, the size of the list is 3
			C206_CaseStudy.newlyAddedLBOrder(lblist, lb1);	
			C206_CaseStudy.newlyAddedLBOrder(lblist, lb2);	
			C206_CaseStudy.newlyAddedLBOrder(lblist, lb3);	
			assertEquals("Test if that lb order arraylist size is 3?", 3, lblist.size());
					
			//The LB order just added is as same as the first LB order of the list
			assertSame("Test that lb order is added same as 1st lb order of the list?", lb1, lblist.get(0));
					
			//Given that the size of the list is now 3, want to delete one of it to revert back list size to 2
			C206_CaseStudy.doDeleteLBorder(lblist,lb1.getLBItems());
			assertEquals("Test that lb order arraylist size is 2?", 2, lblist.size());
			assertSame("Test that the second lb order now is the first lb order in the list?", lb2, lblist.get(0));
			assertSame("Test that the third lb order now is the second lb order in the list?", lb3, lblist.get(1));
			
		}
			
		@Test
		public void testAddOrderBill() {
			// OrderBill list is not null, so that can add a new item
			assertNotNull("Test if there is valid order bill arraylist to add to", orderBillList);
			
			//Given an empty list, after adding 1 order Bill, the size of the list is 1
			C206_CaseStudy.newlyAddedBill(orderBillList, newOrderBill);		
			assertEquals("Test if that order bill arraylist size is 1?", 1, orderBillList.size());
			
			//The order Bill just added is as same as the first order Bill of the list
			assertSame("Test that order bill is added same as 1st order bill of the list?", newOrderBill, orderBillList.get(0));
			
			//Add another order Bill, test The size of the list is 2?
			C206_CaseStudy.newlyAddedBill(orderBillList, newOrderBill2);
			C206_CaseStudy.newlyAddedBill(orderBillList, newOrderBill3);
			assertEquals("Test that order bill arraylist size is 3?", 3, orderBillList.size());
			assertSame("Test that order bill is added same as 3rd order bill of the list?", newOrderBill3, orderBillList.get(2));
		}
		
		@Test
		public void testRetrieveAllOrderBill() {
			// Test if order bill list is not null but empty, so that can add a new order bill
					assertNotNull("Test if there is valid order bill arraylist to add to", orderBillList);
					
					//test if the list of order bill retrieved from the CaseStudy is empty
					String allOrderBill= C206_CaseStudy.getOrderInfo(orderBillList);
					String testOutput = "";
					assertEquals("Check that order bill list", testOutput, allOrderBill);
							
					//Given an empty list, after adding 2 order bill, test if the size of the list is 2
					C206_CaseStudy.newlyAddedBill(orderBillList, newOrderBill);
					C206_CaseStudy.newlyAddedBill(orderBillList, newOrderBill2);
					assertEquals("Test if that order bill arraylist size is 2?", 2, orderBillList.size());
					
					//test if the expected output string same as the list of order bill retrieved from the CaseStudy
					allOrderBill= C206_CaseStudy.getOrderInfo(orderBillList);

					testOutput = String.format("%-15s %-50s %-50s %-15s\n",1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", 3.50, "Processing");
					testOutput += String.format("%-15s %-50s %-50s %-15s\n",1008, "Char Kway Teow, Coke, Papyaya", 4.00, "Processing");
				
					assertEquals("Check that order bill list", testOutput, allOrderBill);
			
		}
		
		@Test
		
		public void testDeleteOrderBill() {
			// OrderBill list is not null, so that can delete a order bill
			assertNotNull("Test if there is valid order bill arraylist to add to", orderBillList);
					
			//Given an empty list, after adding 3 order Bill, the size of the list is 3
			C206_CaseStudy.newlyAddedBill(orderBillList, newOrderBill);	
			C206_CaseStudy.newlyAddedBill(orderBillList, newOrderBill2);	
			C206_CaseStudy.newlyAddedBill(orderBillList, newOrderBill3);	
			assertEquals("Test if that order bill arraylist size is 3?", 3, orderBillList.size());
					
			//The order Bill just added is as same as the first order Bill of the list
			assertSame("Test that order bill is added same as 1st order bill of the list?", newOrderBill, orderBillList.get(0));
					
			//Given that the size of the list is now 3, want to delete one of it to revert back list size to 2
			C206_CaseStudy.doDeleteOrderBill(orderBillList,newOrderBill.getOrderItem());
			assertEquals("Test that order bill arraylist size is 2?", 2, orderBillList.size());
			assertSame("Test that the second order bill now is the first order bill in the list?", newOrderBill2, orderBillList.get(0));
			assertSame("Test that the third order bill now is the second order bill in the list?", newOrderBill3, orderBillList.get(1));
			
		}
		
		
		@Test
		public void testAddMonthlyMenu() {
			// Monthly Menu list is not null, so that can add a monthly menu
			assertNotNull("Test if there is valid monthly menu arraylist to add to", monthlyList);
			
			//Given an empty list, after adding 1 monthly menu, the size of the list is 1
			C206_CaseStudy.newlyMonthlyMenu(monthlyList, cm1);		
			assertEquals("Test if that account arraylist size is 1?", 1, monthlyList.size());
			
			//The monthly menu just added is as same as the first monthly menu of the list
			assertSame("Test that monthly menu is added same as 1st monthly menu of the list?", cm1, monthlyList.get(0));
			
			//Add another monthly menu, test The size of the list is 2?
			C206_CaseStudy.newlyMonthlyMenu(monthlyList, cm2);
			C206_CaseStudy.newlyMonthlyMenu(monthlyList, cm3);
			assertEquals("Test that monthly menu arraylist size is 3?", 3, monthlyList.size());
			assertSame("Test that monthly menu is added same as 3rd monthly menu of the list?", cm3, monthlyList.get(2));
		}
		
		@Test
		public void testRetrieveAllMonthlyMenu() {
					// Test if monthly menu list is not null but empty, so that can add a monthly menu
					assertNotNull("Test if there is valid monthly menu arraylist to add to", monthlyList);
					
					//test if the list of monthly menu retrieved from the CaseStudy is empty
					String allMonthlyMenu= C206_CaseStudy.getMonthly(monthlyList);
					String testOutput = "";
					assertEquals("Check that monthly menu list", testOutput, allMonthlyMenu);
							
					//Given an empty list, after adding 2 monthly menu, test if the size of the list is 2
					C206_CaseStudy.newlyMonthlyMenu(monthlyList, cm1);
					C206_CaseStudy.newlyMonthlyMenu(monthlyList, cm2);
					assertEquals("Test if that monthly menu arraylist size is 2?", 2, monthlyList.size());
					
					//test if the expected output string same as the list of monthly menu retrieved from the CaseStudy
					allMonthlyMenu= C206_CaseStudy.getMonthly(monthlyList);

					testOutput = String.format("%-15s %-50s %-50s %-15s\n",1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", "Healthy", 3.50);
					testOutput += String.format("%-15s %-50s %-50s %-15s\n",1008, "Char Kway Teow, Coke, Papyaya", "Refreshing", 4.00);
					
				
					assertEquals("Check that monthly menu list", testOutput, allMonthlyMenu);
			
		}
		
		@Test
		
		public void testDeleteMonthlyMenu() {
			// monthly menu list is not null, so that can delete a monthly menu
			assertNotNull("Test if there is valid monthly menu arraylist to add to", monthlyList);
					
			//Given an empty list, after adding 3 monthly menu, the size of the list is 3
			C206_CaseStudy.newlyMonthlyMenu(monthlyList, cm1);	
			C206_CaseStudy.newlyMonthlyMenu(monthlyList, cm2);	
			C206_CaseStudy.newlyMonthlyMenu(monthlyList, cm3);	
			assertEquals("Test if that monthly menu arraylist size is 3?", 3, monthlyList.size());
					
			//The monthly menu just added is as same as the first monthly menu of the list
			assertSame("Test that monthly menu is added same as 1st monthly menu of the list?", cm1, monthlyList.get(0));
					
			//Given that the size of the list is now 3, want to delete one of it to revert back list size to 2
			C206_CaseStudy.doDeleteMonthlyMenu(monthlyList,cm1.getMenuItems());
			assertEquals("Test that monthly menu arraylist size is 2?", 2, monthlyList.size());
			assertSame("Test that the second monthly menu now is the first monthly menu in the list?", cm2, monthlyList.get(0));
			assertSame("Test that the third monthly menu now is the second monthly menu in the list?", cm3, monthlyList.get(1));
			
		}
		
		
		@After
		public void tearDown() throws Exception {
			ac1 = null;
			ac2 = null;
			ac3 = null;
			accountList = null;
			
			mc1 = null;
			mc2 = null;
			mc3 = null;
			menuItemList = null;
			
			lb1 = null;
			lb2 = null;
			lb3 = null;
			lblist = null;
			
			newOrderBill = null;
			newOrderBill2 = null;
			newOrderBill3 = null;
			orderBillList = null;
			
			cm1 = null;
			cm2 = null;
			cm3 = null;
			monthlyList = null;

		}

}

