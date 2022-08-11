import java.util.ArrayList;

public class AccountClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Account> newAccount = new ArrayList<Account>();
	    
	    newAccount.add(new Account(1000, "alpha", "Jack", "Reacher"));
	    newAccount.add(new Account(1001, "beta", "John", "Wick"));
	    newAccount.add(new Account(1002, "charlie", "James", "Bond"));
	    
	    int option = 0;
	    
	    while (option != 4) {
	    	Helper.line(50, "=");
		    System.out.println("Account");
			System.out.println("1. Add Account");
			System.out.println("2. View Accounts");
			System.out.println("3. Delete Account");
			System.out.println("4. Quit");
			Helper.line(50, "=");
		    option = Helper.readInt("Enter option number from the account menu: ");
	      
	      if(option == 1) {
	    	  
	    	  int accountApplicable = Helper.readInt("Enter Account ID check whether it is applicable: ");
				for(int i = 0; i<newAccount.size(); i++) {
					
					if(newAccount.get(i).getAccId() == accountApplicable) {
						System.out.println("Account ID already exists");
						
					}else {
						Account newAccountUser = createAccount();
						AccountClass.newlyAddedAccount(newAccount,newAccountUser);
						System.out.println("Created new Account");
						break;
					}
				}
	      }
	      	else if(option == 2) {
	  			
	    	  AccountClass.viewAccount(newAccount);
				
	      	}
			else if(option == 3) {
				AccountClass.deleteAccount(newAccount);
			
				
			}else if(option == 4) {
				System.out.println("Thank you for your time!");
			}
		  else {
				System.out.println("The number you entered is invalid");
			}
	    }

	  }
	 
	  
	  public static String getAccountInfo(ArrayList<Account> newAccount) {
			String accountOutput = "";
			
			for(int i = 0; i<newAccount.size(); i++) {
				
				accountOutput += String.format("%-15s %-20s %-20s %-15s\n", newAccount.get(i).getAccId(),newAccount.get(i).getPassword(),
						newAccount.get(i).getpName(),newAccount.get(i).getsName());
			}
			return accountOutput;
		}
	 
		
		public static void viewAccount(ArrayList<Account> newAccount) {
			String accountOutput = String.format("%-15s %-20s %-20s %-15s\n","Account ID","Password" ,"Parent's Name" ,"Student's Name");
			accountOutput += getAccountInfo(newAccount);
			System.out.println(accountOutput);
		}

		public static Account createAccount() {
			int accID = Helper.readInt("Enter Account ID: ");
			String Password = Helper.readString("Enter Password: ");
			String pName = Helper.readString("Enter Parent's Name: ");
			String sName = Helper.readString("Enter Student's Name: ");

			Account addAccount = new Account(accID, Password, pName, sName) ;
			return addAccount;
		}


		public static void newlyAddedAccount(ArrayList<Account> Account, Account newAccountUser) {
			Account.add(newAccountUser);
		}
		
		
		public static void deleteAccount(ArrayList<Account> Account) {
			int accID = Helper.readInt("Enter Account ID:");
			for (int i = 0; i< Account.size(); i++ ) {
				if(Account.get(i).getAccId() == accID) {
					Account.remove(i);
					System.out.println("Account ID" + accID + "deleted!");
					#oidasjasd
			}
			
		}	
		}
}

