package application;
public class linkedlistorders {
	Node head;
	class Node{
		Object next;
		order data;
		Node(order data){
			this.data=data;
		}
	}
	public void insert(order data) {
		if(head==null) {
			head=new Node(data);
		}
		else {
			Node current=head;
			while(current.next!=null)
				current=(Node) current.next;
			current.next=new Node(data);
		}
	}
	public order delete() {
		if(head==null) {
			return null;
		}
		Node current=head;
		head=(Node) head.next;
		return current.data;
	}
	public void insertfirst(order ord) {
		if(head==null) {
			head=new Node(ord);
		}
		else {
			Node current=new Node(ord);
			current.next=head;
			head=current;
		}
	}
}
