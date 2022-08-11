
public class createMenu {
	private int menuID;
	private String menuItems;
	private Double menuPrice;
	


	public createMenu(int menuID, String menuItems, Double menuPrice) {
		super();
		this.menuID = menuID;
		this.menuItems = menuItems;
		this.menuPrice = menuPrice;
	}



	public int getMenuID() {
		return menuID;
	}



	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}



	public String getMenuItems() {
		return menuItems;
	}



	public void setMenuItems(String menuItems) {
		this.menuItems = menuItems;
	}



	public Double getMenuPrice() {
		return menuPrice;
	}



	public void setMenuPrice(Double menuPrice) {
		this.menuPrice = menuPrice;
	}

	
}



