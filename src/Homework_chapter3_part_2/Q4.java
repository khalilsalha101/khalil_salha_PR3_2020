/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_chapter3_part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class Q4 extends Application{
    public static void main(String[] args) {
        launch(args);
    }

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
        List<Student>lststd=new ArrayList();
        ListView<Student>std=new ListView<>();
        std.getItems().addAll(lststd);
        std.setPrefWidth(200);
        std.setPrefHeight(100);
        VBox vbox1=new VBox(10,lbl1,hbox1,hbox2,hbox3,hbox4,hbox5);
        vbox1.setPadding(new Insets(20, 20, 20, 20));
        HBox hbox6=new HBox(vbox1,std);
        hbox6.setAlignment(Pos.CENTER);
        hbox6.setPadding(new Insets(40));
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent t) {
                 if(t.getSource()==btnAdd)
                 {
                   if(!txtId.getText().equals("") && !txtName.getText().equals("") && !txtMajor.getText().equals("") && !txtGrade.getText().equals(""))
                {
                    int id=Integer.valueOf(txtId.getText());
                    double grade=Double.valueOf(txtGrade.getText());
                    String name=txtName.getText();
                    String major=txtMajor.getText();
                    Student student=new Student(id,name,major,grade);
                    
                    std.getItems().add(student);
                    //Q4-A:Use lambdas and streams to sort the Student objects by name, then show the results
                    std.getItems().setAll(
                            std.getItems().stream()
                            .sorted(Comparator.comparing(Student::getName))
                            .collect(Collectors.toList())
                    
                    );
                    //Q4-B:Use lambdas and streams to map each Student to its name and grade, sort the results by grade (descending), then display the results. 
                    std.getItems().setAll(
                            std.getItems().stream()
                            .sorted(Comparator.comparing(e->-(e.getGrade())))
                            .collect(Collectors.toList())
                    
                    );
                    //Q4-C:Use lambdas and streams to map each Student to its name and grade, to select the Students who have grade values in the range 80 to 90. Sort the results by grade value (descending), then show the results
                    std.getItems().setAll(
                    std.getItems().stream().filter(e->e.getGrade()>=80 ||e.getGrade()<=90)
                            .sorted(Comparator.comparing(e->-(e.getGrade())))
                            .collect(Collectors.toList())
                    
                    );
                //Q4-E: Use lambdas and streams to group Students by major, then show the results. 
                   std.getItems().setAll((Collection<? extends Student>) std.getItems().stream().collect(Collectors.
                    groupingBy(Student::getMajor)));
     }
    }
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
        
        Scene s=new Scene(hbox6);
        stage.setScene(s);
        stage.show();
    }
    
}
