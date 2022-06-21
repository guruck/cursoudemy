package inicial.generics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TesteListaUtil {
	
	List<String> lista = Arrays.asList("Java", "C#", "GO", "PHP");

	@Test
	void testeGetUltimo() {
		assertTrue("PHP".equals(ListaUtil.getUltimo(lista)));
	}
}
