
import java.util.ArrayList;

public class orderBill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<orderClass> newBill = new ArrayList<orderClass>();
	    
	    newBill.add(new orderClass(1007, "Vegetarian Bee Hoon, Apple Juice, Watermelon", 3.50, "Processing"));
	    newBill.add(new orderClass(1008, "Char Kway Teow, Coke, Papyaya", 4.00, "Processing"));
	    newBill.add(new orderClass(1009, "Fish & Chips, Ice Lemon Tea, Apple", 5.00, "Processing"));
	    
	    int option = 0;
	    
	    while (option != 4) {
	    	Helper.line(50, "=");
		    System.out.println("Order Bills");
			System.out.println("1. Add order bill");					
			System.out.println("2. View order bill");
			System.out.println("3. Delete order bill");
			System.out.println("4. Quit");
			Helper.line(50, "=");
		    option = Helper.readInt("Enter option number from order menu: ");
	      
	      if(option == 1) {
	    	  
	    	  int orderApplicable = Helper.readInt("Enter order ID check whether it is applicable: ");
				for(int i = 0; i<newBill.size(); i++) {
					
					if(newBill.get(i).getOrderID() == orderApplicable) {
						System.out.println("Order ID already existed");
						
					}else {
						orderClass newOrderBill = createOrderBill();
						orderBill.newlyAddedBill(newBill, newOrderBill);
						System.out.println("Created new order bill");
						break;
					}
				}
	      }
	      	else if(option == 2) {
	  			
	    	  orderBill.viewOrderBill(newBill);
				
	      	}
			else if(option == 3) {
				orderBill.deleteOrderBill(newBill);
			
				
			}else if(option == 4) {
				System.out.println("Thank you for your time!");
			}
		  else {
				System.out.println("The number you entered is invalid");
			}
	    }

	  }
	 
	  
	  public static String getOrderInfo(ArrayList<orderClass> newBill) {
			String billOutput = "";
			
			for(int i = 0; i<newBill.size(); i++) {
				
				billOutput += String.format("%-15s %-50s %-50s %-15s\n", newBill.get(i).getOrderID(),newBill.get(i).getOrderItem(),
						newBill.get(i).getOrderPrice(),newBill.get(i).getOrderStat());
			}
			return billOutput;
		}
	 
		
		public static void viewOrderBill(ArrayList<orderClass> newBill) {
			String billOutput = String.format("%-15s %-50s %-50s %-15s\n","Order ID","Order Item" ,"Order Price" ,"Order Status");
			billOutput += getOrderInfo(newBill);
			System.out.println(billOutput);
		}

		public static orderClass createOrderBill() {
			int orderID = Helper.readInt("Enter Order ID: ");
			String orderItem = Helper.readString("Enter Order Item: ");
			double orderPrice = Helper.readDouble("Enter Order Price: ");
			String orderStat = Helper.readString("Enter Order Status: ");

			orderClass addOrder = new orderClass(orderID, orderItem, orderPrice, orderStat);
			return addOrder;
		}

		
		public static void newlyAddedBill(ArrayList<orderClass> newBill, orderClass newOrderBill) {
			newBill.add(newOrderBill);
		}
		
		
		public static void deleteOrderBill(ArrayList<orderClass> newBill) {
			int orderID = Helper.readInt("Enter Order ID:");
			for (int i = 0; i< newBill.size(); i++ ) {
				if(newBill.get(i).getOrderID() == orderID) {
					newBill.remove(i);
					System.out.println("Order ID " + orderID + " deleted!");
					
				}
				
			}
			
			
		}	
}

