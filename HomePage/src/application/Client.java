package application;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import application.DoubleLinkedList.Node;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Client{
	DoubleLinkedList list;
	Node node;
	linkedlist single;
	linkedlist.Node current;
	boolean login;
	ArrayList<String> PRICES=new ArrayList();
	ArrayList<String> YEARS=new ArrayList();
	ArrayList<String> COLORS=new ArrayList();
	public void start(DoubleLinkedList list,queue1 queue) {
			this.list=list;
			node=list.head;
			single=node.data;
			current=single.head;
			Stage primaryStage=new Stage();
			BorderPane root = new BorderPane();
			BorderPane row0=new BorderPane();//row0.setAlignment(Pos.BOTTOM_CENTER);
			Button Edit=new Button("EDIT");Edit.setId("edit");
			HBox buttonbox=new HBox();buttonbox.setAlignment(Pos.TOP_RIGHT);buttonbox.getChildren().add(Edit);
			row0.setTop(buttonbox);
			VBox v0=new  VBox();v0.setAlignment(Pos.BOTTOM_LEFT);
			VBox v1=new  VBox();v1.setAlignment(Pos.BOTTOM_CENTER);
			Scene scene = new Scene(root,1200,800);
			TableView<car> table = new TableView<car>();
			
			TableColumn<car, String> brand = new TableColumn<car, String>("brand");
			brand.setCellValueFactory(new PropertyValueFactory<car, String>("brand"));

	        TableColumn<car, String> Model = new TableColumn<car, String>("Model");
	        Model.setCellValueFactory(new PropertyValueFactory<car, String>("Model"));

	        TableColumn<car, Integer> Year = new TableColumn<car, Integer>("Year");
	        Year.setCellValueFactory(new PropertyValueFactory<car, Integer>("Year"));

	        TableColumn<car, String> color = new TableColumn<car, String>("color");
	        color.setCellValueFactory(new PropertyValueFactory<car, String>("color"));

	        TableColumn<car, String> Price = new TableColumn<car, String>("Price");
	        Price.setCellValueFactory(new PropertyValueFactory<car, String>("Price"));

	        table.getColumns().addAll(brand, Model,Year, color, Price);
	        while(current!=null) {
	        	table.getItems().add(current.data);
	        	current=(application.linkedlist.Node) current.next;
	        }
	        ///////RIGHTVERICAL
	        VBox rv=new VBox(25);rv.setId("rv");
	        rv.setAlignment(Pos.CENTER);//center left verical
	        Label rvtitle=new Label("Confirm Your purchase");rvtitle.setId("filters");
	        
	        HBox rv_row0=new HBox();//first Row in left Verical
	        rv_row0.setAlignment(Pos.CENTER);
	        Label Name=new Label("Name");Name.setPrefWidth(90);Name.setId("filters");
	        TextField cusomerName=new TextField();cusomerName.setPrefWidth(90);
	        rv_row0.getChildren().addAll(Name,cusomerName);

	        HBox rv_row1=new HBox();//first Row in left Verical
	        rv_row1.setAlignment(Pos.CENTER);
	        Label Phone=new Label("PhoneNum");Phone.setPrefWidth(90);Phone.setId("filters");
	        TextField PhoneNumber=new TextField();PhoneNumber.setPrefWidth(90);
	        rv_row1.getChildren().addAll(Phone,PhoneNumber);
	        
	        Button confirm=new Button("Confirm");
	        rv.getChildren().addAll(rvtitle,rv_row0,rv_row1,confirm);
	        rv.setVisible(false);
	        ///////row0
	        ComboBox<String> com=new ComboBox();
	        Label title=new Label("");
	        title.setText(list.head.data.brand);
	        title.setId("title");
	        v0.getChildren().add(com);
	        v1.getChildren().add(title);
	        row0.setCenter(v1);
	        row0.setRight(v0);
	        row0.setPrefHeight(140);
	        //v0.setPadding(new Insets(0,0,0,400));
	        //com.setItems();
	        
	        ////////operation
	        Node findcom=list.head;
	        com.setValue(findcom.data.brand);
	        while(findcom!=list.end) {
	        	com.getItems().add(findcom.data.brand);
	        	findcom=(Node) findcom.next;
	        }
	        com.getItems().add(findcom.data.brand);
	        ////////FILITERS
	        fillarr();
	        fillCOL();
	        VBox  vertivalleft=new VBox(25);vertivalleft.setId("LEFTVERT");vertivalleft.setAlignment(Pos.CENTER);
	        ////////////
	        Label above2010 =new Label("YearsFrom");above2010.setId("filters");
	        Label TO0 =new Label("TO");TO0.setId("filters");
	        ComboBox<String> cheack1=new ComboBox();
	        fillyear();
	        ComboBox<String> cheack2=new ComboBox();
	        cheack1.getItems().addAll(YEARS);
	        cheack2.getItems().addAll(YEARS);
	        HBox leftrow0=new HBox(3);
	        leftrow0.getChildren().addAll(above2010,cheack1,TO0,cheack2);
	        /////////
	        Label Price1=new Label("Price");Price1.setId("filters");
	        Label From =new Label("From");From.setId("filters");
	        ComboBox<String> fromprice=new ComboBox();fromprice.getItems().setAll(PRICES);
	        Label TO =new Label("To");TO.setId("filters");
	        ComboBox<String> Toprice=new ComboBox();Toprice.getItems().setAll(PRICES);HBox leftrow1=new HBox();leftrow1.getChildren().addAll(Price1,From,fromprice,TO,Toprice);
	        Label color1 =new Label("Color");color1.setId("filters");
	        ComboBox<String> COLOR=new ComboBox();COLOR.getItems().setAll(COLORS);HBox leftrow2=new HBox(25);leftrow2.getChildren().addAll(color1,COLOR);
	        Button apply=new Button("Apply Filters");
	        vertivalleft.getChildren().addAll(leftrow0,leftrow1,leftrow2,apply);
	        leftrow0.setAlignment(Pos.CENTER);
	        leftrow1.setAlignment(Pos.CENTER);
	        leftrow2.setAlignment(Pos.CENTER);
	        ///////row1
	        VBox buttom=new VBox(5);buttom.setAlignment(Pos.CENTER);
	        Button pre=new Button("<--previous");pre.setPrefWidth(100);
	        Button next=new Button("next-->");next.setPrefWidth(100);
	        Button add=new Button("Add To Cart");
	        HBox row1=new HBox(75);row1.setAlignment(Pos.CENTER);row1.getChildren().addAll(pre,add,next);
	        row1.setPrefHeight(200);
	        ////////////row2
	        Button Delete=new Button("DeleteBrand");pre.setPrefWidth(100);
	        Button deleteSelectetItem=new Button("deleteItem");next.setPrefWidth(100);
	        Button addItem=new Button("AddItem");
	        Button AddBrand=new Button("AddBrand");
	        Button find=new Button("find");
	        Button EditBrand=new Button("EditBrand");
	        Button EditItem=new Button("EditSelectedItem");
	        HBox editrow=new HBox(75);editrow.setAlignment(Pos.CENTER);editrow.getChildren().addAll(Delete,deleteSelectetItem,find,addItem,EditItem,AddBrand,EditBrand);root.setBottom(editrow);
	        Button Save=new Button("Save");
	        editrow.setVisible(false);
	        buttom.getChildren().addAll(row1,editrow,Save);
	        root.setBottom(buttom);
	        //////setOn aciton
	        pre.setOnAction(e->{
	        	node=(Node) node.prev;
	        	single=node.data;
	        	current=single.head;
	        	table.getItems().clear();
	        	title.setText(single.brand);
	        	com.setValue(single.brand);
	        	while(current!=null) {
		        	table.getItems().add(current.data);
		        	current=(application.linkedlist.Node) current.next;
		        }
	        });
	        next.setOnAction(e->{
	        	node=(Node) node.next;
	        	single=node.data;
	        	current=single.head;
	        	com.setValue(single.brand);
	        	table.getItems().clear();
	        	title.setText(single.brand);
	        	current=single.head;
	        	while(current!=null) {
		        	table.getItems().add(current.data);
		        	current=(application.linkedlist.Node) current.next;
		        }
	        });
	        com.setOnAction(e->{
	        	node=findNode(com.getValue());
	        	single=node.data;
	        	current=single.head;
	        	com.setValue(single.brand);
	        	table.getItems().clear();
	        	title.setText(single.brand);
	        	while(current!=null) {
		        	table.getItems().add(current.data);
		        	current=(application.linkedlist.Node) current.next;
		        }
	        });
	        apply.setOnAction(e->{
	        	table.getItems().clear();
	        	table.getItems().addAll(filiter(cheack1.getValue(),cheack2.getValue(),fromprice.getValue(),Toprice.getValue(),COLOR.getValue(),node.data.head));
	        	cheack1.setValue(null);
	        	cheack2.setValue(null);
	        	fromprice.setValue(null);
	        	Toprice.setValue(null);
	        	COLOR.setValue(null);
	        });
	        confirm.setOnAction(e->{
	        	try {
	        	car x=table.getSelectionModel().getSelectedItem();
	        	queue.insert(new order(cusomerName.getText(),Long.parseLong(PhoneNumber.getText()),x.brand,x.Model,Integer.parseInt(x.Year+""),x.color,x.Price,new Date(),"InProcess"));
	        	rv.setVisible(false);
	        	}
	        	catch (Exception e1){ System.out.println("plese choose a car");}
	        });
	        add.setOnAction(e->{
	        	rv.setVisible(true);
	        });
	        /////
	        Edit.setOnAction(e->{
	        	admin(editrow);
	        });
	        Delete.setOnAction(e->{
	        	Node save=node;
	        	node=(Node) node.next;
	        	single=node.data;
	        	current=single.head;
	        	com.setValue(single.brand);
	        	table.getItems().clear();
	        	title.setText(single.brand);
	        	current=single.head;
	        	while(current!=null) {
		        	table.getItems().add(current.data);
		        	current=(application.linkedlist.Node) current.next;
		        }
	        	list.delete(save.data.brand);
	        });
	        deleteSelectetItem.setOnAction(e->{
	        	single.delete(table.getSelectionModel().getSelectedItem());
	        	current=single.head;
	        	com.setValue(single.brand);
	        	table.getItems().clear();
	        	title.setText(single.brand);
	        	current=single.head;
	        	while(current!=null) {
		        	table.getItems().add(current.data);
		        	current=(application.linkedlist.Node) current.next;
		        }
	        });
	        addItem.setOnAction(e->{
	        	addItem();
	        	single=node.data;
	        	current=single.head;
	        	com.setValue(single.brand);
	        	table.getItems().clear();
	        	title.setText(single.brand);
	        	current=single.head;
	        	while(current!=null) {
		        	table.getItems().add(current.data);
		        	current=(application.linkedlist.Node) current.next;
	        	}
	        	
	        });
	        EditItem.setOnAction(e->{
	        	EditItem(table.getSelectionModel().getSelectedItem(),table);
	        	
	        });
	        //////////
	        Save.setOnAction(e->{
	        	try {
					new operation().Save(list);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        });
	        ////////
	        EditBrand.setOnAction(e->{
	        	EditBrand();
	        });
	        AddBrand.setOnAction(E->{
	        	AddBrand();
	        });
	        /////////////
	        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	        root.setCenter(table);
	        root.setTop(row0);
	        root.setRight(vertivalleft);
	        root.setLeft(rv);
			root.getStylesheets().add(getClass().getResource("Clientstyle.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
	}
	public void fillarr() {
		PRICES.add("50K");
		PRICES.add("100K");
		PRICES.add("150K");
		PRICES.add("200K");
		PRICES.add("250K");
		PRICES.add("300K");
		PRICES.add("4000K");
	}
	public void fillCOL() {
		COLORS.add("RED");
		COLORS.add("BLACK");
		COLORS.add("BLUE");
		COLORS.add("WHITE");
		COLORS.add("GREEN");
		COLORS.add("SILVER");
		COLORS.add("GRAY");
	}
	public Node findNode(String brand) {
		while(node.data.brand.compareTo(brand)!=0) {
			node=(Node) node.next;
		}
		return node;
	}
	public ArrayList<car> filiter(String startYEAR,String endYEAR,String startPrice,String endPrice,String Color,linkedlist.Node node) {
		ArrayList<car> addcar=new ArrayList();
		current=node;
		while(current!=null) {
			if(Color!=null &&current.data.color.compareToIgnoreCase(Color)!=0) {
				current=(application.linkedlist.Node) current.next;
				continue;
			}
			if(startYEAR!=null &&(current.data.Year+"").compareTo(startYEAR)<0) {
				current=(application.linkedlist.Node) current.next;
				continue;
			}
			if(endYEAR!=null &&(current.data.Year+"").compareTo(endYEAR)>0) {
				current=(application.linkedlist.Node) current.next;
				continue;
			}
			if(startPrice!=null &&(current.data.Price.substring(0,current.data.Price.indexOf("K"))).compareTo(startPrice.substring(0,startPrice.indexOf("K")))<0) {
				current=(application.linkedlist.Node) current.next;
				continue;
			}
			if(endPrice!=null &&(current.data.Price.substring(0,current.data.Price.indexOf("K"))).compareTo(endPrice.substring(0,endPrice.indexOf("K")))>0) {
				current=(application.linkedlist.Node) current.next;
				continue;
			}
			addcar.add(current.data);
			current=(application.linkedlist.Node) current.next;
		}
		return addcar;
	}
	public void fillyear() {
		YEARS.add(2010+"");
		YEARS.add(2011+"");
		YEARS.add(2012+"");
		YEARS.add(2013+"");
		YEARS.add(2014+"");
		YEARS.add(2015+"");
		YEARS.add(2016+"");
		YEARS.add(2017+"");
		YEARS.add(2019+"");
		YEARS.add(2020+"");
		YEARS.add(2021+"");
		YEARS.add(2022+"");
		YEARS.add(2023+"");
	}
	public void admin(HBox Edit) {
    	VBox root1=new VBox(10);root1.setAlignment(Pos.CENTER);
    	Stage stage=new Stage();
    	Scene scene1=new Scene(root1,200,200);
    	Label title=new Label("Admin Login");title.setId("title");title.setPrefWidth(90);
    	title.setPrefWidth(90);
    	HBox row0=new HBox();row0.setAlignment(Pos.CENTER);
    	Label sname=new Label("Name");sname.setId("admin-sname");sname.setId("filters");sname.setPrefWidth(90);
    	TextField sName=new TextField();row0.getChildren().addAll(sname,sName);sName.setPrefWidth(90);
    	HBox srow1=new HBox();srow1.setAlignment(Pos.CENTER);
    	Label spassword=new Label("Password");spassword.setId("filters");spassword.setPrefWidth(90);
    	TextField sPassword=new TextField();srow1.getChildren().addAll(spassword,sPassword);sPassword.setPrefWidth(90);
    	stage.setScene(scene1);
    	Button login1=new Button("Login");
    	Label wrong=new Label("");
    	root1.getChildren().addAll(title,row0,srow1,login1,wrong);
    	root1.getStylesheets().add(getClass().getResource("adminlogin.css").toExternalForm());
    	login1.setOnAction(e->{
    		if(sName.getText().compareToIgnoreCase("Mohand")==0 && sPassword.getText().compareToIgnoreCase("mohand12345")==0) {
    			Edit.setVisible(true);
    			stage.close();
    		}
    		else {
    			wrong.setText("wrong Password Try Again");
    		}
    	});
    	stage.show();
	}
	public void AddBrand() {
		VBox root=new VBox();root.setAlignment(Pos.CENTER);
		Stage stgae=new Stage();
		Scene scene=new Scene(root,400,100);
		stgae.setScene(scene);
		HBox row0=new HBox();row0.setAlignment(Pos.CENTER);
		Label model=new Label("Brand Name");
		TextField Model=new TextField();row0.getChildren().addAll(model,Model);
		Button ADD=new Button("ADD");
		root.getChildren().addAll(row0,ADD);
		ADD.setOnAction(e->{
			list.insert(new car(Model.getText(), null, 0, null, null));
			stgae.close();
		});
		stgae.show();
	}
	public void EditBrand() {
		VBox root=new VBox();root.setAlignment(Pos.CENTER);
		Stage stgae=new Stage();
		Scene scene=new Scene(root,400,100);
		stgae.setScene(scene);
		HBox row0=new HBox();row0.setAlignment(Pos.CENTER);
		Label model=new Label("Brand Name");
		TextField Model=new TextField();row0.getChildren().addAll(model,Model);
		Model.setText(node.data.brand);
		Button ADD=new Button("EDIT");
		root.getChildren().addAll(row0,ADD);
		ADD.setOnAction(e->{
			node.data.brand=Model.getText();
			stgae.close();
		});
		stgae.show();
	}
	public void addItem() {
		VBox root=new VBox();root.setAlignment(Pos.CENTER);
		Stage stgae=new Stage();
		Scene scene=new Scene(root,400,100);
		stgae.setScene(scene);
		HBox row0=new HBox();row0.setAlignment(Pos.CENTER);
		
		VBox v0=new VBox();
		Label model=new Label("Model");
		TextField Model=new TextField();
		v0.getChildren().addAll(model,Model);
		
		VBox v1=new VBox();
		Label year=new Label("Year");
		TextField Year=new TextField();
		v1.getChildren().addAll(year,Year);
		
		VBox v2=new VBox();
		Label color=new Label("Color");
		TextField Color=new TextField();
		v2.getChildren().addAll(color,Color);
		
		VBox v3=new VBox();
		Label price=new Label("Price");
		TextField Price=new TextField();
		v3.getChildren().addAll(price,Price);
		
		row0.getChildren().addAll(v0,v1,v2,v3);
		Button add=new Button("Add");
		add.setOnAction(E->{
			list.insert(new car(node.data.brand,Model.getText(),Integer.parseInt(Year.getText()),Color.getText(),Price.getText()));
			stgae.close();
		});
		root.getChildren().addAll(row0,add);
		stgae.show();
	}
	public void EditItem(car data,TableView table) {
		car data1=new car(null, null, 0, null, null);
		VBox root=new VBox();root.setAlignment(Pos.CENTER);
		Stage stgae=new Stage();
		Scene scene=new Scene(root,400,100);
		stgae.setScene(scene);
		HBox row0=new HBox();row0.setAlignment(Pos.CENTER);
		
		VBox v0=new VBox();
		Label model=new Label("Model");
		TextField Model=new TextField(data.getModel());
		v0.getChildren().addAll(model,Model);
		
		VBox v1=new VBox();
		Label year=new Label("Year");
		TextField Year=new TextField(data.getYear()+"");
		v1.getChildren().addAll(year,Year);
		
		VBox v2=new VBox();
		Label color=new Label("Color");
		TextField Color=new TextField(data.getColor());
		v2.getChildren().addAll(color,Color);
		
		VBox v3=new VBox();
		Label price=new Label("Price");
		TextField Price=new TextField(data.getPrice());
		v3.getChildren().addAll(price,Price);
		
		row0.getChildren().addAll(v0,v1,v2,v3);
		Button edit=new Button("Edit");
		edit.setOnAction(e->{
			data1.color=Color.getText();
			data1.Price=Price.getText();
			data1.Model=Model.getText();
			data1.Year=Integer.parseInt(Year.getText());
			single.edit(data, data1);
        	table.getItems().clear();
        	current=single.head;
        	while(current!=null) {
	        	table.getItems().add(current.data);
	        	current=(application.linkedlist.Node) current.next;
	        }
        	current=node.data.head;
			stgae.close();
		});
		root.getChildren().addAll(row0,edit);
		stgae.show();
	}
}
