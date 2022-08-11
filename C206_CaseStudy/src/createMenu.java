
public class createMenu {
	private int menuID;
	private String menuItems;
	private String menuDescription;
	private Double menuPrice;
	

	
	public createMenu(int menuID, String menuItems, String menuDescription, double menuPrice) {
		super();
		this.menuID = menuID;
		this.menuItems = menuItems;
		this.menuDescription = menuDescription;
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



	public String getMenuDescription() {
		return menuDescription;
	}



	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}



	public Double getMenuPrice() {
		return menuPrice;
	}



	public void setMenuPrice(Double menuPrice) {
		this.menuPrice = menuPrice;
	}





	

	
}



