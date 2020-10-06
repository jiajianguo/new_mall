package com.xdj.interfaces.mallinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Administrator
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.xdj"})
public class MallInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallInterfaceApplication.class, args);
    }
}
