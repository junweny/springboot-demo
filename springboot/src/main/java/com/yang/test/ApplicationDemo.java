package com.yang.test;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@EnableAsync
@SpringBootApplication
public class ApplicationDemo {
	
	public static void main(String[] args) throws Exception {
        System.out.println(" springApplication run !");
        //SpringApplication springApplication = new SpringApplication(ApplicationDemo.class);
        //禁止命令行设置参数
        //springApplication.setAddCommandLineProperties(false);
        //springApplication.run(args);
        SpringApplication.run(ApplicationDemo.class, args);
    }
	
	
	@RequestMapping(value = "/yang")
    String home() {
        return "Hello World!";
    }
}
