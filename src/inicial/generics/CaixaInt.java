package inicial.generics;


/*
 * Classe exemplo de generics
*/
public class CaixaInt extends Caixa<Integer> {

	private Integer coisa;
	
	public void guardar(Integer coisa) {
		this.coisa = coisa;
	}
	
	public Integer abrir() {
		return this.coisa;
	}

	
}
