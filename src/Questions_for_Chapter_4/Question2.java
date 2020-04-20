/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions_for_Chapter_4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author khalil
 */
public class Question2 extends Application{
    

    @Override
    public void start(Stage stage) throws Exception {
        TableView<Student> tableviewstd=new TableView<>();
        //Connect the ID Property with Table Column (tcId).
        TableColumn<Student,Integer>tcId=new TableColumn("id");
        tcId.setCellValueFactory(new PropertyValueFactory("id"));
         //Connect the Name Property with Table Column (tcName).
        TableColumn<Student,String>tcName=new TableColumn("name");
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        
        //Connect the gpa Property with Table Column (tcGPA).
        TableColumn<Student,String>tcGPA=new TableColumn("gpa");
        tcName.setCellValueFactory(new PropertyValueFactory("gpa"));
        
        //Add all table columns in table view.
        tableviewstd.getColumns().addAll(tcId,tcName,tcGPA);
       
       
        VBox vbox=new VBox(tableviewstd);
        
        Scene scene=new Scene(vbox);
        stage.setScene(scene);
        stage.show();
        
        
        
        
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
