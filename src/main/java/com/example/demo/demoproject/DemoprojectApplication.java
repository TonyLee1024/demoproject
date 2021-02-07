package com.example.demo.demoproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.dao")
public class DemoprojectApplication {

    public static void main(String[] args) {
        System.out.println("-------Hello,World--------");
        SpringApplication.run(DemoprojectApplication.class, args);
    }

}
