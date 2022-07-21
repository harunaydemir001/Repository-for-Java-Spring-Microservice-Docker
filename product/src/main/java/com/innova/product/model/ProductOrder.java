package com.innova.product.model;

import java.util.List;

import lombok.Data;

@Data
public class ProductOrder {
	
private List<Product> product;
private List<Order> order;
}
