import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C206_testMenu {
		
		private menuClass mc1;
		private menuClass mc2;
		private menuClass mc3;
	
		private ArrayList<menuClass> menuList;
		
		public C206_testMenu() {
			super();
		}
		
		@Before
		public void setUp() throws Exception {
			// prepare test data
			mc1 = new menuClass(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", 3.50);
		    mc2 = new menuClass(1008, "Char Kway Teow, Coke, Papyaya", 4.00);
		    mc3 = new menuClass(1009, "Fish & Chips, Ice Lemon Tea, Apple", 5.00);
		    
		    menuList = new ArrayList<menuClass>();
		    
		}
		
		@Test
		public void testCreateMenuItems() {
			// OrderBill list is not null, so that can add a new item
			assertNotNull("Test if there is valid menu arraylist to add to", menuList);
			
			//Given an empty list, after adding 1 order Bill, the size of the list is 1
			C206_testMenu.newlyAddedMenu(menuList, mc1);		
			assertEquals("Test if that menu arraylist size is 1?", 1, menuList.size());
			
			//The order Bill just added is as same as the first order Bill of the list
			assertSame("Test that menu bill is added same as 1st order bill of the list?", mc1, menuList.get(0));
			
			//Add another order Bill, test The size of the list is 2?
			C206_testMenu.newlyAddedMenu(menuList, mc2);
			C206_testMenu.newlyAddedMenu(menuList, mc3);
			assertEquals("Test that menu arraylist size is 3?", 3, menuList.size());
			assertSame("Test that menu is added same as 3rd menu of the list?", mc3, menuList.get(2));
		}

		@Test
		public void testRetrieveAllMenuItems() {
			// Test if order bill list is not null but empty, so that can add a new order bill
			assertNotNull("Test if there is valid menu arraylist to add to", menuList);
			
			//test if the list of order bill retrieved from the CaseStudy is empty
			String allMenuItems= C206_testMenu.getMenuInfo(menuList);
			String testOutput = "";
			assertEquals("Check that order menu list", testOutput, addMenuItems);
					
			//Given an empty list, after adding 2 order bill, test if the size of the list is 2
			C206_testMenu.newlyAddedMenu(menuList, mc1);
			C206_testMenu.newlyAddedMenu(menuList, mc2);menuList.size();
			
			//test if the expected output string same as the list of order bill retrieved from the CaseStudy
			allMenuItems= C206_testMenu.getMenuInfo(menuList);

			testOutput = String.format("%-15s %-50s %-50s %-15s\n",1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", 3.50);
			testOutput += String.format("%-15s %-50s %-50s %-15s\n",1008, "Char Kway Teow, Coke, Papyaya", 4.00);
		
			assertEquals("Check that menu list", testOutput, allMenuItems);

		}
		
		@Test
		public void testDeleteOrderBill() {
			// OrderBill list is not null, so that can delete a order bill
			assertNotNull("Test if there is valid menu arraylist to add to", menuList);
					
			//Given an empty list, after adding 3 order Bill, the size of the list is 3
			C206_testMenu.newlyAddedMenu(menuList, mc1;	
			C206_testMenu.newlyAddeMenu(menuList, mc2);	
			C206_testMenu.newlyAddedMenu(menuList, mc3);	
			assertEquals("Test if that menu arraylist size is 3?", 3, menuList.size());
					
			//The order Bill just added is as same as the first order Bill of the list
			assertSame("Test that order bill is added same as 1st order bill of the list?", newMenuItems, menuList.get(0));
					
			//Add another order Bill, test The size of the list is 2?
			C206_testMenu.doDeleteMenuItems(menuList,menuItems.getMenuItem());
			assertEquals("Test that order bill arraylist size is 2?", 2, menuList.size());
			assertSame("Test that the second menu list now is the first order bill in the list?", mc2, menuList.get(0));
			assertSame("Test that the third menu listnow is the second order bill in the list?", mc3, menuList.get(1));
			
		}
		
		@After
		public void tearDown() throws Exception {
			mc1 = null;
			mc2 = null;
			mc3 = null;
			menuList = null;
		}
}
