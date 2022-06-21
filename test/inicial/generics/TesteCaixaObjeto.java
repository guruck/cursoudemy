package inicial.generics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TesteCaixaObjeto {

	@Test
	void testeCaixaObjetoGenericaDouble() {
		CaixaObjeto caixa = new CaixaObjeto();
		caixa.guardar(3.6);
		assertTrue((Double)caixa.abrir()==3.6);
	}
	@Test
	void testeCaixaObjetoGenericaString() {
		CaixaObjeto caixa = new CaixaObjeto();
		caixa.guardar("Ola!:)");
		assertTrue("Ola!:)".equals((String)caixa.abrir()));
	}
}
