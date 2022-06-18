package inicial.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumidor {

	public static void main(String[] args) {

		Consumer<Produto> imprimir = p -> System.out.println(p.nome + "!!");
		
		Produto p1 = new Produto("Caneta", 12.34, 0.09);
		imprimir.accept(p1);
		
		Produto p2 = new Produto("Notebook", 1982.34, 0.19);
		Produto p3 = new Produto("Caderno", 12.34, 0.09);
		Produto p4 = new Produto("Borracha", 7.34, 0.05);
		Produto p5 = new Produto("Lapis", 4.34, 0.02);
		
		List<Produto> produtos = Arrays.asList(p1,p2,p3,p4,p5);
		
		produtos.forEach(imprimir);
		produtos.forEach(System.out::println);
		produtos.forEach(p -> System.out.println(p.preco));
	}

}
