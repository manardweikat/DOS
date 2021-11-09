package com.example.testdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class Catalog {


@GetMapping("/search")
public  @ResponseBody String search(@RequestParam String topic) throws IOException {
    File file =new File("book.txt");
    BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
    StringBuffer stringBuffer=new StringBuffer();
    stringBuffer.append("{\"Topic\":\""+topic+"\"");
    String book; List<String> book1=new ArrayList<>();String oldcost; String Content="";
    while ((book=bufferedReader.readLine())!=null){
        book1=Arrays.asList(book.split(","));
        if(book1.get(2).equals(topic)){
            stringBuffer.append("{\"id\":\""+book1.get(0)+",\"");
            stringBuffer.append("\"title\":\""+book1.get(1)+"\"},");
//            stringBuffer.append("\n");


        }

    }
    return stringBuffer.toString();
}

    @GetMapping("/info")
    public  @ResponseBody String info(@RequestParam String id) throws IOException {
        File file =new File("book.txt");
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("{\"item_number\":\""+id+"\"");
        String book; List<String> book1=new ArrayList<>();String oldcost; String Content="";
        while ((book=bufferedReader.readLine())!=null){
            book1=Arrays.asList(book.split(","));
            if(book1.get(0).equals(id)){
                stringBuffer.append("{\"title\":\""+book1.get(1)+"\",");
                stringBuffer.append("\"items_in_stock\":\""+book1.get(3)+"\",");
                stringBuffer.append("\"cost\":\""+book1.get(4)+"\"},");
//            stringBuffer.append("\n");


            }

        }
        return stringBuffer.toString();
    }

    @GetMapping("/book1")
    public @ResponseBody String name(@RequestParam String id,@RequestParam String cost) throws IOException {

        File file =new File("book.txt");
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
