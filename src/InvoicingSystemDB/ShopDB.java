package InvoicingSystemDB;


public class ShopDB {


		String shopName;
		int telephone; 
		String fax;
		String email;
		String webSite;
		
		
		ItemDB itemobj = new ItemDB();
		
		
		public String getShopName() {
			return shopName;
		}
		public void setShopName(String shopName) {
			this.shopName = shopName;
		}
		public int getTelephone() {
			return telephone;
		}
		public void setTelephone(int telephone) {
			this.telephone = telephone;
		}
		public String getFax() {
			return fax;
		}
		public void setFax(String fax) {
			this.fax = fax;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getWebSite() {
			return webSite;
		}
		public void setWebSite(String webSite) {
			this.webSite = webSite;
		}
	

		
		
}
