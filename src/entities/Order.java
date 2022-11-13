package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // Mascara de formatação.
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	
	private List<OrderItem> items = new ArrayList<>(); // lista quando se tem um tipo tem varios.
	
	public Order() {
	}
	
	public Order (Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item ) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() { // Função que delega a responsabilidade de ter o preço total de produtos, mas, delega a outra classe a soma de quantos produtos se tem.
		double sum = 0.0;
		for(OrderItem c : items) {
			sum += c.subTotal();		
		}
		return sum;
	}
	
	@Override
	 public String toString() {
		StringBuilder sb = new StringBuilder(); // Objeto que se usa quando se tem que concatenar varias Strings. Sendo mais otimizada.
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n"); //função usada para fazer a formatação do modo como a Data será mostrada para o cliente.
		sb.append("Order Status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items : \n");
		for(OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price $");
		sb.append(String.format("%.2f",total())); // pode se usar formatação em uma StringBuider.
		return sb.toString();
	}
	
	

}
