package com.innova.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;



import com.innova.order.model.Colors;
import com.innova.order.model.Order;
import com.innova.order.repository.OrderRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderApplication implements CommandLineRunner {
	@Autowired
	private OrderRepository orderRepository;


	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		Order first=new Order(1,5,Colors.WHITE,10);
		Order two=new Order(2,10,Colors.RED,20);
		Order three=new Order(3,15,Colors.GREEN,30);
		Order four=new Order(4,20,Colors.YELLOW,40);
		Order five=new Order(5,25,Colors.BLACK,50);
		
		orderRepository.save(first);
		orderRepository.save(two);
		orderRepository.save(three);
		orderRepository.save(four);
		orderRepository.save(five);
		
	}

}
