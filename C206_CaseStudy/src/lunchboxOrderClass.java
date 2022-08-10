
public class lunchboxOrderClass {
	private int LBorderId;
	private String LBOrderDate;
	private double LBOrderPrice;
	private String LBItems;

public lunchboxOrderClass(int LBorderId, String LBOrderDate, double LBOrderPrice, String LBItems ) {
	this.LBorderId = LBorderId;
	this.LBOrderDate = LBOrderDate;
	this.LBOrderPrice = LBOrderPrice;
	this.LBItems = LBItems;
}

public int getLBorderId(){
	return LBorderId;
}
public void setLBId(int LBId) {
	this.LBorderId = LBId;
}
public String getLBOrderDate() {
	return LBOrderDate;
}
public void setLBOrderDate(String LBOrderDate) {
	this.LBOrderDate = LBOrderDate;
}
public double getLBOrderPrice() {
	return LBOrderPrice;
}
public void setLBOrderPrice(double LBOrderPrice) {
	this.LBOrderPrice = LBOrderPrice;
}
public String getLBItems() {
	return LBItems;
}
public void setLBItems(String LBItems) {
	this.LBItems = LBItems;
}
}