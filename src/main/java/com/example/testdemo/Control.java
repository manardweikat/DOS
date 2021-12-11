package com.example.testdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;

@Controller
public class Control {

    @Autowired
    Catalogservices catalogservices;


    @GetMapping("/searchbook/topic/{topic}")
    public @ResponseBody String searchbook(@PathVariable String topic){
        return catalogservices.search(topic);
    }

    @GetMapping("/infobook/id/{id}")
    public @ResponseBody String infobook(@PathVariable int id){
        return catalogservices.info(id);
    }

    @GetMapping("/search/topic/{top}")
    public @ResponseBody String search(@PathVariable String top){
        final String uri = "http://localhost:8098/search/"+top;
        RestTemplate restTemplate=new RestTemplate();
        String r=restTemplate.getForObject(uri,String.class);
        return r;

    }

    @GetMapping("/info/id/{id}")
    public @ResponseBody String info(@PathVariable int id){
        final String uri = "http://localhost:8098/info/"+id;
        RestTemplate restTemplate=new RestTemplate();
        String r=restTemplate.getForObject(uri,String.class);
        return r;
    }

    @RequestMapping(value = "/purchase/id/{id}",method = RequestMethod.PUT)
    public @ResponseBody String purchase(@PathVariable int id){
        final String uri = "http://localhost:8099/purchase/"+id;

//        .exchange(
//                "http://localhost:8080/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
//    }
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> r=restTemplate.exchange(uri,HttpMethod.PUT,null,String.class);
//        .getForObject(uri,String.class);
        return r.getBody().toString();
    }
}
