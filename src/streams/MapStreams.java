package streams;


import java.util.Arrays;
import java.util.List;

public class MapStreams {

	public static void main(String[] args) {
		
		List<String> aprovados = Arrays.asList("Ana ","Bia ","Lia ","Gui\n");

		aprovados.stream().map(ap -> ap.toUpperCase()).forEach(Utils.print);

		System.out.println(Utils.maiuscula.andThen(Utils.primeiraLetra).andThen(Utils::grito).apply("Teste"));

		//usando composição
		aprovados.stream().map(Utils.maiuscula).forEach(Utils.print);
		aprovados.stream().map(Utils.maiuscula.andThen(Utils.primeiraLetra)).forEach(Utils.print);
		aprovados.stream().map(Utils.maiuscula.andThen(Utils::grito)).forEach(Utils.print);
	}
}

