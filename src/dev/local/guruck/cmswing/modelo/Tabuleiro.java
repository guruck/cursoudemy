package dev.local.guruck.cmswing.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Tabuleiro implements ObservadorCampo{

	private int linhas;
	private int colunas;
	private int minas;
	
	private final List<Campo> campos = new ArrayList<>();
	private List<Consumer<Boolean>> observadores = new ArrayList<>();
	
	public Tabuleiro(int linhas, int colunas, int minas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
		
		gerarCampos();
		associarVizinhos();
		sortearMinas();
	}
	public void setMinas(int minas) {
		this.minas = minas;
	}
	public void forEachCampo(Consumer<Campo> function) {
		campos.forEach(function);
	}
	public void registrarObservador(Consumer<Boolean> observador) {
		this.observadores.add(observador);
	}
	private void notificarObservadores(boolean resultado) {
		observadores.stream().forEach(o->o.accept(resultado));
	}
	private void gerarCampos() {
		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				Campo campo = new Campo(linha,coluna);
				campo.registrarObservador(this);
				this.campos.add(campo);
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
	
	public void abrirCampo(int linha, int coluna) {
		campos.parallelStream().filter(c -> c.getLinha()==linha && c.getColuna()==coluna).findFirst().ifPresent(c -> c.abrir());
	}
	
	private void mostrarMinas() {
		campos.parallelStream()
		.filter(c -> c.isMinado()).forEach(c -> c.setAberto(true));
	}
	
	public void marcarCampo(int linha, int coluna) {
		campos.parallelStream().filter(c -> c.getLinha()==linha && c.getColuna()==coluna).findFirst().ifPresent(c -> c.alternarMarcacao());
	}


	@Override
	public void eventoOcorreu(Campo campo, EventoCampo evento) {
		if(evento == EventoCampo.EXPLODIR) {
			mostrarMinas();
			notificarObservadores(false);
		}else if(ojetivoAlcancado()) {
			notificarObservadores(true);
		}
		
	}

	public int getColunas() {
		return this.colunas;
	}
	
	public int getLinhas() {
		return this.linhas;
	}
}
