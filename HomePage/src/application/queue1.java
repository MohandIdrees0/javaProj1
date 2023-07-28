package application;

public class queue1 {
	linkedlistorders orders=new linkedlistorders();
	public void insert(order ord) {
		orders.insert(ord);
	}
	public order delete() {
		return orders.delete();
	}
	public void clear() {
		orders.head=null;
	}
}
