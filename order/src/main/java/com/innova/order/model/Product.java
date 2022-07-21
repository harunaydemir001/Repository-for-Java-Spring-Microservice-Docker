package com.innova.order.model;

import lombok.Data;

@Data
public class Product {
	private String name;
	private int size;
	private String brand;
	private int stockNumber;
	private float price;
	private Colors color;
}
