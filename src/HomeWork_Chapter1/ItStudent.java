/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeWork_Chapter1;

/**
 *
 * @author khalil
 */
public class ItStudent extends Student{

    public ItStudent(int id, String name,String major,double grade,double mid,double project,double final_exam) {
        this.id=id;
        this.name=name;
        this.major=major;
        this.grade=mid*0.30+project*0.30+final_exam*0.30;
    }
    
}
