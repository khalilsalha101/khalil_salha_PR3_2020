/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeWork_Chapter2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author khalil
 */
public class Login extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
         Label lbl1=new Label("Welcome");
         Label lbl2=new Label("User Name :");
         Label lbl3=new Label("Password :");
         HBox hbox1=new HBox(20,lbl1);
         hbox1.setAlignment(Pos.CENTER);
         TextField txtusername=new TextField();
         PasswordField txtPassword=new PasswordField();
         Button btnSign=new Button("Sign in");
         Button btnExit=new Button("Exit");
         HBox hbox=new HBox(20,lbl2,txtusername);
         hbox.setAlignment(Pos.CENTER);
         HBox hbox2=new HBox(20,lbl3,txtPassword);
         hbox2.setAlignment(Pos.CENTER);
         HBox hbox3=new HBox(10,btnSign,btnExit);
         hbox3.setAlignment(Pos.TOP_RIGHT);
         hbox3.setPadding(new Insets(25));
         
         
         VBox vbox=new VBox(10,hbox1,hbox,hbox2,hbox3);
         vbox.setAlignment(Pos.CENTER);
         Scene scene=new Scene(vbox,300,300);
         
         lbl1.getStyleClass().add("lblwe");
         scene.getStylesheets().add("Style.css");
         primaryStage.setScene(scene);
         primaryStage.show(); 
         
         
         
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
