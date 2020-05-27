package com.xupt.ttms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.xupt.ttms.mapper")
@SpringBootApplication
public class TtmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtmsApplication.class, args);
    }

}
