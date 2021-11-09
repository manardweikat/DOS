package com.example.testdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class Catalog {
    List<Book> books=TestdemoApplication.books;

@GetMapping()
public  @ResponseBody String r(){
    String d="manar";
    d=d.replace("a","x");
    return d;
}

    @GetMapping("/book1")
    public @ResponseBody String name(@RequestParam String id,@RequestParam String cost) throws IOException {
        List<String>B=new ArrayList<>();
        File file =new File("books.txt");
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        StringBuffer stringBuffer=new StringBuffer();
        String book; List<String> book1=new ArrayList<>();String oldcost; String Content="";
        while ((book=bufferedReader.readLine())!=null){
            book1=Arrays.asList(book.split(","));
            if(book1.get(0).equals(id)){
                oldcost=book1.get(4);

               book= book.replace(oldcost,cost);
            }
            stringBuffer.append(book);
            stringBuffer.append("\n");
        }
        FileWriter fileWriter=new FileWriter(file);
        fileWriter.write(stringBuffer.toString());
        bufferedReader.close();
        fileWriter.close();


//        book1= Arrays.asList(B.get(0).split(","));
        return stringBuffer.toString();
    }
}
