package inicial.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//import java.util.function.Predicate;

public class MinMaxStreams {

	public static void main(String[] args) {
		
		//Predicate<Aluno> aprovado = a -> a.nota >=7;
		//Predicate<Aluno> reprovado = aprovado.negate();
		Comparator<Aluno> melhorNota = (a1,a2) -> {
			if(a1.nota > a2.nota) return 1;
			if(a1.nota < a2.nota) return -1;
			return 0;
		};
		
		List<Aluno> alunos = Arrays.asList(
				new Aluno("Ana",7.1),new Aluno("Bia",6.1),
				new Aluno("Daniel",8.1),new Aluno("Guilherme",10));
		
		System.out.println(alunos.stream().max(melhorNota).get());
		System.out.println(alunos.stream().min(melhorNota).get());
		
	}
}

