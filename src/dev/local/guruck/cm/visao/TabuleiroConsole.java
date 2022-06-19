package dev.local.guruck.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import dev.local.guruck.cm.excecao.ExplosaoException;
import dev.local.guruck.cm.excecao.SairException;
import dev.local.guruck.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);
	
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			while(continuar) {
				cicloDoJogo();
				System.out.println("Outra partida?(S/n)");
				String resposta = entrada.nextLine();
				
				if ("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				}else{
					tabuleiro.reiniciar();
				};
			}
		} catch (SairException e) {
			System.out.println("Bye!!!");
		}finally {
			entrada.close();
		}
		
	}

	private void cicloDoJogo() {
		try {
			while(!tabuleiro.ojetivoAlcancado()) {
				System.out.println(tabuleiro);

				String digitado = capturarValorDigitado("Digite as coordenadas(x,y):");
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
						.map(e -> Integer.parseInt(e.trim())).iterator();
				
				digitado = capturarValorDigitado("\n1- Abrir ou 2-(Des)Marcar");
				if("1".equals(digitado)) {
					tabuleiro.abrirCampo(xy.next(), xy.next());
				}else if("2".equals(digitado)) {
					tabuleiro.marcarCampo(xy.next(), xy.next());
				}
			}
			System.out.println("Bela Vitória!!!");
			System.out.println(tabuleiro);
		} catch (ExplosaoException e) {
			System.out.println("Perdeu Playboy!!!");
			System.out.println(tabuleiro);
		}
	}
	
	public String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		return digitado;
	}
}
