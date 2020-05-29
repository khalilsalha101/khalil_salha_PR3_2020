/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeWork_Ch_7;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
/**
 *
 * @author khalil
 */
public class Multithreading {
    public static void main(String[] args) throws ExecutionException,
     InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<FileReader> list = new ArrayList<>();
        List<Future<Map<String,Integer>>> result = new ArrayList<>();
        Map<String,Integer> finalResult = new HashMap<>();

        //adding files to list
        String folderPath = "C:\\Users\\khalil\\Desktop\\PR3_2020\\src\\HomeWork_Ch_7\\Files";
        File file = new File(folderPath);
        File[] listOfFiles = {};
        if(!file.isFile()){
            listOfFiles = file.listFiles();
        }

        for(int i=0;i<listOfFiles.length;i++){
            list.add(new FileReader(listOfFiles[i].getAbsolutePath()));
        }

        //submitting task with callable
       for(int i=0;i<list.size();i++){
            result.add(executorService.submit(list.get(i)));
       }

        //calculating result
       for(int i=0;i<result.size();i++){
           Map<String,Integer> temp = result.get(i).get();
           temp.forEach(
                   (k,v)->{
                       if(finalResult.containsKey(k)){
                           finalResult.put(k,finalResult.get(k)+v);
                       }else{
                           finalResult.put(k,v);
                       }
                   }
           );
       }

        System.out.println(finalResult);
        executorService.shutdown();
    }
   
   }

