import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_testLBorder {

	private lunchboxOrderClass newOrder;
	private lunchboxOrderClass newOrder2;
	private lunchboxOrderClass newOrder3;
	
	
	private ArrayList<lunchboxOrderClass> LBorderList;
	
	
	public C206_testLBorder() {
		super();
	}
	
	@Before
	public void setUpBeforeClass() throws Exception {
		// prepare test data
		newOrder = new lunchboxOrderClass(1007, "2022-08-09", 3.50,"Vegetarian Bee Hoon, Apple Juice, Watermelon");
		newOrder2 = new lunchboxOrderClass(1008, "2022-08-10", 5.50,"Char Kway Teow, Coke, Papyaya");
		newOrder3 = new lunchboxOrderClass(1009, "2022-08-11", 4.50,"Fish & Chips, Ice Lemon Tea, Apple");
		
		LBorderList = new ArrayList<lunchboxOrderClass>();
		
	}
	
	@Test
	public void testAddOrder() {
		
		// lunch box order list is not null, so that can add a new item
		assertNotNull("Test if there is valid lunch box order arraylist to add to", LBorderList);
		
		//Given an empty list, after adding 1 lunch box order, the size of the list is 1
		C206_CaseStudy.newlyAddedLBOrder(LBorderList, newOrder);		
		assertEquals("Test if that lunch box order arraylist size is 1?", 1, LBorderList.size());
		
		//The lunch box order just added is as same as the first lunch box order of the list
		assertSame("Test that lunch box order is added same as 1st lunch box order of the list?", newOrder, LBorderList.get(0));
		
		//Add another lunch box order, test The size of the list is 2?
		C206_CaseStudy.newlyAddedLBOrder(LBorderList, newOrder2);
		C206_CaseStudy.newlyAddedLBOrder(LBorderList, newOrder3);
		assertEquals("Test that lunch box order arraylist size is 3?", 3, LBorderList.size());
		assertSame("Test that lunch box order is added same as 3rd lunch box order of the list?", newOrder3, LBorderList.get(2));
	}
	
	@Test
	public void testRetrieveAllLBorder() {
		// Test if lunch box order list is not null but empty, so that can add a new lunch box order
				assertNotNull("Test if there is valid order bill arraylist to add to", LBorderList);
				
				//test if the list of lunch box order retrieved from the CaseStudy is empty
				String allLBOrder= C206_CaseStudy.getLBOrderInfo(LBorderList);
				String testOutput = "";
				assertEquals("Check that lunch box order list", testOutput, allLBOrder);
						
				//Given an empty list, after adding lunch box order, test if the size of the list is 2
				C206_CaseStudy.newlyAddedLBOrder(LBorderList, newOrder);
				C206_CaseStudy.newlyAddedLBOrder(LBorderList, newOrder2);
				assertEquals("Test if that lunch box order arraylist size is 2?", 2, LBorderList.size());
				
				//test if the expected output string same as the list of lunch box order retrieved from the CaseStudy
				allLBOrder= C206_CaseStudy.getLBOrderInfo(LBorderList);

				testOutput = String.format("%-10d %-10s %-15s %-10s\n",1007, "2022-08-09", 3.50,"Vegetarian Bee Hoon, Apple Juice, Watermelon");
				testOutput += String.format("%-10d %-10s %-15s %-10s\n",1008, "2022-08-10", 5.50,"Char Kway Teow, Coke, Papyaya");
			
				assertEquals("Check that lunch box order list", testOutput, allLBOrder);
		
	}
	
	@Test
	
	public void testDeleteLBOrder() {
		// lunch box order list is not null, so that can delete a lunch box order
		assertNotNull("Test if there is valid lunch box order arraylist to add to", LBorderList);
				
		//Given an empty list, after adding 3 lunch box order, the size of the list is 3
		C206_CaseStudy.newlyAddedLBOrder(LBorderList, newOrder);	
		C206_CaseStudy.newlyAddedLBOrder(LBorderList, newOrder2);	
		C206_CaseStudy.newlyAddedLBOrder(LBorderList, newOrder3);	
		assertEquals("Test if that lunch box order arraylist size is 3?", 3, LBorderList.size());
				
		//The lunch box order just added is as same as the first lunch box order of the list
		assertSame("Test that lunch box order is added same as 1st lunch box order of the list?", newOrder, LBorderList.get(0));
				
		//Add another lunch box order, test The size of the list is 2?
		C206_CaseStudy.doDeleteLBorder(LBorderList,newOrder.getLBItems());
		assertEquals("Test that lunch box order arraylist size is 2?", 2, LBorderList.size());
		assertSame("Test that the second lunch box order now is the first lunch box order in the list?", newOrder2, LBorderList.get(0));
		assertSame("Test that the third lunch box order now is the second lunch box order in the list?", newOrder3, LBorderList.get(1));
		
	}

	
	
	
	
	@After
	public void tearDown() throws Exception {
		newOrder = null;
		newOrder2 = null;
		newOrder3 = null;
		LBorderList = null;
		

	}
	


		
		
		
		
		
	
	
}

