import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class C206_testAccount {
	
	private Account ac1;
	private Account ac2;
	private Account ac3;
	
	
	private ArrayList<Account> accountList;
	
	
	public C206_testAccount() {
		super();
	}
	
	@Before
	public void setUpBeforeClass() throws Exception {
		// prepare test data
		ac1 = new Account(1000, "alpha", "Jack", "Reacher");
		ac2 = new Account(1001, "beta", "John", "Wick");
		ac3 = new Account(1002, "charlie", "James", "Bond");
		
		accountList = new ArrayList<Account>();
		
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
	
	
	
	
	
	@After
	public void tearDown() throws Exception {
		ac1 = null;
		ac2 = null;
		ac3 = null;
		accountList = null;
		

	}
	
	
}

