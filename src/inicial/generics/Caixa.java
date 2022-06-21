package inicial.generics;


/*
 * Classe exemplo de generics
*/
public class Caixa<T> {

	private T coisa;
	
	public void guardar(T coisa) {
		this.coisa = coisa;
	}
	
	public T abrir() {
		return this.coisa;
	}

	
}
