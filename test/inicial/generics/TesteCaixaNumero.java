package inicial.generics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TesteCaixaNumero {

	@Test
	void testeCaixaNumeroGenericaInteger() {
		CaixaNumero<Integer> caixa = new CaixaNumero<>();
		caixa.guardar(3);
		assertTrue(caixa.abrir()==3);
	}
	@Test
	void testeCaixaNumeroGenericaInteger2() {
		CaixaNumero<Integer> caixa = new CaixaNumero<>();
		caixa.guardar(5);
		assertTrue(caixa.abrir()==5);
	}
	@Test
	void testeCaixaNumeroGenericaDouble() {
		CaixaNumero<Double> caixa = new CaixaNumero<>();
		caixa.guardar(2.3);
		assertTrue(caixa.abrir()==2.3);
	}
}
