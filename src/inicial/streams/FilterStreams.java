package inicial.streams;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterStreams {

	public static void main(String[] args) {
		
//		List<String> aprovados = Arrays.asList("Ana ","Bia ","Lia ","Gui\n");
//		aprovados.stream().filter(ap -> ap.charAt(0)=='A' ).forEach(Utils.print);

		Aluno a1 = new Aluno("Ana",7.8); 
		Aluno a2 = new Aluno("Bia",5.8); 
		Aluno a3 = new Aluno("Daniel",9.8); 
		Aluno a4 = new Aluno("Guilherme",6.8); 
		Aluno a5 = new Aluno("Rebeca",7.1); 
		Aluno a6 = new Aluno("Pedro",8.8); 
		 
		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4,a5,a6);
		Predicate<Aluno> aprovado = a -> a.nota >=7;
		Function<Aluno, String> saudacao = a -> "Parab�ns "+ a.nome + "! Voc� foi aprovado(a)!";
		
		alunos.stream()
			.filter(aprovado)
			.map(saudacao)
			.forEach(System.out::println);
		
		System.out.println("-----------");
		alunos.stream()
		.filter(a -> a.nota >=7)
		.map(a -> "Parab�ns "+ a.nome + "! Voc� foi aprovado(a)!")
		.forEach(System.out::println);
	}
}

