import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;



public class C206_CaseStudyTest {
	
	// prepare test data
		private orderClass newOrderBill;
		
		
		private ArrayList<orderClass> orderBillList;
		
		
		public C206_CaseStudyTest() {
			super();
		}
		
		@Before
		public void setUp() throws Exception {
			// prepare test data
			newOrderBill = new orderClass(1007, "Vegetarian Bee Hoon", 3.50, "Processing")
			
			
			
			orderBillList = new ArrayList<orderClass>();
			
		}

		
		@Test
		public void testAddCamcorder() {
			// Item list is not null, so that can add a new item
			assertNotNull("Test if there is valid orderBill arraylist to add to", orderBillList);
			
			//Given an empty list, after adding 1 item, the size of the list is 1
			C206_CaseStudy.newlyAddedBill(orderBillList, newOrderBill);		
			assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
			
			//The item just added is as same as the first item of the list
			assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
			
			//Add another item. test The size of the list is 2?
			ResourceCentre.addCamcorder(camcorderList, cc2);
			ResourceCentre.addCamcorder(camcorderList, cc3);
			assertEquals("Test that Camcorder arraylist size is 3?", 3, camcorderList.size());
			assertSame("Test that Camcorder is added same as 3rd item of the list?", cc3, camcorderList.get(2));
		}
		@Test
		public void testAddChromebook() {
			//fail("Not yet implemented");
			// write your code here 
			assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
			
			//Given an empty list, after adding 1 item, the size of the list is 1
			ResourceCentre.addChromebook(chromebookList, cb1);
			assertEquals("Test that Chromebook arraylist size is 1?", 1, chromebookList.size());
			
			//Item added same as first item of the list
			assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));
			
			//Add another item, test the size of the list is 2
			ResourceCentre.addChromebook(chromebookList,cb2);
			ResourceCentre.addChromebook(chromebookList, cb3);
			assertEquals("Test that Chromebook arraylist size is 3?", 3, chromebookList.size());
			assertSame("Test that Chromebook is added same as 3rd item of the list?", cb3, chromebookList.get(2));
		}
		
		@Test
		public void testRetrieveAllCamcorder() {
			// Test if Item list is not null but empty, so that can add a new item
			assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
			
			//test if the list of camcorders retrieved from the SourceCentre is empty
			String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
			String testOutput = "";
			assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
					
			//Given an empty list, after adding 2 items, test if the size of the list is 2
			ResourceCentre.addCamcorder(camcorderList, cc1);
			ResourceCentre.addCamcorder(camcorderList, cc2);
			assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
			
			//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
			allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

			testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
			testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
		
			assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
			
		}
		@Test
		public void testRetrieveAllChromebook() {
			//fail("Not yet implemented");
			// write your code here
			//Check if the list is not null but empty, and afterwhich can add new item
			assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
			
			//test if Chromebook list retrieved from the SourceCentre is empty
			String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
			String testOutput = "";
			assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
			
			//Test if size of list is 2 after adding 2 items
			ResourceCentre.addChromebook(chromebookList, cb1);
			ResourceCentre.addChromebook(chromebookList, cb2);
			assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
			
			//test if expected output same as chromebook list
			
			allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
			
			testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n", "CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
			testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n", "CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
			
			assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
			
		}

		@Test
		public void testDoLoanCamcorder() {

			//boundary
			assertNotNull("test if there is valid Camcorder arraylist to loan from", camcorderList);
			
			ResourceCentre.addCamcorder(camcorderList, cc1);
			
			// normal
			Boolean ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "8-8-2020" );
			assertTrue("Test if an available item is ok to loan?", ok);
			assertFalse(camcorderList.get(0).getIsAvailable());
			assertEquals(camcorderList.get(0).getDueDate(),"8-8-2020");
			
					
			//error condition
			ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "8-8-2020" );
			assertFalse("Test if an same item is NOT ok to loan again?", ok);	
			
			//error condition
			ResourceCentre.addCamcorder(camcorderList, cc2);	
			cc2.setIsAvailable(false);
			ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0012", "8-8-2020" );
			assertFalse("Test that un-available item is NOT ok to loan?", ok);
			
			//error condition
			ok = ResourceCentre.doLoanCamcorder(camcorderList, "CC0013", "8-8-2020" );
			assertFalse("Test that non-esiting item is NOT ok to loan?", ok);


		}
		
		@Test
		public void testDoLoanChromebook() {
			//fail("Not yet implemented");
			// write your code here
			
			//boundary
			assertNotNull("Test if there is valid Chromebook arraylist to loan from", chromebookList);
			
			ResourceCentre.addChromebook(chromebookList, cb1);
			
			//normal
			Boolean ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020");
			assertTrue("Test if an available item is ok to loan?", ok);
			assertFalse(chromebookList.get(0).getIsAvailable());
			assertEquals(chromebookList.get(0).getDueDate(), "8-8-2020");
			
			//error condition
			ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020");
			assertFalse("Test if an same item is NOT ok to loan again?", ok);
			
			//error condition
			ResourceCentre.addChromebook(chromebookList, cb2);
			cb2.setIsAvailable(false);
			ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0012", "8-8-2020");
			assertFalse("Test that unavailable item is NOT ok to loan?", ok);
			
			//error condition
			ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0013", "8-8-2020");
			assertFalse("Test that non existing item is NOT ok to loan?", ok);
		}
		
		@Test
		public void testDoReturnCamcorder() {
			//boundary
			assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
			ResourceCentre.addCamcorder(camcorderList, cc1);
			//error
			Boolean isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
			assertFalse("Test if available camcorder CC0011 is returned -false?", isReturned);		
			//normal
			ResourceCentre.addCamcorder(camcorderList, cc2);
			cc2.setIsAvailable(false);
			isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0012");
			assertTrue("Test if loaned out amcorder CC0012 is returned- true", isReturned);
			//error
			isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0013");
			assertFalse("Test if non-existing amcorder CC0013 is returned - false?", isReturned);
			
		}
		@Test
		public void testDoReturnChromebook() {
			//fail("Not yet implemented");
			// write your code here
			
					//boundary
					assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
					ResourceCentre.addChromebook(chromebookList, cb1);
					//error
					Boolean isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
					assertFalse("Test if available Chromebook CB0011 is returned -false?", isReturned);		
					//normal
					ResourceCentre.addChromebook(chromebookList, cb2);
					cb2.setIsAvailable(false);
					isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0012");
					assertTrue("Test if loaned out Chromebook CB0012 is returned- true", isReturned);
					//error
					isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0013");
					assertFalse("Test if non-existing Chromebook CB0013 is returned - false?", isReturned);
			
			
		}
		
		
		@After
		public void tearDown() throws Exception {
			cc1 = null;
			cc2 = null;
			cb1 = null;
			cb2 = null;
			camcorderList = null;
			chromebookList = null;

		}

}

