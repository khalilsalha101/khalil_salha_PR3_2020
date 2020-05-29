/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeWork_Ch_7;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

/**
 *
 * @author khalil
 */
public class FileReader implements Callable<Map<String,Integer>>{

     String fileName;

    FileReader(String fileName){
        this.fileName=fileName;
    }
    @Override
    public Map<String, Integer> call() throws Exception {
         Map<String,Integer> map = new HashMap<>();
        Stream<String> stream = Files.lines(Paths.get(this.fileName));
        stream.forEach(
                line-> {
                    String data[] =line.split(" ");
                    for(int i=0;i<data.length;i++){
                        if(map.containsKey(data[i].trim())){
                            map.put(data[i].trim(),map.get(data[i].trim())+1);
                        }else{
                            map.put(data[i].trim(),1);
                        }
                    }
                }
        );

        return map;
    }
    
}
