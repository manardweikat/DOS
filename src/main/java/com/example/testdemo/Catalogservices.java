package com.example.testdemo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Catalogservices {

    @Cacheable("catalog")
    public String search(String topic){
        try {
            System.out.println("sleep for 5 secs");
            Thread.sleep(1000*5);
        }
         catch (InterruptedException e) {
            e.printStackTrace();
        }


        final String uri = "http://localhost:8098/search/"+topic;
        RestTemplate restTemplate=new RestTemplate();
        String r=restTemplate.getForObject(uri,String.class);
        return r;

    }

    @Cacheable("catalog")
    public String info(int id){
        try {
            System.out.println("sleep for 5 secs");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


        final String uri = "http://localhost:8098/info/"+id;
        RestTemplate restTemplate=new RestTemplate();
        String r=restTemplate.getForObject(uri,String.class);
        return r;
    }


}
