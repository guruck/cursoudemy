package oo.composicao;

public class Carro {

	Motor motor = new Motor();
	
	void acelerar() {
		motor.fatorInjecao += 0.4;
	}
	
	void frear() {
		motor.fatorInjecao -= 0.4;
	}
	
	void ligar() {
		motor.ligado = true;
		motor.fatorInjecao += 0.4;
	}
	
	void desligar() {
		motor.ligado = false;
		motor.fatorInjecao =0;
	}
	
	boolean estaLigado() {
		return motor.ligado;
	}
}
