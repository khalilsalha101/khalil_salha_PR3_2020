/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_for_chapter_5;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author khalil
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Student.showall",query = "Select s from Student s"),
   // @NamedQuery(name="Student.updatestudent",query = "update Student s set s.sname= :sname,s.major= :major,s.grade= :grade where s.sid= :sid")

})
public class Student implements Serializable {
    @Id
    private Integer sid;
    private String sname;
    private String major;
    private Double grade;

    public Student()
    {
        
    }

    public Student(Integer sid, String sname, String major, Double grade) {
        this.sid = sid;
        this.sname = sname;
        this.major = major;
        this.grade = grade;
    }
  

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
    
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
    
}
