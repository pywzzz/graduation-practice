package com.pywzzz.graduation_practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pywzzz.graduation_practice.mapper")
public class GraduationPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraduationPracticeApplication.class, args);
    }

}
