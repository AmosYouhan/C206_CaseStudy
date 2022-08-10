import java.util.ArrayList;

public class menuClass {

		private int menuID;
		private String menuItem;
		private Double menuPrice;
		
		public menuClass(int menuID, String menuItem, Double menuPrice) {
			super();
			this.menuID = menuID;
			this.menuItem = menuItem;
			this.menuPrice = menuPrice;
			
		}

		public int getMenuID() {
			return menuID;
		}

		public void setMenuID(int menuID) {
			this.menuID = menuID;
		}

		public String getMenuItem() {
			return menuItem;
		}

		public void setMenuItem(String menuItem) {
			this.menuItem = menuItem;
		}

		public Double getMenuPrice() {
			return menuPrice;
		}

		public void setMenuPrice(Double menuPrice) {
			this.menuPrice = menuPrice;
		}
	}

