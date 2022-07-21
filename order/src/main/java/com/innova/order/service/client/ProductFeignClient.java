package com.innova.order.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.innova.order.model.Product;

@FeignClient(value = "product", url = "http://localhost:8090/product")
public interface ProductFeignClient {
	
	@GetMapping("/{productId}")
	public Product getOneProduct(@PathVariable int productId);
	
	@PutMapping("/{productId}/{orderId}")
	public void updateStockNumber(@RequestBody  Product product, @PathVariable int orderId);
	
}
