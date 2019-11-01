package edu.yctc.genesis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("edu.yctc.genesis.*") //开启mapper接口扫描
@EnableScheduling

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
