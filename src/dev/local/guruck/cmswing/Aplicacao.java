package dev.local.guruck.cmswing;

import dev.local.guruck.cmswing.modelo.Tabuleiro;
//import dev.local.guruck.cmswing.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(3,3,9);
		tabuleiro.registrarObservador(e -> {
			if (e == true) {
				System.out.println("Vitoria");
			}else {
				System.out.println("Tente Novamente");
			}
		});
		tabuleiro.marcarCampo(0,0);
		tabuleiro.marcarCampo(0,1);
		tabuleiro.marcarCampo(0,2);
		tabuleiro.marcarCampo(1,0);
		tabuleiro.marcarCampo(1,1);
		tabuleiro.marcarCampo(1,2);
		tabuleiro.marcarCampo(2,0);
		tabuleiro.marcarCampo(2,1);
		tabuleiro.marcarCampo(2,2);
	}

}
