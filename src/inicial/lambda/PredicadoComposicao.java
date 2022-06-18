package inicial.lambda;

import java.util.function.Predicate;

public class PredicadoComposicao {

	public static void main(String[] args) {

		Predicate<Integer> isPar = num -> num % 2 == 0;
		Predicate<Integer> isTresDigitos = num -> num >=100 && num <= 999;
		
		System.out.println("123 é par e tem 3 digitos : "+ isPar.and(isTresDigitos).test(123));
		System.out.println("123 é par ou tem 3 digitos : "+ isPar.or(isTresDigitos).test(123));
	}

}
