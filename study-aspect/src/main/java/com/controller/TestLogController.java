package com.controller;

import com.annotion.BaOperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author cyq
 * @date 2020-04-08
 */
@RestController
@SpringBootApplication(scanBasePackages = {
        "com.*"
})
@EnableAspectJAutoProxy
public class TestLogController {
@Autowired
Service1 service1;
    @GetMapping("/")
    public void testLog(@RequestParam String a){
        System.out.println("a");
        service1.a();
//        boolean ret = testLog1(a);
    }

    public boolean testLog1( String a){
        System.out.println("a");
        return true;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext("2");
//        SpringApplication.run(TestLogController.class, args);
    }
}
