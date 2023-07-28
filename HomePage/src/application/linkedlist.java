package application;

public class linkedlist {
	Node head;
	String brand;
	class Node{
		Object next;
		car data;
		Node(car data){
			this.data=data;
		}
	}
	public void insert(car data) {

		
		if(head==null) {
			head=new Node(data);
			brand=data.brand;
		}
		else {
			Node current=head;
			while(current.next!=null)
				current=(Node) current.next;
			current.next=new Node(data);
		}
	}
	public void delete(car data) {
		Node current=head;
		Node prev=head;
		if(current.data==data) {
			head=(Node) current.next;
			return;
		}
		while(current.next!=null) {
			if(current.data==data) {
				prev.next=current.next;
			}
			prev=current;
			current=(Node) current.next;
		}
		if(((Node)current).data==data) {
			prev.next=(Node) current.next;
		}
	}
	public void edit(car data1,car data2) {
		Node current=head;
		while(current!=null) {
			if(current.data==data1) {
				current.data.color=data2.color;
				current.data.Model=data2.Model;
				current.data.Price=data2.Price;
				current.data.Year=data2.Year;
				return;
			}
			current=(Node) current.next;
		}
	}
}
