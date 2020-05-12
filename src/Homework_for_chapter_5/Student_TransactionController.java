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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
    private TableView<Student> tableviewstd;
    @FXML
    private TableColumn<Student,Integer> tcSID;
    @FXML
    private TableColumn<Student,String> tcSNAME;
    @FXML
    private TableColumn<Student,String> tcMjo;
    @FXML
    private TableColumn<Student,Double> tcGRADE;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonEdit;
    @FXML
    private Button buttonDelete;
    private EntityManagerFactory emf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcSID.setCellValueFactory(new PropertyValueFactory("sid"));
        tcSNAME.setCellValueFactory(new PropertyValueFactory("sname"));
        tcMjo.setCellValueFactory(new PropertyValueFactory("major"));
        tcGRADE.setCellValueFactory(new PropertyValueFactory("grade"));
        this.emf = Persistence.createEntityManagerFactory("PR3_2020PU");
        EntityManager em=emf.createEntityManager();
        List<Student> std=em.createNamedQuery("Student.showall").getResultList();
        tableviewstd.getItems().setAll(std);
        tableviewstd.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedStudent()
          );
       
        
    }    

    @FXML
    private void buttonAddHandle(ActionEvent event) {
        Student std = new Student(Integer.parseInt(txtsid.getText()),txtsname.getText(),txtmajor.getText(),Double.parseDouble(txtgrade.getText()));
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(std);
        em.getTransaction().commit();
        em.close();
        tableviewstd.getItems().clear();
        referachTable();
    }

    @FXML
    private void buttonEditHandle(ActionEvent event) {
        EntityManager em=this.emf.createEntityManager();
       em.getTransaction().begin();
        Query query=em.createQuery("update Student s set s.sname= :sname,s.major= :major,s.grade= :grade where s.sid= :sid");
        
        query.setParameter("sid",Integer.parseInt(txtsid.getText()))
                .setParameter("sname",txtsname.getText())
                .setParameter("major",txtmajor.getText())
                .setParameter("grade", Double.parseDouble(txtgrade.getText()));
        query.executeUpdate();
        
        em.getTransaction().commit();
        tableviewstd.getItems().clear();
        referachTable();
        
       
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) {
        EntityManager em=this.emf.createEntityManager();
       em.getTransaction().begin();
        Query query=em.createQuery("Delete from Student s where s.sid= :sid");
        
        query.setParameter("sid",Integer.parseInt(txtsid.getText()));
                
        query.executeUpdate();
        
        em.getTransaction().commit();
        tableviewstd.getItems().clear();
        referachTable();
    }
    private void referachTable()
    {
        tcSID.setCellValueFactory(new PropertyValueFactory("sid"));
        tcSNAME.setCellValueFactory(new PropertyValueFactory("sname"));
        tcMjo.setCellValueFactory(new PropertyValueFactory("major"));
        tcGRADE.setCellValueFactory(new PropertyValueFactory("grade"));
        this.emf = Persistence.createEntityManagerFactory("PR3_2020PU");
        EntityManager em=emf.createEntityManager();
        List<Student> std=em.createNamedQuery("Student.showall").getResultList();
        tableviewstd.getItems().setAll(std);
        
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
