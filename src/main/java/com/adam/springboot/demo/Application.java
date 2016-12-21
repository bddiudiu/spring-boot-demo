package com.adam.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by adam on 4/11/16.
 */

//@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
//@ImportResource({"classpath:dubbo.xml"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
