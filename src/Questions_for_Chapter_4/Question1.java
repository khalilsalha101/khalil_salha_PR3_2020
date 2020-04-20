/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions_for_Chapter_4;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author khalil
 */
public class Question1 extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String url="jdbc:mysql://127.0.0.1:3306/Student_DB?serverTimezone=UTC";
        String username="root";
        String password="";
        String sqlQuery="select * from student";
        Connection con=DriverManager.getConnection(url,username,password);
       // we used ResultSet.CONCUR_UPDATABLE for update through ResultSet in DataBase.
        Statement stat= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stat.executeQuery(sqlQuery);
        while(rs.next())
        {
            String addname="my name is ";
            String name=rs.getString("name");
            rs.updateString("name", addname+name);
            rs.updateRow();
            
        }
        
    }
    public static void main(String[] args) {
        launch(args);
    }
   
}
