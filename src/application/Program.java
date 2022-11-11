package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrderItem;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter fmt2 = new DateTimeFormatter("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
		
		System.out.println("Enter Cliente Data: ");
		System.out.print("Name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("BirtH Date (DD/MM/YYYY) :");
		Date birthDate = fmt1.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		LocalDateTime moment = LocalDateTime.now();
		
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
			OrderItem item = new OrderItem( quantity, product.getPrice());
		}
		
		System.out.println();
		
		
		
		
		
		
		
		
		
		sc.close();

	}

}
