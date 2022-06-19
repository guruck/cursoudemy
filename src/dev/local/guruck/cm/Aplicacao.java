package dev.local.guruck.cm;

import dev.local.guruck.cm.modelo.Tabuleiro;
import dev.local.guruck.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,2);
		new TabuleiroConsole(tabuleiro);

	}

}
