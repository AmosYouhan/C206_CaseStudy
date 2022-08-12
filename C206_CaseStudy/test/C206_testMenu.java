import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class C206_testMenu {
	
	private menuClass mc1;
	private menuClass mc2;
	private menuClass mc3;
	
	
	private ArrayList<menuClass> menuItemList;
	
	
	public C206_testMenu() {
		super();
	}
	
	@Before
	public void setUpBeforeClass() throws Exception {
		// prepare test data
		mc1 = new menuClass(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", 3.50);
		mc2 = new menuClass(1008, "Char Kway Teow, Coke, Papaya", 4.00);
		mc3 = new menuClass(1009, "Fish & Chips, Ice Lemon Tea, Apple", 5.00);
		
		menuItemList = new ArrayList<menuClass>();
		
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
	
	public void testDeleteOrderBill() {
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
	
	
	
	
	
	@After
	public void tearDown() throws Exception {
		mc1 = null;
		mc2 = null;
		mc3 = null;
		menuItemList = null;
		

	}
	
	
}
