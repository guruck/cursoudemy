package inicial.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DesafioFiltro {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		Predicate<Integer> isPar = n -> n%2==0;
		Predicate<Integer> isImpar = n -> n%2!=0;
		
		Predicate<Integer> isPrimo = n -> {
			int aux = 0;
			for(int i = 1;i<=n;i++) {
				if (n%i==0) aux++;
			}
			return (aux==2);
		};
		
		nums.stream()
			.filter(isPrimo.and(isImpar)).map(n -> n)
			.forEach(System.out::println);
		
		nums.stream()
		.filter(isPar)
		.forEach(System.out::println);
	}

}
