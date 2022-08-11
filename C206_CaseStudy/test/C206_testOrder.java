import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class C206_testOrder {
	
	private orderClass newOrderBill;
	private orderClass newOrderBill2;
	private orderClass newOrderBill3;
	
	
	private ArrayList<orderClass> orderBillList;
	
	
	public C206_testOrder() {
		super();
	}
	
	@Before
	public void setUpBeforeClass() throws Exception {
		// prepare test data
		newOrderBill = new orderClass(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", 3.50, "Processing");
		newOrderBill2 = new orderClass(1008, "Char Kway Teow, Coke, Papyaya", 4.00, "Processing");
		newOrderBill3 = new orderClass(1009, "Fish & Chips, Ice Lemon Tea, Apple", 5.00, "Processing");
		
		orderBillList = new ArrayList<orderClass>();
		
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
				assertNotNull("Test if there is valid Camcorder arraylist to add to", orderBillList);
				
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
				
		//Add another order Bill, test The size of the list is 2?
		C206_CaseStudy.doDeleteOrderBill(orderBillList,newOrderBill.getOrderItem());
		assertEquals("Test that order bill arraylist size is 2?", 2, orderBillList.size());
		assertSame("Test that the second order bill now is the first order bill in the list?", newOrderBill2, orderBillList.get(0));
		assertSame("Test that the third order bill now is the second order bill in the list?", newOrderBill3, orderBillList.get(1));
		
	}
	
	
	
	
	
	@After
	public void tearDown() throws Exception {
		newOrderBill = null;
		newOrderBill2 = null;
		newOrderBill3 = null;
		orderBillList = null;
		

	}
	


		
		
		
		
		
	
	
}
