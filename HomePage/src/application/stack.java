package application;

public class stack {
	linkedlistorders list=new linkedlistorders();
	public void push(order ord) {
		list.insert(ord);
	}
	public order pop() {
		return list.delete();
	}
}
