package inicial.generics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TesteCaixaInt {

	@Test
	void testeCaixaIntGenericaInteger() {
		CaixaInt caixa = new CaixaInt();
		caixa.guardar(3);
		assertTrue(caixa.abrir()==3);
	}
	@Test
	void testeCaixaIntGenericaInteger2() {
		CaixaInt caixa = new CaixaInt();
		caixa.guardar(5);
		assertTrue(caixa.abrir()==5);
	}

}
