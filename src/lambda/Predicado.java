package lambda;

import java.util.function.Predicate;

public class Predicado {

	public static void main(String[] args) {

		Predicate<Produto> isCaro = prod -> (prod.preco *( 1-prod.desconto )) >= 750.00;
		Produto p1 = new Produto("Note",3893.89, 0.85);
		System.out.println(isCaro.test(p1));
		
	}

}
