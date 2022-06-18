package inicial.streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ImprimirObjetos {

	public static void main(String[] args) {
		List<String> aprovados = Arrays.asList("Ana","Bia","Lia","Gui");
		
		// For simples: pode controlar quais elementos quer percorrer
		System.out.println("##    For simples ######");
		for (int i = 0; i < aprovados.size(); i++) {
			System.out.print(aprovados.get(i) + " ");
		}
		
		// ForEach: obrigatorio percorrer todos os elementos se não houver um break
		System.out.println("\n\n##    ForEach     ######");
		for (String aprovado : aprovados) {
			System.out.print(aprovado + " ");
		}
		
		// Iterator: obrigatorio percorrer todos os elementos se não houver um break
		System.out.println("\n\n##    Iterator    ######");
		Iterator<String> iterator = aprovados.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+ " ");
		}
		
		// Stream: obrigatorio percorrer todos os elementos se não houver condição/filtro
		System.out.println("\n\n##    Stream      ######");
		Stream<String> stream = aprovados.stream();
		stream.map(m -> m + " ").forEach(System.out::print); //laço interno

		// Stream: obrigatorio percorrer todos os elementos se não houver condição/filtro
		System.out.println("\n\n##    Stream //   ######");
		Stream<String> streamParalela = aprovados.parallelStream();
		streamParalela.map(m -> m + " ").forEach(System.out::print); //laço interno
		
		
	}
}
