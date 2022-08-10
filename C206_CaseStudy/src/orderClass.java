

public class orderClass {
	private int orderID;
	private String orderItem;
	private double orderPrice;
	private String orderStat;
	
	public orderClass(int orderID, String orderItem, double orderPrice, String orderStat) {
		super();
		this.orderID = orderID;
		this.orderItem = orderItem;
		this.orderPrice = orderPrice;
		this.orderStat = orderStat;
		
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderStat() {
		return orderStat;
	}

	public void setOrderStat(String orderStat) {
		this.orderStat = orderStat;
	}

	

	
}
