package com.example.testdemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController



@RequestMapping("/api")
public class Controller2 {

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file) {
        if (null == file.getName()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            byte[] bytes =file.getBytes();
            Path path = Paths.get(file.getOriginalFilename());
            Path p=path.toAbsolutePath();
            Files.write(path, bytes);
            System.out.println(p);
            System.out.println(path.toRealPath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("Good Job", HttpStatus.OK);
    }

    @GetMapping("/test")
    public @ResponseBody String test(){
        return "Manar";
    }
}