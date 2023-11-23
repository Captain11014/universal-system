package com.universal.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.universal.system.mapper")
public class UniversalSystemApplication {


    public static void main(String[] args) {
        SpringApplication.run(UniversalSystemApplication.class, args);
        System.out.println("==========程序启动==========");
    }


}
