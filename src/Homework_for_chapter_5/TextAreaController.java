/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_for_chapter_5;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * FXML Controller class
 *
 * @author khalil
 */
public class TextAreaController implements Initializable {

    @FXML
    private TextArea textArea_Query;
    @FXML
    private TableView<Student> tableviewstd;
    @FXML
    private TableColumn<Student,Integer> tcstd;
    @FXML
    private TableColumn<Student, String> tcsname;
    @FXML
    private TableColumn<Student, String> tcmajor;
    @FXML
    private TableColumn<Student, Double> tcgrade;
    @FXML
    private Button buttoncreatequery;
    @FXML
    private Button buttonReset;
    private EntityManagerFactory emf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcstd.setCellValueFactory(new PropertyValueFactory("sid"));
        tcsname.setCellValueFactory(new PropertyValueFactory("sname"));
        tcmajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcgrade.setCellValueFactory(new PropertyValueFactory("grade"));
        this.emf = Persistence.createEntityManagerFactory("PR3_2020PU");
  
    }    

    @FXML
    private void buttoncreatequeryHandle(ActionEvent event) {
        try{
            String sql =textArea_Query.getText();
        EntityManager em=emf.createEntityManager();
        List<Student> std=em.createQuery(sql).getResultList();
        tableviewstd.getItems().setAll(std);
     }
        catch(Exception ex)
        {
            Alert a= new Alert(Alert.AlertType.ERROR);
            a.setContentText(ex.getMessage());
            a.showAndWait();
        }
       
        
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        textArea_Query.setText("");
    }
        private void referachTable()
    {
        tcstd.setCellValueFactory(new PropertyValueFactory("sid"));
        tcsname.setCellValueFactory(new PropertyValueFactory("sname"));
        tcmajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcmajor.setCellValueFactory(new PropertyValueFactory("grade"));
        this.emf = Persistence.createEntityManagerFactory("PR3_2020PU");
        EntityManager em=emf.createEntityManager();
        List<Student> std=em.createNamedQuery("Student.showall").getResultList();
        tableviewstd.getItems().setAll(std);
        
    }
     
}
