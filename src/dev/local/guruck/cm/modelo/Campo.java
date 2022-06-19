package dev.local.guruck.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import dev.local.guruck.cm.excecao.ExplosaoException;

public class Campo {

	private final int linha;
	private final int coluna;
	
	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;
	
	private List<Campo> vizinhos = new ArrayList<>();
	
	Campo(int linha, int coluna) {
		super();
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	public boolean isMinado() {
		return this.minado;
	}
	public boolean isMarcado() {
		return this.marcado;
	}
	public boolean isAberto() {
		return this.aberto;
	}
	void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	public boolean isFechado() {
		return !isAberto();
	}
	void alternarMarcacao() {
		if(!this.aberto) this.marcado = !this.marcado;
	}
	void minar() {
		this.minado = true;
	}
	boolean adicionarVisinho(Campo vizinho) {
		
		boolean linhaDiferente = this.linha != vizinho.linha;
		boolean colunaDiferente = this.coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(this.linha - vizinho.linha);
		int deltaColuna = Math.abs(this.coluna - vizinho.coluna);
		int deltaGeral = deltaLinha + deltaColuna;
		
		if ((deltaGeral == 1 && !diagonal) || (deltaGeral == 2 && diagonal)) {
			this.vizinhos.add(vizinho);
			return true;
		}else {
			return false;
		}
	}
	
	boolean abrir() {
		if (!this.aberto && !this.marcado) {
			this.aberto = true;
			
			if (this.minado) {
				throw new ExplosaoException();
			}
			
			if (vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		}else {
			return false;
		}
	}
	
	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	boolean ojetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		return desvendado || protegido;
	}
	
	long minasNaVizinhanca() {
		return vizinhos.stream().filter(v -> v.minado).count();
	}
	
	void reiniciar() {
		this.aberto = false;
		this.minado = false;
		this.marcado = false;
	}

	@Override
	public String toString() {
		if (this.marcado) {
			return "§";
		}else if (this.aberto && this.minado) {
			return "*";
		}else if (this.aberto && this.minasNaVizinhanca() > 0) {
			return Long.toString(this.minasNaVizinhanca());
		}else if (this.aberto) {
			return " ";
		}else {
			return "?";
		}
	}
	
	
}
