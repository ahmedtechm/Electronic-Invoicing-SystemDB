package InvoicingSystemDB;

public class ItemDB {



	private int itemID;
	private String itemName;
	private float  itemPrice;
	private int itemQuantity;
	private float  qtyAmountPrice;
		
		
		public int getItemID() {
			return itemID;
		}
		public void setItemID(int itemID) {
			this.itemID = itemID;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public float getItemPrice() {
			return itemPrice;
		}
		public void setItemPrice(float itemPrice) {
			this.itemPrice = itemPrice;
		}
		public int getItemQuantity() {
			return itemQuantity;
		}
		public void setItemQuantity(int itemQuantity) {
			this.itemQuantity = itemQuantity;
		}
		public float getQtyAmountPrice() {
			return qtyAmountPrice;
		}
		public void setQtyAmountPrice(float qtyAmountPrice) {
			this.qtyAmountPrice = qtyAmountPrice;
		}
	
		
		

}
