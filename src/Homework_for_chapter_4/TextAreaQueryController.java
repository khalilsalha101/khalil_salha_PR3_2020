/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_for_chapter_4;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author khalil
 */
public class TextAreaQueryController implements Initializable {

    @FXML
    private TextArea textArea_Query;
    @FXML
    private TableView<Student> tableviewstd;
    @FXML
    private TableColumn<Student,Integer> tcstd;
    @FXML
    private TableColumn<Student,String> tcsname;
    @FXML
    private TableColumn<Student,String> tcmajor;
    @FXML
    private TableColumn<Student,Double> tcgrade;
    @FXML
    private Button buttoncreatequery;
    @FXML
    private Button buttonReset;
    ResultSet rs;
    Statement statement;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
         
        Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chapter4db?serverTimezone=UTC","root","");
        this.statement=con.createStatement();
        
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        tcstd.setCellValueFactory(new PropertyValueFactory("sid"));
        tcsname.setCellValueFactory(new PropertyValueFactory("sname"));
        tcmajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcgrade.setCellValueFactory(new PropertyValueFactory("grade"));
        try {
             rs=this.statement.executeQuery("select * from Student");
                while(rs.next()){
                Student std = new Student();
                std.setSid(rs.getInt("sid"));
                std.setSname(rs.getString("sname"));
                std.setMajor(rs.getString("major"));
                std.setGrade(rs.getDouble("grade"));
                tableviewstd.getItems().add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student_TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
      
        
        
    }    

    @FXML
    private void buttoncreatequeryHandle(ActionEvent event) {
        tableviewstd.getItems().clear();
        referachTable();
    }
    public void referachTable()
    {
          try {
             rs=this.statement.executeQuery(textArea_Query.getText());
                while(rs.next()){
                Student std = new Student();
                std.setSid(rs.getInt("sid"));
                std.setSname(rs.getString("sname"));
                std.setMajor(rs.getString("major"));
                std.setGrade(rs.getDouble("grade"));
                tableviewstd.getItems().add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student_TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        textArea_Query.setText("");
    }
    
}
