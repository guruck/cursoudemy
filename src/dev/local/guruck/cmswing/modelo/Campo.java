package dev.local.guruck.cmswing.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class Campo {

	private final int linha;
	private final int coluna;
	
	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;
	
	private List<Campo> vizinhos = new ArrayList<>();
	private List<ObservadorCampo> observadores = new ArrayList<>();
	@SuppressWarnings("unused")
	private List<BiConsumer<Campo ,EventoCampo>> observadores2 = new ArrayList<>();
	
	Campo(int linha, int coluna) {
		super();
		this.linha = linha;
		this.coluna = coluna;
	}
	public void registrarObservador(ObservadorCampo observador) {
		this.observadores.add(observador);
	}
	private void notificarObservadores(EventoCampo evento) {
		observadores.stream().forEach(o->o.eventoOcorreu(this, evento));
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
		if (this.aberto) notificarObservadores(EventoCampo.ABRIR);
	}
	public boolean isFechado() {
		return !isAberto();
	}
	public void alternarMarcacao() {
		if(!this.aberto) {
			this.marcado = !this.marcado;
			if(this.marcado) {
				notificarObservadores(EventoCampo.MARCAR);
			}else {
				notificarObservadores(EventoCampo.DESMARCAR);
			}
		}
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
	
	public boolean abrir() {
		if (!this.aberto && !this.marcado) {
			if (this.minado) {
				notificarObservadores(EventoCampo.EXPLODIR);
				return true;
			}
			setAberto(true);
			
			if (vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		}else {
			return false;
		}
	}
	
	public boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	boolean ojetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		return desvendado || protegido;
	}
	
	public int minasNaVizinhanca() {
		return (int)vizinhos.stream().filter(v -> v.minado).count();
	}
	
	void reiniciar() {
		this.aberto = false;
		this.minado = false;
		this.marcado = false;
		notificarObservadores(EventoCampo.REINICIAR);
	}


	
}
