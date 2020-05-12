/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_for_chapter_5;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author khalil
 */
public class Student_App extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       Pane paneStudent= FXMLLoader.load(getClass().getResource("Student_Transaction.fxml")); 
        Pane paneTextArea= FXMLLoader.load(getClass().getResource("TextArea.fxml")); 
       Map<String, Pane> mapPanes = new TreeMap<>();
       mapPanes.put("textarea", paneTextArea);
      mapPanes.put("studentapp", paneStudent);
           Scene scene = new Scene(mapPanes.get("studentapp"));
        primaryStage.setTitle("Student App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
