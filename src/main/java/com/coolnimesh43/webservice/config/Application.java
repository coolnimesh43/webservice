package com.coolnimesh43.webservice.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

//@SpringCloudApplication
@SpringBootApplication(scanBasePackages = { "com.coolnimesh43.webservice" })
@EnableConfigurationProperties({ ThymeleafProperties.class })
@EnableEurekaClient
@EnableCircuitBreaker
@EnableAspectJAutoProxy
public class Application {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
        Environment env = configurableApplicationContext.getEnvironment();
        System.out.println("\n\n Starting WebService Server at \n");
        System.out.println("Localhost http://localhost:" + env.getProperty("server.port"));
        System.out.println("External http://" + InetAddress.getLocalHost().getHostAddress() + ":" + env.getProperty("server.port"));
    }
}
