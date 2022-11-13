package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException { // usa-se o throws ParseException por que pode dar algo erado quando for se ler a data.
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy"); // mascara de formatação de como a data será lida no caso a data do nascimento do cliente.
		
		
		
		System.out.println("Enter Cliente Data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("BirtH Date (DD/MM/YYYY) :");
		Date birthDate = fmt1.parse(sc.next());
		
		Client client = new Client(name, email, birthDate); // construtor da classe Client.
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next()); // Modo como se converte um tipo String para enumerado. 
		Order order = new Order(new Date (), status, client); // o new Date() pega a hora e data do sistema na hora. instanciando um objeto order.
		
		System.out.print("How many items to this order: ");
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.println("Enter #"+i+" item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quatity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem item = new OrderItem( quantity, productPrice, product); // contrutor da classe OrderItem que faz ela apontar para a classe Product
			
			order.addItem(item); // funçao para adicionar na lista o objeto da classe OrderItem. A classe Order tem uma lista de OrderItem ela aponta para  ela, e por sua vez aponta para a classe Product.
		}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();

	}

}
