package projectAgain;

public class Product {
	private Long id;
	private String productName;
	private double price;
	private String phoneNumber;
	private String details;

	public Product() {

	}

	public Product(Long id, String productName, double price, String phoneNumber, String details) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.phoneNumber = phoneNumber;
		this.details = details;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
