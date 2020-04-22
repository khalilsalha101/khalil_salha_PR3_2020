/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_for_chapter_4;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author khalil
 */
public class Student_APP extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Pane paneStudent= FXMLLoader.load(getClass().getResource("Student_Transaction.fxml"));
         Pane paneTextArea= FXMLLoader.load(getClass().getResource("TextAreaQuery.fxml"));
        
        Map<String, Pane> mapPanes = new TreeMap<>();
        mapPanes.put("student_tran", paneStudent);
        mapPanes.put("textarea", paneTextArea);
        
        Scene scene = new Scene(mapPanes.get("textarea"));
        stage.setTitle("Student App");
        stage.setScene(scene);
        stage.show();
      
              
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    private Parent mapPaneget(String student_Transaction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
