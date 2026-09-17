package org.example.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringTestApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext context =  SpringApplication.run(SpringTestApplication.class, args);
//        ProductService productService = context.getBean(ProductService.class);
//        productService.printAllProducts();
//        productService.createProduct();
    }
}