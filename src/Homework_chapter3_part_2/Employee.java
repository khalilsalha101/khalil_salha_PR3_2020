/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_chapter3_part_2;

/**
 *
 * @author khalil
 */
public class Employee {
   private int id;
   private String name;
   private String department;
   private double salary;
  public Employee(int id, String name, String department, double salaray) {
   this.id = id;
   this.name = name;
   this.department = department;
   this.salary = salaray;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    

}
