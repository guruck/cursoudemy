package inicial.streams;


import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ReduceStreams {

	public static void main(String[] args) {
		
		Predicate<Integer> isPar = n -> n%2==0;
		Predicate<Integer> isImpar = n -> n%2!=0;
		Predicate<Integer> isPrimo = n -> {
			int aux = 0;
			for(int i = 1;i<=n;i++) {
				if (n%i==0) aux++;
			}
			return (aux==2);
		};
		Predicate<Aluno> aprovado = a -> a.nota >=7;
		BinaryOperator<Double> somatorio = (a,n) -> a+n;
		BinaryOperator<Media> combinatorio = (m1,m2) -> Media.combinar(m1, m2);
		BinaryOperator<Integer> soma = (ac,n) -> ac+n;
		Function<Aluno, Double> getNota = a -> a.nota;
		BiFunction<Media, Double, Media> calcularMedia = (media,nota) -> media.adiciona(nota);
		Consumer<Integer> printTotal = s-> 
				System.out.println(" = "+s);
		
		Function<Double, String> formatar = num -> String.format("%.2f", num).replace(".",",");		
	
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		nums.stream()
			.filter(isPrimo.and(isImpar)).map(n -> " +" + n)
			.forEach(Utils.print);
		
		nums.stream().filter(isImpar.and(isPrimo)).reduce(soma).ifPresent(printTotal);
		System.out.println(nums.stream().filter(isPar).reduce(soma).get());
		System.out.println("============");
		
		List<Aluno> alunos = Arrays.asList(
				new Aluno("Ana",7.1),new Aluno("Bia",6.1),
				new Aluno("Daniel",8.1),new Aluno("Guilherme",10));
		
		alunos.parallelStream().filter(aprovado).map(getNota)
			.reduce(somatorio).ifPresent(System.out::println);
		
		System.out.println("============");
		Media m1 = new Media().adiciona(8.3).adiciona(6.7);
		Media m2 = new Media().adiciona(7.9).adiciona(6.6);
		
		System.out.println(m1.getMedia());
		System.out.println(m2.getMedia());
		
		System.out.println(Media.combinar(m1, m2).getMedia());
		System.out.println("..............");
		alunos.parallelStream()
			//.filter(aprovado)
			.map(getNota)
			.reduce(new Media(),calcularMedia,combinatorio)
			.ifPresent(formatar);
	}
}

