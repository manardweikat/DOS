package com.example.Catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class Catalog {


@GetMapping("/search/{topic}")
public  @ResponseBody String search(@PathVariable String topic) throws IOException {
    File file =new File("book.txt");
    BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
    StringBuffer stringBuffer=new StringBuffer();
    stringBuffer.append("{\"Topic\":\""+topic+"\"");
    String book; List<String> book1=new ArrayList<>();String oldcost; String Content="";
    while ((book=bufferedReader.readLine())!=null){
        book1=Arrays.asList(book.split(","));
        if(book1.get(2).equals(topic)){
            stringBuffer.append("{\n\"id\":\""+book1.get(0)+",\"");
            stringBuffer.append("\n\"title\":\""+book1.get(1)+"\"}\n");
        }

    }

    return stringBuffer.toString();
}

    @GetMapping("/info/{id}")
    public  @ResponseBody String info(@PathVariable int id) throws IOException {
        File file =new File("book.txt");
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("{\"item_number\":\""+id+"\"\n");
        String book; List<String> book1=new ArrayList<>();String oldcost; String Content="";
        while ((book=bufferedReader.readLine())!=null){
            book1=Arrays.asList(book.split(","));
            if(book1.get(0).equals(String.valueOf(id))){
                stringBuffer.append("\"title\":\""+book1.get(1)+"\",\n");
                stringBuffer.append("\"items_in_stock\":\""+book1.get(3)+"\",\n");
                stringBuffer.append("\"cost\":\""+book1.get(4)+"\"}");
//            stringBuffer.append("\n");


            }

        }
        return stringBuffer.toString();
    }



}
