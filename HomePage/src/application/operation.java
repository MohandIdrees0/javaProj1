package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import application.DoubleLinkedList.Node;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class operation {
	int  count=0;
	DoubleLinkedList list=new DoubleLinkedList();
	queue1 queue=new queue1();
	stack Stack =new stack();
	public void readfile() throws FileNotFoundException {
		count=0;
		File file = new File("src\\application\\cars(2).txt");
		Scanner scan=new Scanner(file);
		while(scan.hasNextLine()) {
			divideandadd(scan.nextLine());
		}
		}
	public void divideandadd(String add) {
		if(count==0) {
			count=1;
			return;
		}
		car x=new car("","",0,"", "");
		int index=add.indexOf(',');
		x.brand=add.substring(0,index).trim();
		add=add.substring(index+1);
		/////
		index=add.indexOf(',');
		x.Model=add.substring(0,index).trim();
		add=add.substring(index+1);
		/////
		index=add.indexOf(',');
		x.Year=Integer.parseInt(add.substring(0,index).trim());
		add=add.substring(index+1);
		////
		index=add.indexOf(',');
		x.color=add.substring(0,index).trim();
		add=add.substring(index+1);
		////
		x.Price=add.trim();
		list.insert(x);
		
		
	}
	public void readfilefororders() throws FileNotFoundException {
		File file=new File("src/application/orders(1).txt");
		count=0;
		Scanner scan=new Scanner(file);
		while(scan.hasNextLine()) {
			divideandaddfororders(scan.nextLine());
		}
		}
	public void divideandaddfororders(String add) {
		if(count==0) {
			count=1;
			return;
		}
		order ord=new order("",0l,"","",0,"","",new Date(),"");//CustomerName, CustomerMobile, Brand, Model, Year, Color, Price, OrderDate, OrderStatus
		car x=new car("","",0,"", "");
		
		int index=add.indexOf(',');
		//////
		index=add.indexOf(',');
		ord.CustomerName=add.substring(0,index).trim();
		add=add.substring(index+1);
		////
		index=add.indexOf(',');
		ord.CustomerMobile=Long.parseLong(add.substring(0,index).trim());
		add=add.substring(index+1);
		////////
		index=add.indexOf(',');
		x.brand=add.substring(0,index).trim();
		add=add.substring(index+1);
		/////
		index=add.indexOf(',');
		x.Model=add.substring(0,index).trim();
		add=add.substring(index+1);
		/////
		index=add.indexOf(',');
		x.Year=Integer.parseInt(add.substring(0,index).trim());
		add=add.substring(index+1);
		////
		index=add.indexOf(',');
		x.color=add.substring(0,index).trim();
		add=add.substring(index+1);
		////
		index=add.indexOf(',');
		x.Price=add.substring(0,index).trim();
		add=add.substring(index+1);
		////
		index=add.indexOf(',');
		ord.orderDate=new Date(add.substring(0,index).trim());
		add=add.substring(index+1);
		/////
		ord.statut=add.trim();
		ord.brand=x.brand;
		ord.color=x.color;
		ord.Year=x.Year;
		ord.Price=x.Price;
		ord.Model=x.Model;
		if(ord.statut.compareToIgnoreCase("Finished")!=0)
			queue.insert(ord);
		else {
			Stack.push(ord);
		}
		
	}
	public void clientpage() {
		Client client=new Client();
		client.start(list,queue);
		
	}
	public void Adimnpage() {
		Admin client=new Admin();
		client.list=list;
		client.admin(queue,Stack);
		
	}
	public void Save(DoubleLinkedList list) throws IOException {
		DoubleLinkedList.Node linked=list.head;
		linkedlist.Node current=linked.data.head;
		//linkedlist.Node current=list.head;
		//doubleLinkedList.Node incurrent=current.element.head;
		Stage primaryStage=new Stage();
		FileChooser file=new FileChooser();
		file.setInitialDirectory(new File(System.getProperty("user.home")));
		File selectedFile = file.showOpenDialog(primaryStage);
		if(selectedFile.exists()) {
			selectedFile.delete();
			try {
				selectedFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileWriter fileWriter = new FileWriter(selectedFile);
			fileWriter.write("datBrand, Model, Year, Color, Price\n");
			while(linked!=list.end) {
				current=linked.data.head;
				while(current!=null) {
					fileWriter.write(current.data.brand+","+current.data.Model+","+current.data.Year+","+current.data.color+","+current.data.Price+"\n");
					current=(linkedlist.Node) current.next;
				}
				linked= (Node) linked.next;
				if(linked==list.end) {
					current=list.end.data.head;
					while(current!=null) {
						fileWriter.write(current.data.brand+","+current.data.Model+","+current.data.Year+","+current.data.color+","+current.data.Price+"\n");
						current=(linkedlist.Node) current.next;
					}
				}
				
				
			}
            fileWriter.close();
		}
	}
	public void addorder(queue1 queue,stack Stack) throws IOException {
		ArrayList<order> arr=new ArrayList();
		order x=queue.delete();
		while(x!=null) {
			arr.add(x);
			x=queue.delete();
		}
		x=Stack.pop();
		while(x!=null) {
			arr.add(x);
			x=Stack.pop();
		}
		Stage primaryStage=new Stage();
		FileChooser file=new FileChooser();
		file.setInitialDirectory(new File(System.getProperty("user.home")));
		File selectedFile = file.showOpenDialog(primaryStage);
		if(selectedFile.exists()) {
			selectedFile.delete();
			try {
				selectedFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileWriter fileWriter = new FileWriter(selectedFile);
			fileWriter.write("CustomerName, CustomerMobile, Brand, Model, Year, Color, Price, OrderDate, OrderStatus\n");
			for(int i=0;i<arr.size();i++) {
				fileWriter.write(arr.get(i).CustomerName+","+arr.get(i).CustomerMobile+","+arr.get(i).brand+","+arr.get(i).Model+","+arr.get(i).Year+arr.get(i).color+","+arr.get(i).Price+","+","+arr.get(i).orderDate+","+arr.get(i).statut+"\n");
			}
			/*while(linked!=list.end) {
				current=linked.data.head;
				while(current!=null) {
					fileWriter.write(current.data.brand+","+current.data.Model+","+current.data.Year+","+current.data.color+","+current.data.Price+"\n");
					current=(linkedlist.Node) current.next;
				}
				linked= (Node) linked.next;
				if(linked==list.end) {
					current=list.end.data.head;
					while(current!=null) {
						fileWriter.write(current.data.brand+","+current.data.Model+","+current.data.Year+","+current.data.color+","+current.data.Price+"\n");
						current=(linkedlist.Node) current.next;
					}
				}
				
				
			}*/
            fileWriter.close();
		}
	}
}
