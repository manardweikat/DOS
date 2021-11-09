package com.example.testdemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TestdemoApplication {



public static List<Book> books=new ArrayList<>();
	public static void main(String[] args) {

		books.add(new Book(10,25,"How to get a good grade in DOS in 20 minutes a day","distributed systems"));
		books.add(new Book(10,20,"RPCs for Dummies","distributed systems"));
		books.add(new Book(10,30,"Xen and the Art of Surviving Graduate School","graduate school"));
		books.add(new Book(10,30,"Cooking for the Impatient Graduate Student","graduate school"));

		SpringApplication.run(TestdemoApplication.class, args);
	}

}
