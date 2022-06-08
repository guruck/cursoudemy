package lambda;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioLambda {
	
	public static void main(String[] args) {
		
		/*
		 * 1. A partir do calcular o preco real (com desconto)
		 * 2. Imposto Municipal: >= 2500 (8,5%)/ < 2500 (isento)
		 * 3. Frete: >= 3000 (100) / < 3000 (50)
		 * 4. Arredondar: Deixar duas casas decimais
		 * 5. Formatar: R$1234,56
		 * */
		Function<Produto, Double> precoComDesconto = prod -> prod.preco * (1 - prod.desconto);
		UnaryOperator<Double> impostoMunicipal = valor -> (valor >= 2500)  ? (valor * 1.085) : valor;
		UnaryOperator<Double> frete = valor -> (valor >= 3000)  ? (valor + 100) : (valor+50);
		UnaryOperator<Double> arredondar = num -> (double)Math.round(num*100)/100;
		Function<Double, String> formatar = num -> String.format("%s%.2f", "R$", num).replace(".",",");
		
		Produto apple = new Produto("iPad", 3235.89, 0.13);
		String preco = precoComDesconto
				.andThen(impostoMunicipal)
				.andThen(frete)
				.andThen(arredondar)
				.andThen(formatar)
				.apply(apple);
		System.out.println("O preço final é: "+ preco);
		
	}
		
}
