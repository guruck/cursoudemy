package dev.local.guruck.calc.model;

@FunctionalInterface
public interface MemoriaObservador {
	void valorAlterado(String novoValor);
}
