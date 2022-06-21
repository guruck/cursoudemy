package inicial.generics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestePares {

	Pares<Integer, String> resConcurso = new Pares<>();
	@BeforeEach
	void iniciarPares() {
		resConcurso.adicionar(1, "Maria");
		resConcurso.adicionar(2, "Jonas");
		resConcurso.adicionar(3, "Joao");
		resConcurso.adicionar(4, "Clara");
		resConcurso.adicionar(2, "Bernardo");
	}
	
	@Test
	void testeGetValor() {
		assertTrue("Bernardo".equals(resConcurso.getValor(2)));
	}
}
