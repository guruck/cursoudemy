package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class OutrosStreams {

	public static void main(String[] args) {
		
		Predicate<Aluno> aprovado = a -> a.nota >=7;
		//Predicate<Aluno> reprovado = aprovado.negate();
		Comparator<Aluno> melhorNota = (a1,a2) -> {
			if(a1.nota > a2.nota) return 1;
			if(a1.nota < a2.nota) return -1;
			return 0;
		};
		
		List<Aluno> alunos = Arrays.asList(
				new Aluno("Ana",7.1),new Aluno("Bia",6.1),
				new Aluno("Ana",7.1),new Aluno("Joana",6.1),
				new Aluno("Pedro",8.1),new Aluno("Guilherme",10),
				new Aluno("Daniel",8.1),new Aluno("Guilherme",10,false)
		);
		
		System.out.println(alunos.stream().max(melhorNota).get());
		
		System.out.println("distinct");
		alunos.stream().distinct().forEach(System.out::println);;
		
		System.out.println("\nSkip/Limit");
		alunos.stream().distinct().skip(2).limit(2).forEach(System.out::println);;
		
		System.out.println("\nTake/While");
		alunos.stream().distinct().skip(3).takeWhile(aprovado).forEach(System.out::println);;
		
	}
}

