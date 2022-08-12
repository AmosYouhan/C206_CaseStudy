import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class C206_testLBorder {
	
	private lunchboxOrderClass lb1;
	private lunchboxOrderClass lb2;
	private lunchboxOrderClass lb3;
	
	
	private ArrayList<lunchboxOrderClass> lblist;
	
	
	public C206_testLBorder() {
		super();
	}
	
	@Before
	public void setUpBeforeClass() throws Exception {
		// prepare test data
		lb1 = new lunchboxOrderClass(1007, "2022-08-09", 3.50,"Vegetarian Bee Hoon, Apple Juice, Watermelon");
		lb2 = new lunchboxOrderClass(1008, "2022-08-10", 5.50,"Char Kway Teow, Coke, Papyaya");
		lb3 = new lunchboxOrderClass(1009, "2022-08-11", 4.50,"Fish & Chips, Ice Lemon Tea, Apple");
		
		lblist = new ArrayList<lunchboxOrderClass>();
		
	}
	
	@Test
	public void testAddLB() {
		// LB Order list is not null, so that can add a LB order
		assertNotNull("Test if there is valid monthly menu arraylist to add to", lblist);
		
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
				assertNotNull("Test if there is valid monthly menu arraylist to add to", lblist);
				
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
		assertNotNull("Test if there is valid monthly menu arraylist to add to", lblist);
				
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
	
	
	
	
	
	@After
	public void tearDown() throws Exception {
		lb1 = null;
		lb2 = null;
		lb3 = null;
		lblist = null;
		

	}
	
	
}