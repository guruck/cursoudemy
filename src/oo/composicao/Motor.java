package oo.composicao;

public class Motor {

	boolean ligado = false;
	double fatorInjecao = 1;
	
	int giros() {
		if (!ligado) return 0;
		return (int) Math.round(this.fatorInjecao * 3000);
	}
	
	public Motor() {
		super();
	};
	
	public Motor(double fatorInjecao) {
		this.fatorInjecao = fatorInjecao;
	}
	
}
