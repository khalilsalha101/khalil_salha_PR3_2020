/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeWork_Chapter1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author khalil
 */
public class Assigment1 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Student[]students={
            new ItStudent(1, "khalil", "SDEV",90,30,50,60),
            new ItStudent(2, "Ahmed","CS",90,30,50,60),
            new ItStudent(1, "karami", "MOB",90,30,50,60),
            new ArtStudent(4,"ibrahim","Art",80,40,50,70)
        };
        List<Student> stdlist=Arrays.asList(students).stream().sorted(Comparator.comparing(Student::getGrade).reversed()).collect(Collectors.toList());
        
        PrintWriter pw= new PrintWriter(new FileOutputStream("student.txt"));
        for(Student std:stdlist)
            pw.println(std.getId()+" "+std.getName()+" "+std.getMajor());
        pw.close();
        
    }
    
}
