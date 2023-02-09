import java.util.List;

public class Funcional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
		
		// La función stream es una función que itera cada uno de los elementos de nuestra lista y genera una nueva.
		
		// La función filter nos filtra cada uno de los elementos de esa lista en base a una expresión booleana
		// esta expresión las definimos con una expresión lamda
		
		// Finalmente, con la función count nos devuelve el tamaó de la lista de stream.
		Long cuenta = numbers.stream().filter(num -> num>10).count();
		
		System.out.println(cuenta);

	}

}
