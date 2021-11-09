package com.example.testdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.*;

@org.springframework.stereotype.Controller
public class Controller{
    List<String> users= new ArrayList<String>();
    List<String> pass= new ArrayList<String>();//) Arrays.asArrayList(new String[]{"123", "456", "789"});
    List<List<String>>items=new ArrayList<List<String>>() ;



    List<String> company=new ArrayList<String>();
    List<String >number=new ArrayList<String>();
    List<String >price=new ArrayList<String>();
    List<List<String>>data=new ArrayList<List<String>>() ;



    @GetMapping("")
    public @ResponseBody
    String signin(@RequestParam(value = "username", defaultValue = "name") String username,@RequestParam(value = "password",defaultValue = "000000") String password) {
        for (int i = 0; i < users.stream().count(); i++) {
            if (username.equals(users.get(i)) && password.equals(pass.get(i)))
                return "user";
         //   else return "not user";
        }
        return "";
    }

    @GetMapping("signup")
    public @ResponseBody
    String signup(@RequestParam String username,@RequestParam String password,@RequestParam String email) {
            if (username.length()>0 && password.length()>0&&email.length()>0){
                users.add(username);
                pass.add(password);

        return "sign";}
            else return "";
    }

    @JsonProperty(value = "items",required = true)
    @GetMapping(value = "mainpage",produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<List<String>> mainitem(){
        List<String> logo =new ArrayList<String>();
        logo.add( "https://www.jawwal.ps/web/images/jawwal-logo-new.png");
        logo.add("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Ooredoo.svg/1200px-Ooredoo.svg.png");
        logo.add("https://cdn.icon-icons.com/icons2/836/PNG/512/Android_icon-icons.com_66772.png");
        logo.add( "https://cdn0.iconfinder.com/data/icons/zoldo-miscellaneous-002/64/mac_apple_os_ios_logo-512.png");
        items.add(logo);
        List <String>name=new ArrayList<String>();
        name.add("Jawwal");name.add("Oredoo");
        name.add("Android"); name.add("IOS");
        items.add(name);
        return  items;


    }


 /*   @GetMapping("data")
    public @ResponseBody String data(){
        String d=null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
           // Connection con= DriverManager.getConnection("jdbc:mysql//localhost:3306/tarain","root","");

          //  PreparedStatement ps=con.prepareStatement("SELECT * FROM user");
           // ResultSet rs=ps.executeQuery();
            d=rs.getString(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return d;
    }*/

    @GetMapping("charge")
    public @ResponseBody
    String charge(@RequestParam String comp,@RequestParam String num,@RequestParam String pr) {
        if(num.length()==10){
            company.add(comp);
            number.add(num);
            price.add(pr);
            return "done";
        }
        else return "number not correct";
    }

    @GetMapping(value = "ndata")
    public @ResponseBody
    List<List<String>> ndata(){
        data.add(company);
        data.add(number);
        data.add(price);
        return  data;


    }

    @GetMapping("test")
    public @ResponseBody
    String test(@RequestParam String m) {
        return String.format( "Welcome %s",m);
    }

}
