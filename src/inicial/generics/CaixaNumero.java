package inicial.generics;


/*
 * Classe exemplo de generics
*/
public class CaixaNumero<N extends Number> extends Caixa<N> {

	private N coisa;
	
	public void guardar(N coisa) {
		this.coisa = coisa;
	}
	
	public N abrir() {
		return this.coisa;
	}

	
}
