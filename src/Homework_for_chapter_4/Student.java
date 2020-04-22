/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_for_chapter_4;

/**
 *
 * @author khalil
 */
public class Student {
    private int sid;
    private String sname;
    private String major;
    private double grade;
    
    public Student()
    {
        
    }

    public Student(int sid, String sname, String major, double grade) {
        this.sid = sid;
        this.sname = sname;
        this.major = major;
        this.grade = grade;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    @Override
    public String toString()
    {
        return "Student id: "+sid+" student name: "+sname+" major: "+major+" grade"+grade;
    }
    
    
    
}
