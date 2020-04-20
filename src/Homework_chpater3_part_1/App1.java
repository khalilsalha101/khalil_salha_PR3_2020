/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_chpater3_part_1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author khalil
 */
public class App1 {
    public static void main(String[] args) {
        int[] random = new Random().ints(30, 0, 100).toArray();
        List<Integer>lst=new LinkedList<>();
               for(int item:random)
               {
                   lst.add(item);
                   
               }
            
               Collections.sort(lst);
               OptionalDouble  s1 = IntStream.of(random).average();
               System.out.println(lst.toString());
               System.out.println(s1);
    }
}
