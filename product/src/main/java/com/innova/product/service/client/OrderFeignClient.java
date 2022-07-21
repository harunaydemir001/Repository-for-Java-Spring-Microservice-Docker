package com.innova.product.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.innova.product.model.Order;


@FeignClient(value = "order", url = "http://localhost:8080/order")
public interface OrderFeignClient {
	
	@GetMapping("/{orderId}")
    Order getOneOrder(@PathVariable int orderId);
	
	@GetMapping
	public List<Order> getAllOrders();
}