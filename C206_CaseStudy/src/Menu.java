public class Menu {
	
	private String menuId;
	private String menuItems;
	
	public Menu(String menuId, String menuItems) {
		this.menuId = menuId;
		this.menuItems = menuItems;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(String menuItems) {
		this.menuItems = menuItems;
	}
}
