package com.innova.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;

	@Column(name = "order_amount")
	private int orderAmount;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_color")
	private Colors orderColor;

	@Column(name = "order_size")
	private int orderSize;

	public Order(int id, int orderAmount, Colors orderColor, int orderSize) {
		this.id = id;
		this.orderAmount = orderAmount;
		this.orderColor = orderColor;
		this.orderSize = orderSize;
	}

	public Order() {
	};

}
