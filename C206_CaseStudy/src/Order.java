public class Order extends Account{
	
	private int orderId;
	private Double price;
	
	public Order(int accId, String password, String pName, String sName, int orderId, Double price) {
		super(accId, password, pName, sName);
		this.orderId = orderId;
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
