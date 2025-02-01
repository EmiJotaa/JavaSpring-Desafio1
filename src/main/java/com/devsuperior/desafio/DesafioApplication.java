package com.devsuperior.desafio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.desafio.entities.Order;
import com.devsuperior.desafio.services.OrderService;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner{
	
	 private final OrderService orderService;

	@Autowired
	public DesafioApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
		
        Order order1 = new Order(1034, 150.00, 20.0);
        displayTotalValue(order1);
        
        Order order2 = new Order(2282, 800.00, 10.0);
        displayTotalValue(order2);

        Order order3 = new Order(1309, 95.90, 0.0);
        displayTotalValue(order3);
    }

	private void displayTotalValue(Order order) {
        double totalValue = orderService.sumTotal(order);
        System.out.println("Pedido código " + order.getCode());
        System.out.println("Valor total: R$ " + String.format("%.2f", totalValue));
    }
}
