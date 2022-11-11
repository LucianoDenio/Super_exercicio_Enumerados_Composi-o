package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> cart = new ArrayList<>();
	
	public Order() {
	}
	
	public Order (Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addItem(OrderItem item ) {
		cart.add(item);
	}
	
	public void removeItem(OrderItem item) {
		cart.remove(item);
	}
	
	public Double total() {
		double total = 0;
		for(OrderItem c : cart) {
			total += c.subTotal();		
		}
		return total;
	}
	
	

}
