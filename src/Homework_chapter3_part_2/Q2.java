/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_chapter3_part_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author khalil
 */
public class Q2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
        /*TreeMap<Character, Integer> hashMap = new TreeMap<>();
        File file = new File("C:\\Users\\khalil\\Desktop\\khalil_salha_120181882_Assigment4\\Assigment4\\src\\assigment4\\myfile.txt");
        Scanner scanner = new Scanner(file,"utf-8");
        while (scanner.hasNext()) {
            char[] chars = scanner.nextLine().toLowerCase().toCharArray();
            for (Character c : chars) {
                if(!Character.isLetter(c)){
                    continue;
                }
                else if (hashMap.containsKey(c)) {
                    hashMap.put(c, hashMap.get(c) + 1);
                } else {
                    hashMap.put(c, 1);
                }
            }
        }
        hashMap.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });*/
  Pattern p = Pattern.compile("\\s+");
try {
	Files.lines(Paths.get("test.txt"))
                
	.flatMap(line -> p.splitAsStream(line))		.collect(Collectors
                 .groupingBy(String::toUpperCase,                             
                             Collectors.counting()
                             )
                )
	.forEach((word,count) -> 
                 System.out.println(word+" : " + count));
} catch (IOException e) {
	e.printStackTrace();
}


    }
}
