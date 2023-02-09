package Taller1;
import java.util.List;

public class Imperativo {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
		int count = 0;
		for (int i = 0; i<numbers.size(); i++) {
			if (numbers.get(i)>10) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
