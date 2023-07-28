package application;

import java.util.ArrayList;

import application.DoubleLinkedList.Node;

public class DoubleLinkedList {
	Node head;
	Node end;
	ArrayList<String> x=new ArrayList();
	class Node{
		Object next,prev;
		linkedlist data;
		Node(linkedlist data){
			this.data=data;
			this.next=this.prev=null;
		}
	}
	public void insert(car val) {
		Node current=head;
		if(x.contains(val.brand)) {
			//System.out.println("contains");
			while(current.data.brand.compareTo(val.brand)!=0) {
				current=(Node) current.next;
			}
			current.data.insert(val);
		}
		else {
			//System.out.println(val.brand+" Does not contain");
			if(head==null) {
				//System.out.println("head==null");
				x.add(val.brand);
				head=end=new Node(new linkedlist());
				head.data.brand=val.brand;
				head.data.insert(val);
				return;
			}
			Node pre=current;
			boolean g=current.data.brand.toLowerCase().charAt(0)>val.brand.toLowerCase().charAt(0);//الي جاي اكبر
			while(!g && current!=end) {
				pre=current;
				//System.out.println("smaller and not the end");
				current=(Node) current.next;
				g=current.data.brand.toLowerCase().charAt(0)>val.brand.toLowerCase().charAt(0);
			}
			if(g) {
				//System.out.print("add before");
				x.add(val.brand);
				if(current==head) {
					//System.out.println("head=current");
					Node list=new Node(new linkedlist());
					list.data.insert(val);
					list.next=head;
					list.prev=end;
					head.prev=list;
					end.next=list;
					head=list;
					list.data.brand=val.brand;
					return;
				}
				else {
					//System.out.println("add before");
					Node list=new Node(new linkedlist());
					list.next=current;
					list.prev=pre;
					current.prev=list;
					pre.next=list;
					list.data.brand=val.brand;
					current=head;
					return;
				}
			}
			else {
				//System.out.println("add after");
				x.add(val.brand);
				if(current==end) {
					Node list=new Node(new linkedlist());
					end.next=list;
					list.next=head;
					list.prev=end;
					head.prev=list;
					end=list;
					end.data.brand=val.brand;
				}
				else {
					//System.out.println(" add after between");
					Node list=new Node(new linkedlist());
					list.next=((Node)current.next);
					((Node)current.next).prev=list;
					current.next=list;
					list.prev=current;
					list.data.brand=val.brand;
					
				}
			}
		}
	}
	public void delete(String brand) {
		Node current=head;
		while(current.data.brand.compareToIgnoreCase(brand)!=0){
			current=(Node) current.next;
		}
		((Node)current.prev).next=current.next;
		((Node)current.next).prev=current.prev;
		
		
	}
}
