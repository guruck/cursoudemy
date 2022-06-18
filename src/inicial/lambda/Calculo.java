package inicial.lambda;

/**
 * 
 * @author guruck
 *
 * @description interface funcional apenas tem 1 único metodo abstrato.
 * 
 */

@FunctionalInterface
public interface Calculo {
	
	public abstract double executar(double a, double b);
	
	private double teste() {
		return 0;
	}
	
	default String valor() {
		return "O valor é " + teste();
	}
	
	static void printIssoAqui(String valor) {
		System.out.println("e agora? " + ((valor != null) ? valor : ""));
	}
}
