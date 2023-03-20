package InvoicingSystemDB;

public class InvoiceDB {

	private int invoiceId;
	private String customerFullName;
	private int phoneNumber;
	private int invoiceDate;
	private int numberOfItem;
	private float totalAmount;
	private float paidAmount;
	private float balance;

	ShopDB shopobj = new ShopDB();

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getCustomerFullName() {
		return customerFullName;
	}

	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(int invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getNumberOfItem() {
		return numberOfItem;
	}

	public void setNumberOfItem(int numberOfItem) {
		this.numberOfItem = numberOfItem;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public float getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(float paidAmount) {
		this.paidAmount = paidAmount;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public ShopDB getShopobj() {
		return shopobj;
	}

	public void setShopobj(ShopDB shopobj) {
		this.shopobj = shopobj;
	}

}
