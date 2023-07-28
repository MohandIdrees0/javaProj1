package application;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;


public class Main extends Application {
	operation oper=new operation();
	@Override
	public void start(Stage primaryStage) {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1200,800);
			HBox row0=new HBox();row0.setAlignment(Pos.CENTER);
			Label title=new Label("Car Agency");
			row0.getChildren().add(title);
			title.getStyleClass().add("centered-label");
			VBox v0=new VBox();
			HBox row1=new HBox(150);row1.setAlignment(Pos.CENTER);
			Button readorders=new Button("Import Orders");readorders.setPrefWidth(150);
			Button readcars=new Button("Import Cars");readcars.setPrefWidth(150);
			row1.getChildren().addAll(readorders,readcars);

			HBox row2=new HBox(150);row2.setAlignment(Pos.CENTER);
			Button Clients=new Button("Client Section");Clients.setPrefWidth(150);
			Button Adimn=new Button("Admin Section");Adimn.setPrefWidth(150);
			row2.getChildren().addAll(Adimn,Clients);
			///////
			readcars.setOnAction(e->{
				try {
					//System.out.print(new FileChooser().showOpenDialog(primaryStage));
					oper.readfile();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			readorders.setOnAction(e->{
				try {
					//System.out.print(new FileChooser().showOpenDialog(primaryStage));
					oper.readfilefororders();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			Clients.setOnAction(e->{
				oper.clientpage();
			});
			Adimn.setOnAction(e->{
				oper.Adimnpage();
			});
			v0.getChildren().addAll(row2,row1);
			root.setTop(row0);
			root.setBottom(v0);
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
        launch(args);
	}
}
