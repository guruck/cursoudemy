package inicial.generics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.SortedSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteParesTreeSet {

	ParesTreeSet<Integer, String> resConcurso = new ParesTreeSet<>();
	
	@BeforeEach
	void iniciarParesTreeSet() {
		resConcurso.adicionar(2, "Jonas");
		resConcurso.adicionar(4, "Clara");
		resConcurso.adicionar(1, "Maria");
		resConcurso.adicionar(3, "Joao");
		resConcurso.adicionar(2, "Bernardo");		
	}
	@Test
	void testeGetValor() {
		assertTrue("Bernardo".equals(resConcurso.getValor(2)));
	}
	
	@Test
	void testeGetItens() {
		SortedSet<ParComparable<Integer,String>> itens = resConcurso.getItens();
		boolean result = true;
		for(ParComparable<Integer,String> par : itens) {
			result = result && par.getValor().equals(resConcurso.getValor(par.getChave()));
		}
		assertTrue(result);
	}

}
