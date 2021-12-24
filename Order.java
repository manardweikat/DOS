package com.example.Order;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class Order {


        @RequestMapping(value = "/purchase/{id}",method = RequestMethod.PUT)
        public @ResponseBody String name(@PathVariable int id) throws IOException {

            File file =new File("C:/Spring-Temp/Catalog/book.txt");
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            StringBuffer stringBuffer=new StringBuffer();
            String book; List<String> book1=new ArrayList<>();String oldnum; String new_n="";
            String res="purchase request fail";
            while ((book=bufferedReader.readLine())!=null){
                book1= Arrays.asList(book.split(","));
                if(book1.get(0).equals(String.valueOf(id))) {
                    if (Integer.parseInt(book1.get(3)) > 0) {
                        oldnum = book1.get(3);
                        int newnum = Integer.parseInt(oldnum) - 1;
                        new_n = String.valueOf(newnum);
                        book = book.replace(oldnum, new_n);
                        res = "purchase request done";
                    }
                }
                stringBuffer.append(book);
                stringBuffer.append("\n");
            }
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write(stringBuffer.toString());
            bufferedReader.close();
            fileWriter.close();

            return res;

    }
}
