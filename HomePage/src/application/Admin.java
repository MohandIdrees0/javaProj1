package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import application.DoubleLinkedList.Node;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Admin {
	queue1 queue;
	ArrayList<order> x=new ArrayList();
	TableView<order> table;
	order ord;
	stack Stack;
	DoubleLinkedList list;
	public void  admin(queue1 queue,stack Stack) {
		this.Stack=Stack;
		this.queue=queue;
		Stage stage=new Stage();
		BorderPane root = new BorderPane();
		TabPane tab=new TabPane();
		Tab tab0=new Tab();
		Tab tab1=new Tab();
		tab1.setContent(summary());
		tab1.setText("Summary");
		tab0.setContent(admintab());
		tab0.setText("Admin");
		tab.getTabs().addAll(tab0,tab1);
		root.setCenter(tab);
		Scene scene = new Scene(root,1200,800);
		scene.getStylesheets().add(getClass().getResource("Admin.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public BorderPane admintab() {
		BorderPane v=new BorderPane();
		table=new TableView<order>();

        TableColumn<order, String> customerName = new TableColumn<order, String>("customerName");
        customerName.setCellValueFactory(new PropertyValueFactory<order, String>("customerName"));

        TableColumn<order, Integer> customerMobile = new TableColumn<order, Integer>("customerMobile");
        customerMobile.setCellValueFactory(new PropertyValueFactory<order, Integer>("customerMobile"));

        TableColumn<order, String> brand = new TableColumn<order, String>("brand");
        brand.setCellValueFactory(new PropertyValueFactory<order, String>("brand"));

        TableColumn<order, String> model = new TableColumn<order, String>("model");
        model.setCellValueFactory(new PropertyValueFactory<order, String>("model"));


        TableColumn<order, Integer> year = new TableColumn<order, Integer>("year");
        year.setCellValueFactory(new PropertyValueFactory<order, Integer>("year"));

        TableColumn<order, String> color = new TableColumn<order, String>("color");
        color.setCellValueFactory(new PropertyValueFactory<order, String>("color"));

        TableColumn<order, String> price = new TableColumn<order, String>("price");
        price.setCellValueFactory(new PropertyValueFactory<order, String>("price"));

        TableColumn<order, Date> date = new TableColumn<order, Date>("date");
        date.setCellValueFactory(new PropertyValueFactory<order, Date>("orderDate"));

        TableColumn<order, String> statut = new TableColumn<order, String>("statut");
        statut.setCellValueFactory(new PropertyValueFactory<order, String>("statut"));

        table.getColumns().addAll(customerName, customerMobile, brand, model, year, color,price,date,statut);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        fillarray();
        HBox titlerow=new HBox();
        titlerow.setAlignment(Pos.CENTER);
        Label title=new Label("Admin Page");title.setId("TITLE");
        titlerow.getChildren().add(title);
        v.setTop(titlerow);
        table.getItems().addAll(x);
        v.setCenter(table);
        VBox v0=new VBox(75);v0.getChildren().addAll(row0(),row1());v0.setAlignment(Pos.CENTER);
        v0.setPrefHeight(200);
        v.setBottom(v0);
		return v;
	}
	public void fillarray() {
		order ord=queue.delete();
        while(ord!=null) {
        	x.add(ord);
        	ord=queue.delete();
        }
        for(int i=0;i<x.size();i++) {
        	queue.insert(x.get(i));
        }
	}
	public HBox row0() {
		
		HBox  root=new HBox(75);
		root.setAlignment(Pos.CENTER);
		Button Finish=new Button("Finish");Finish.setPrefWidth(150);
		Button sendtolast=new Button("Process Later");sendtolast.setPrefWidth(150);
		Button cansel=new Button("cansel");cansel.setPrefWidth(150);
		Finish.setOnAction(e->{
			if(table.getSelectionModel().getFocusedIndex()==0) {
				ord=table.getSelectionModel().getSelectedItem();
				ord.statut="Finished";
				Stack.push(ord);
				table.getItems().remove(0);
			}
		});
		sendtolast.setOnAction(e->{
			if(table.getSelectionModel().getFocusedIndex()==0){
				ord=table.getSelectionModel().getSelectedItem();
				queue.insert(ord);
				queue.delete();
				table.getItems().remove(0);
				table.getItems().add(ord);
			}
		});
		cansel.setOnAction(e->{
			ArrayList<order> arr=new ArrayList();
			queue.clear();
			for(int i=1;i<table.getItems().size();i++) {
				arr.add(table.getItems().get(i));
				queue.insert(table.getItems().get(i));
			}
			table.getItems().clear();
			table.getItems().addAll(arr);
		});
		root.getChildren().addAll(Finish,sendtolast,cansel);
		return root;
	}
	public HBox row1() {
		HBox  root=new HBox(75);root.setAlignment(Pos.CENTER);
		Button Save=new Button("Save");
		Button last10=new Button("Last Ten Orders");last10.setPrefWidth(150);
		root.getChildren().addAll(last10,Save);
		last10.setOnAction(e->{
			lastTen();
		});
		Save.setOnAction(e->{
			try {
				new operation().addorder(queue, Stack);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		return root;
	}
	public void lastTen() {
		BorderPane root=new BorderPane();
		Stage stage=new Stage();
		stage.setTitle("Last 10 orders");
		Scene scene=new Scene(root,400,400);
		TableView table1=new TableView<order>();
		TableColumn<order, String> customerName = new TableColumn<order, String>("customerName");
        customerName.setCellValueFactory(new PropertyValueFactory<order, String>("customerName"));

        TableColumn<order, Integer> customerMobile = new TableColumn<order, Integer>("customerMobile");
        customerMobile.setCellValueFactory(new PropertyValueFactory<order, Integer>("customerMobile"));

        TableColumn<order, String> brand = new TableColumn<order, String>("brand");
        brand.setCellValueFactory(new PropertyValueFactory<order, String>("brand"));

        TableColumn<order, String> model = new TableColumn<order, String>("model");
        model.setCellValueFactory(new PropertyValueFactory<order, String>("model"));


        TableColumn<order, Integer> year = new TableColumn<order, Integer>("year");
        year.setCellValueFactory(new PropertyValueFactory<order, Integer>("year"));

        TableColumn<order, String> color = new TableColumn<order, String>("color");
        color.setCellValueFactory(new PropertyValueFactory<order, String>("color"));

        TableColumn<order, String> price = new TableColumn<order, String>("price");
        price.setCellValueFactory(new PropertyValueFactory<order, String>("price"));

        TableColumn<order, Date> date = new TableColumn<order, Date>("date");
        date.setCellValueFactory(new PropertyValueFactory<order, Date>("orderDate"));

        TableColumn<order, String> statut = new TableColumn<order, String>("statut");
        statut.setCellValueFactory(new PropertyValueFactory<order, String>("statut"));

        table1.getColumns().addAll(customerName, customerMobile, brand, model, year, color,price,date,statut);
        table1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table1.getItems().addAll(pop_push());
        root.setCenter(table1);
        stage.setScene(scene);
        stage.show();
		
	}
	public ArrayList<order> pop_push() {
		ArrayList<order> arr1=new ArrayList();
		order orders=Stack.pop();
		while(orders!=null) {
			arr1.add(orders);
			orders=Stack.pop();
		}
		for(int i=arr1.size()-1;i>0;i--) {
			Stack.push(arr1.get(i));
		}
		return arr1;
	}
	//////////second tab
	public VBox summary() {
		VBox v=new VBox();
		TableView table1=new TableView<summary>();
		
        TableColumn<summary, String> brand = new TableColumn<summary, String>("brand");
        brand.setCellValueFactory(new PropertyValueFactory<summary, String>("brand"));
        
        TableColumn<summary, String> Highest_Price = new TableColumn<summary, String>("Highest_Price");
        Highest_Price.setCellValueFactory(new PropertyValueFactory<summary, String>("Highest_Price"));
        
        TableColumn<summary, String> Lowest_Price = new TableColumn<summary, String>("Lowest_Price");
        Lowest_Price.setCellValueFactory(new PropertyValueFactory<summary, String>("Lowest_Price"));
        
        TableColumn<summary, String> Highest_Model = new TableColumn<summary, String>("Highest_Model");
        Highest_Model.setCellValueFactory(new PropertyValueFactory<summary, String>("Highest_Model"));
        
        TableColumn<summary, String> Lowest_Model = new TableColumn<summary, String>("Lowest_Model");
        Lowest_Model.setCellValueFactory(new PropertyValueFactory<summary, String>("Lowest_Model"));
        
        table1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table1.getColumns().addAll(brand, Highest_Price, Lowest_Price, Highest_Model, Lowest_Model);
        Node current=list.head;
        summary s=new summary();
        while(current!=list.end) {
            System.out.println(current.data.brand);
        	s=new summary();
        	s.cal(current.data);
        	table1.getItems().add(s);
        	current=(Node) current.next;
        }
        s=new summary();
    	s.cal(current.data);
    	table1.getItems().add(s);
    	current=(Node) current.next;
       v.getChildren().add(table1);
       return v;
        
	}
}
