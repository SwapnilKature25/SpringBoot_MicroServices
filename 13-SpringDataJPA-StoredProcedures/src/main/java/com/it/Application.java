package com.it;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.it.entity.Product;
import com.it.repository.ProductRepository;

@SpringBootApplication
public class Application {

    private final ProductRepository productRepository;

    Application(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
	
		ProductRepository productRepository = context.getBean(ProductRepository.class);
		
		List<Product> allProducts = productRepository.getAllProducts();
		allProducts.forEach(System.out::println);

	}
}

/*
Hibernate: call getProducts()
Product [productId=2, productName=Mouse, productPrice=500.0]
Product [productId=101, productName=Mouse, productPrice=500.0] 

 
 
*/
