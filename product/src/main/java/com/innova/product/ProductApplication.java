package com.innova.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.innova.product.model.Colors;
import com.innova.product.model.Product;
import com.innova.product.repository.ProductRepository;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ProductApplication implements CommandLineRunner {
	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product first = new Product(1, "Computer", 10, "Samsung", 100, 10000, Colors.WHITE);
		Product two = new Product(2, "Mouse", 20, "LG", 200, 500, Colors.RED);
		Product three = new Product(3, "Screen", 30, "Philips", 300, 200, Colors.GREEN);
		Product four = new Product(4, "Xbox", 40, "Microsoft", 400, 5000, Colors.YELLOW);
		Product five = new Product(5, "Playstation", 50, "Sony", 500, 6000, Colors.BLACK);
		
		productRepository.save(first);
		productRepository.save(two);
		productRepository.save(three);
		productRepository.save(four);
		productRepository.save(five);
	}

}
