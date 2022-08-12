import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class C206_testMonthlyMenu {
	
	private createMenu cm1;
	private createMenu cm2;
	private createMenu cm3;
	
	
	private ArrayList<createMenu> monthlyList;
	
	
	public C206_testMonthlyMenu() {
		super();
	}
	
	@Before
	public void setUpBeforeClass() throws Exception {
		// prepare test data
		cm1 = new createMenu(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", "Healthy", 3.50);
		cm2 = new createMenu(1008, "Char Kway Teow, Coke, Papyaya", "Refreshing", 4.00);
		cm3 = new createMenu(1009, "Fish & Chips, Ice Lemon Tea, Apple", "Premium", 5.00);
		
		monthlyList = new ArrayList<createMenu>();
		
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
		cm1 = null;
		cm2 = null;
		cm3 = null;
		monthlyList = null;
		

	}
	
	
}