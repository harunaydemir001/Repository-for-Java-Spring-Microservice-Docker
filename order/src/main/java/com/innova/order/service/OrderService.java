package com.innova.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.innova.order.model.Order;
import com.innova.order.model.Product;
import com.innova.order.repository.OrderRepository;
import com.innova.order.service.client.ProductFeignClient;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	private ProductFeignClient productFeignClient;

	public OrderService(OrderRepository orderRepository, ProductFeignClient productFeignClient) {
		super();
		this.orderRepository = orderRepository;
		this.productFeignClient = productFeignClient;
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order saveOneOrder(Order newOrder) {
		return orderRepository.save(newOrder);

	}

	public Order createOneOrder(int productId, Order newOrder) {

		Product product = productFeignClient.getOneProduct(productId);

		if (newOrder.getOrderSize() == product.getSize() && newOrder.getOrderColor() == product.getColor()) {
			return orderRepository.save(newOrder);
		} else {
			return null;
		}

	}

	public Order getOneOrderById(int orderId) {
		return orderRepository.findById(orderId).orElse(null);
	}

	public Order updateOneOrder(int orderId, Order newOrder) {
		Optional<Order> order = orderRepository.findById(orderId);
		if (order.isPresent()) {
			Order foundOrder = order.get();
			foundOrder.setOrderAmount(newOrder.getOrderAmount());
			foundOrder.setOrderColor(newOrder.getOrderColor());
			foundOrder.setOrderSize(newOrder.getOrderSize());
			orderRepository.save(foundOrder);
			return foundOrder;
		} else {
			return null;
		}
	}

	public void deleteOneOrderById(int orderId) {
		orderRepository.deleteById(orderId);

	}

}
