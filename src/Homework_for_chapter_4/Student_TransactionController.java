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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author khalil
 */
public class Student_TransactionController implements Initializable {

    @FXML
    private TextField txtsid;
    @FXML
    private TextField txtsname;
    @FXML
    private TextField txtmajor;
    @FXML
    private TextField txtgrade;
    @FXML
    private TableColumn<Student,Integer> tcSID;
    @FXML
    private TableColumn<Student,String> tcSNAME;
    @FXML
    private TableColumn<Student, String> tcMjo;
    @FXML
    private TableColumn<Student,Double> tcGRADE;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonEdit;
    @FXML
    private Button buttonDelete;
    @FXML
    private TableView<Student> tableviewstd;
    
    Statement statement;
    ResultSet rs;
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
        
        tcSID.setCellValueFactory(new PropertyValueFactory("sid"));
        tcSNAME.setCellValueFactory(new PropertyValueFactory("sname"));
        tcMjo.setCellValueFactory(new PropertyValueFactory("major"));
        tcGRADE.setCellValueFactory(new PropertyValueFactory("grade"));
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
          tableviewstd.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedStudent()
          );
       
        
    }    

    @FXML
    private void buttonAddHandle(ActionEvent event)throws Exception{
        Integer sid=Integer.parseInt(txtsid.getText());
        String sname=txtsname.getText();
        String major=txtmajor.getText();
        Double grade=Double.parseDouble(txtgrade.getText());
        
   
        String sql2="Insert Into student values("+sid+",'"+sname+"','"+major+"',"+grade+")"; 
        this.statement.executeUpdate(sql2);
        
  
            tableviewstd.getItems().clear();
            referachTable();
        
             
         
    }

    @FXML
    private void buttonEditHandle(ActionEvent event) throws SQLException {
        Integer sid = Integer.parseInt(txtsid.getText());
        String sname = txtsname.getText();
        String major = txtmajor.getText();
        Double grade = Double.parseDouble(txtgrade.getText());
        String sql = "Update Student Set sname='" + sname + "', major='" + 
                major + "', grade=" + grade + " Where sid=" +sid;
        this.statement.executeUpdate(sql);
        
        tableviewstd.getItems().clear();
        
        referachTable();
    }
    

    @FXML
    private void buttonDeleteHandle(ActionEvent event) throws SQLException {
        Integer sid=Integer.parseInt(txtsid.getText());
        String sql="Delete from student where sid="+sid;
        this.statement.executeUpdate(sql);
        tableviewstd.getItems().clear();
        referachTable();
    }
    
    public void referachTable()
    {
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
    private void showSelectedStudent(){
        Student student = tableviewstd.getSelectionModel().getSelectedItem();
        if(student != null){
        txtsid.setText(String.valueOf(student.getSid()));
        txtsname.setText(student.getSname());
        txtmajor.setText(student.getMajor());
        txtgrade.setText(String.valueOf(student.getGrade()));
        }

    }
    
    
    
}
