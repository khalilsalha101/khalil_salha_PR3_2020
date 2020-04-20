/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions_for_Chapter_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author khalil
 */
public class Question3 extends Application{
//Used Prepared Statement 
    @Override
    public void start(Stage stage) {
     try
        {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String url="jdbc:mysql://127.0.0.1:3306/student_db?serverTimezone=UTC";
        String username="root";
        String password="";
        Connection con=DriverManager.getConnection(url,username,password);
        Scanner in=new Scanner(System.in);
        System.out.println("Enter id:");
        int id=in.nextInt();
        System.out.println("Enter Name:");
        String name=in.next();
        System.out.println("Enter Gpa:");
        Double gpa=in.nextDouble();
        String sqlQuery="insert into student values(?,?,?)";
        PreparedStatement preparedstat=con.prepareStatement(sqlQuery);  
        preparedstat.setInt(1,id);
        preparedstat.setString(2,name);
        preparedstat.setDouble(3,gpa);
        int i=preparedstat.executeUpdate();
        System.out.println(i+" records inserted");  
    }
    catch(Exception e)
    {
            e.printStackTrace();
    }
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
