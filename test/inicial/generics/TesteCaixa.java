package inicial.generics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TesteCaixa {

	@Test
	void testeCaixaGenericaDouble() {
		Caixa<Double> caixa = new Caixa<>();
		caixa.guardar(2.3);
		assertTrue(caixa.abrir()==2.3);
	}
	@Test
	void testeCaixaGenericaString() {
		Caixa<String> caixa = new Caixa<>();
		caixa.guardar("Olá!"); 
		assertTrue("Olá!".equals(caixa.abrir()));
	}
}
