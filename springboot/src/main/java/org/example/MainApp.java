package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        System.out.println("MainApp starting to run!");
        SpringApplication.run(MainApp.class, args);
    }
}