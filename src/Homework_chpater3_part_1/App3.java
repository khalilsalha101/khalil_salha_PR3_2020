/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_chpater3_part_1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author khalil
 */
public class App3 extends Application{
 private ListView<Student>lst;
    @Override
    public void start(Stage stage) throws Exception {
    Label lbl1=new Label("Student Data");
        Label lbl2=new Label("id");
        Label lbl3=new Label("Name");
        Label lbl4=new Label("Major");
        Label lbl5=new Label("Grades");
        TextField txtId=new TextField();
        TextField txtName=new TextField();
        TextField txtMajor=new TextField();
        TextField txtGrade=new TextField();
        Button btnAdd=new Button("Add");
        Button btnReset=new Button("Reset");
        Button btnExit=new Button("Exit");
        
        
        HBox hbox1=new HBox(20,lbl2,txtId);
        
        HBox hbox2=new HBox(10,lbl3,txtName);
        HBox hbox3=new HBox(10,lbl4,txtMajor);
        HBox hbox4=new HBox(10,lbl5,txtGrade);
        HBox hbox5=new HBox(10,btnAdd,btnReset,btnExit);
        hbox5.setPadding(new Insets(0,0,0,65));
        lst=new ListView<>();
        lst.setPrefWidth(200);
        lst.setPrefHeight(100);
        VBox vbox1=new VBox(10,lbl1,hbox1,hbox2,hbox3,hbox4,hbox5);
        vbox1.setPadding(new Insets(20, 20, 20, 20));
        HBox hbox6=new HBox(vbox1,lst);
        hbox6.setAlignment(Pos.CENTER);
        hbox6.setPadding(new Insets(40));
        btnAdd.setOnAction((ActionEvent event) -> {
            if(event.getSource()==btnAdd)
                if(!txtId.getText().equals("") && !txtName.getText().equals("") && !txtMajor.getText().equals("") && !txtGrade.getText().equals(""))
                {
                    int id=Integer.valueOf(txtId.getText());
                    double grade=Double.valueOf(txtGrade.getText());
                    String name=txtName.getText();
                    String major=txtMajor.getText();
                    Student std=new Student(id,name,major,grade);
                    lst.getItems().add(std);
                }
        });
        btnReset.setOnAction((ActionEvent t) -> {
            if(t.getSource()==btnReset)
            {
                txtId.setText("");
                txtName.setText("");
                txtMajor.setText("");
                txtGrade.setText("");
            }
        });
        btnExit.setOnAction((ActionEvent t) -> {
            System.exit(0);
        });
        
        
        Scene scene=new Scene(hbox6);
        stage.setScene(scene);
        scene.getStylesheets().add("Style.css");
        stage.setTitle("Student Entry Page");
        stage.show();
       
    
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
