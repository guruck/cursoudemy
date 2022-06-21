package inicial.generics;


/*
 * Classe exemplo de não generics
*/
public class CaixaObjeto {

	private Object coisa;
	
	public void guardar(Object coisa) {
		this.coisa = coisa;
	}
	
	public Object abrir() {
		return this.coisa;
	}

	
}
