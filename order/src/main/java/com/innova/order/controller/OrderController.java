package com.innova.order.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innova.order.model.Order;
import com.innova.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping
	public List<Order> getAllOrders() {
			return orderService.getAllOrders();	
	}

	@PostMapping
	public Order saveOneOrder(@RequestBody Order newOrder) {// User bazlı olarak istenilen ürünler için renk ve boyut seçenekleri ile kullanıcının girdiği adet üzerinden şipariş emrini oluşturan backend servisi.
		return orderService.saveOneOrder(newOrder);
	}
	
	@PostMapping("/createOneOrder/{productId}")
	public Order createOneOrder(@PathVariable(name="productId") int productId,@RequestBody Order newOrder) {
		return createOneOrder(productId, newOrder);
	}
	
	@GetMapping("/{orderId}")
	public Order getOneOrder(@PathVariable int orderId) {
		return orderService.getOneOrderById(orderId);
	}
	
	@PutMapping("/{orderId}")
	public Order updateOneOrder(@PathVariable int orderId, @RequestBody Order newOrder) {
		return orderService.updateOneOrder(orderId, newOrder);
	}
	
	

	@DeleteMapping("/{orderId}")
	public void deleteOneOrder(@PathVariable int orderId) {
		orderService.deleteOneOrderById(orderId);
	}

}
