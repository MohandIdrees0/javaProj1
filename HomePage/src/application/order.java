package application;

import java.util.Date;

public class order {
	String brand;
	String Model;
	int Year;
	String Price;
	String color;
	String statut;
	String CustomerName;
	Long CustomerMobile;
	Date orderDate;
	public order(String customerName, Long customerMobile,String brand, String model, int year, String color, String price,Date date,String statut) {
		this.brand=brand;
		this.Model=model;
		this.Year=year;
		this.color=color;
		this.Price=price;
		this.statut=statut;
		this.orderDate=date;
		CustomerName = customerName;
		CustomerMobile = customerMobile;
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
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public Long getCustomerMobile() {
		return CustomerMobile;
	}
	public void setCustomerMobile(Long customerMobile) {
		CustomerMobile = customerMobile;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
}
