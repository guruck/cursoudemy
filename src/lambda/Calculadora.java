package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Calculadora {

	public static void main(String[] args) {
		
		//normal
		Calculo operacao = new Somar();
		System.out.println(operacao.executar(3, 2));
		
		operacao = new Multiplicar();
		System.out.println(operacao.executar(3, 2));

		//lambda
		Calculo subtrair = (x,y) -> x - y;
		System.out.println(subtrair.executar(3, 2));
		
		Calculo.printIssoAqui(subtrair.valor());
		
		//lambda2
		BinaryOperator<Double> dividir = (x,y) -> x/y;
		System.out.println(dividir.apply(50.0, 4.0));
		
		BinaryOperator<String> concat = (x,y) -> x + " Ferreira " + y;
		System.out.println(concat.apply("Tiago","Rodrigues"));
		
		//lambda3
		List<String> aprovados = Arrays.asList("Ana", "Bia", "Lia", "Gui");
		//Method Reference...
		aprovados.forEach(Calculadora::imprime);
	}
	
	public static void imprime(String valor) {
		System.out.println(valor + "!!!");
	}
	
	/**
	 * Entrada -> Retorno | Nome
	 * nada -> T    | Supplier
	 * T -> nada    | Consumer
	 * T -> T       | Unary Operator
	 * T,T -> T     | Binary Operator
	 * S -> T       | Functio
	 * T -> Boolean | Predicate
	 */
	

}
