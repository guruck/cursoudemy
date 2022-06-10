package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MatchStreams {

	public static void main(String[] args) {
		
		Predicate<Aluno> aprovado = a -> a.nota >=7;
		Predicate<Aluno> reprovado = aprovado.negate();
		
		List<Aluno> alunos = Arrays.asList(
				new Aluno("Ana",7.1),new Aluno("Bia",6.1),
				new Aluno("Daniel",8.1),new Aluno("Guilherme",10));
		
		System.out.println(alunos.stream().allMatch(aprovado));
		System.out.println(alunos.stream().anyMatch(aprovado));
		System.out.println(alunos.stream().noneMatch(reprovado));
	}
}

