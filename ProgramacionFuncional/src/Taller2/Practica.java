package Taller2;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Practica {

	public static void main(String[] args) {
		List<Product> shopping = List.of(
                new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
                new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
                new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
                new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
                new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
                new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL));
		
			
		// Coste total de compra incluyendo impuestos //
		
		// El método map o mapTo"x" transforma el stream en una lista del elemento especificado
		double sum = shopping.stream().mapToDouble( 
					n -> n.getPrice().doubleValue() + (n.getTax().getPercent() * n.getPrice().doubleValue()/100)					
				).sum();
		
		// Lista de productos que empiezan con la letra c //
		String productos= shopping.stream().filter(p -> p.getName().startsWith("C")).map(x -> x.getName()).collect(Collectors.joining(", ", "Products starts with C are ", "."));
		
		System.out.println("El precio total es: " + sum);
		
		System.out.println(productos);

	}

}
