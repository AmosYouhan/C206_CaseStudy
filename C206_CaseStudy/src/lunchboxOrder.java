import java.util.ArrayList;

public class lunchboxOrder {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  ArrayList<lunchboxOrderClass> newOrder = new ArrayList<lunchboxOrderClass>();

    newOrder.add(new lunchboxOrderClass(1007, "2022-08-09", 3.50,"Vegetarian Bee Hoon, Apple Juice, Watermelon"));
    newOrder.add(new lunchboxOrderClass(1008, "2022-08-10", 5.50,"Char Kway Teow, Coke, Papyaya"));
    newOrder.add(new lunchboxOrderClass(1009, "2022-08-11", 4.50,"Fish & Chips, Ice Lemon Tea, Apple"));
    
    int option = 0;
    
    while (option != 4) {
      Helper.line(50, "=");
      System.out.println("Order Bills");
    System.out.println("1. Add LunchBox Order");
    System.out.println("2. View LunchBox Order");
    System.out.println("3. Delete LunchBox Order");
    System.out.println("4. Quit");
    Helper.line(50, "=");
      option = Helper.readInt("Enter Option(1,2,3,4)>  ");
      
      if(option == 1) {
    	  int LBorderApplicable = Helper.readInt("Enter order ID check whether it is applicable: ");
			for(int i = 0; i<newOrder.size(); i++) {
				
				if(newOrder.get(i).getLBorderId() == LBorderApplicable) {
					System.out.println("Order ID already existed");
					
				}else {
					lunchboxOrderClass newLBorder = createLBorder();
					lunchboxOrder.newlyAddedLBOrder(newOrder, newLBorder);
					System.out.println("Created new Lunch box order");
					break;
				}
			}
	    }
      else if (option ==2) {
        lunchboxOrder.ViewLunchBoxOrder(newOrder);
      }
      else if (option ==3) {
        lunchboxOrder.DeleteLunchBoxOrder(newOrder);
      }
      else if (option ==4) {
        System.out.println("Thanyou for using our app!");
      }
      else {
        System.out.println("Invalid Option!");
      }
}
    
  }

	
 
  public static void DeleteLunchBoxOrder(ArrayList<lunchboxOrderClass> newOrder) {
    // TODO Auto-generated method stub
    int orderID = Helper.readInt("Enter Order ID:");
    for (int i = 0; i< newOrder.size(); i++ ) {
      if(newOrder.get(i).getLBorderId() == orderID) {
        newOrder.remove(i);
        System.out.println("Order ID " + orderID + "deleted!");
      }
    }
  }
  public static boolean doDeleteLBorder(ArrayList<lunchboxOrderClass> newOrder, String LBItems) {
		
		boolean isDelete = false;
		
		for(int i = 0; i< newOrder.size(); i++) {
			
			if(LBItems.equalsIgnoreCase(newOrder.get(i).getLBItems())) {
				
				newOrder.remove(i);
				
				isDelete = true;
			}
		}
		return isDelete;
	}


  public static String getLBOrderInfo(ArrayList<lunchboxOrderClass> newOrder) {
		String LBorderOutput = "";
		
		int orderID = Helper.readInt("Find LunchBox Order> Key in order id > ");
	     
		for(int i = 0; i<newOrder.size(); i++) {
			 if(newOrder.get(i).getLBorderId() == orderID){
		      lunchboxOrderClass LB = newOrder.get(i);
			LBorderOutput += String.format("%-10d %-10s %-15s %-10s\n", LB.getLBorderId(), LB.getLBOrderDate(), LB.getLBOrderPrice(),LB.getLBItems());
					
		}
		
	}
		return LBorderOutput;
  }
	public static void  ViewLunchBoxOrder(ArrayList<lunchboxOrderClass> newOrder) {
    // TODO Auto-generated method stub
    Helper.line(50,  "=");
      System.out.println(" VIEW LUNCHBOX ORDER");
      Helper.line(50,  "=");
     
      String LBorderOutput = String.format("%-10s %-10s %-15s %-10s\n", "ID" , "DATE" , "PRICE" , "ITEMS");
      
		LBorderOutput += getLBOrderInfo(newOrder);
		System.out.println(LBorderOutput);
     
           
        }
      
   
     


  public static lunchboxOrderClass createLBorder() {
	  int id = Helper.readInt("Enter new lunch box ID");
    	 String date = Helper.readString("Enter new lunchbox order date");
    	 double price = Helper.readDouble("Enter lunch box price");
    	 String items = Helper.readString("Enter lunchbox items");

    	 lunchboxOrderClass addLBorder = new lunchboxOrderClass(id, date, price, items);
		return addLBorder;
	}


  public static void newlyAddedLBOrder(ArrayList<lunchboxOrderClass> newOrder, lunchboxOrderClass newLBorder) {
		newOrder.add(newLBorder);
	}
	



	
	



}