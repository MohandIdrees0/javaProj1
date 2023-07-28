package application;

public class car {
	String brand;
	String Model;
	int Year;
	String color;
	String Price;
	public car(String brand, String model, int year, String color, String price) {
		super();
		this.brand = brand;
		Model = model;
		Year = year;
		this.color = color;
		Price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "car [brand=" + brand + ", Model=" + Model + ", Year=" + Year + ", color=" + color + ", Price=" + Price
				+ "]";
	}
	
	
}
