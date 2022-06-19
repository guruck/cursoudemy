package dev.local.guruck.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import dev.local.guruck.cm.excecao.ExplosaoException;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private int minas;
	
	private final List<Campo> campos = new ArrayList<>();

	public Tabuleiro(int linhas, int colunas, int minas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
		
		gerarCampos();
		associarVizinhos();
		sortearMinas();
	}

	
	private void gerarCampos() {
		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				this.campos.add(new Campo(linha,coluna));
			}
		}
	}
	
	private void associarVizinhos() {
		for (Campo campo1: this.campos) {
			for (Campo campo2: this.campos) {
				campo1.adicionarVisinho(campo2);
			}
		}
	}
	
	private void sortearMinas() {
		long minasArmadas = 0;
		Predicate<Campo> minado = c -> c.isMinado();
		do {
			int aleatorio = (int)(Math.random() * campos.size());
			campos.get(aleatorio).minar();
			minasArmadas = this.campos.stream().filter(minado).count();
		} while (minasArmadas < this.minas);
	}
	
	public boolean ojetivoAlcancado() {
		return campos.stream().allMatch(c -> c.ojetivoAlcancado());
	}
	
	public void reiniciar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearMinas();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" ");
		for (int coluna = 0; coluna < colunas; coluna++) {
			sb.append(" ");
			sb.append(coluna);
			sb.append(" ");
		}
		sb.append("\n");
		
		int i = 0;
		for (int linha = 0; linha < linhas; linha++) {
			sb.append(linha);
			for (int coluna = 0; coluna < colunas; coluna++) {
				sb.append(" ");
				sb.append(campos.get(i++));
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void abrirCampo(int linha, int coluna) {
		try {
			campos.parallelStream().filter(c -> c.getLinha()==linha && c.getColuna()==coluna).findFirst().ifPresent(c -> c.abrir());
		} catch (ExplosaoException e) {
			campos.forEach(c -> c.setAberto(true));
			throw e;
		}
	}
	
	public void marcarCampo(int linha, int coluna) {
		campos.parallelStream().filter(c -> c.getLinha()==linha && c.getColuna()==coluna).findFirst().ifPresent(c -> c.alternarMarcacao());
	}
	
}
