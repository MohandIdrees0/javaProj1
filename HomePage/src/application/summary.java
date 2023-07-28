package application;

import application.linkedlist.Node;

public class summary {
	String brand="";
	String Highest_Price="";
	String Lowest_Price="";
	String Highest_Model="";
	String Lowest_Model="";
	public void cal(linkedlist list) {
		Node current=list.head;
		this.brand=list.brand;
		Highest_Price=list.head.data.Price;
		Lowest_Price=list.head.data.Price;
		Highest_Model=list.head.data.Model;
		Lowest_Model=list.head.data.Model;
		while(current!=null) {
			if(current.data.Price.substring(0,current.data.Price.indexOf("K")).compareTo(Highest_Price)>0) {
				Highest_Price=current.data.Price;
			}
			if(current.data.Price.substring(0,current.data.Price.indexOf("K")).compareTo(Lowest_Price)<0) {
				Lowest_Price=current.data.Price;
			}
			if(current.data.Model.compareTo(Lowest_Model)<0) {
				Lowest_Model=current.data.Model;
			}
			if(current.data.Model.compareTo(Highest_Model)>0) {
				Highest_Model=current.data.Model;
			}
			current=(Node) current.next;
		}
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getHighest_Price() {
		return Highest_Price;
	}
	public void setHighest_Price(String highest_Price) {
		Highest_Price = highest_Price;
	}
	public String getLowest_Price() {
		return Lowest_Price;
	}
	public void setLowest_Price(String lowest_Price) {
		Lowest_Price = lowest_Price;
	}
	public String getHighest_Model() {
		return Highest_Model;
	}
	public void setHighest_Model(String highest_Model) {
		Highest_Model = highest_Model;
	}
	public String getLowest_Model() {
		return Lowest_Model;
	}
	public void setLowest_Model(String lowest_Model) {
		Lowest_Model = lowest_Model;
	}
	
	
}
