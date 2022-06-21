package inicial.generics;

import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

public class ParesTreeSet<C extends Number,V> {

	private final SortedSet<ParComparable<C,V>> itens = new TreeSet<>();
	
	public void adicionar(C chave, V valor) {
		if(chave==null) return;
		ParComparable<C,V> novoPar = new ParComparable<C,V>(chave,valor);
		if (itens.contains(novoPar)) itens.remove(novoPar);
		itens.add(novoPar);
	}
	
	public V getValor(C chave) {
		if(chave==null) return null;
		Optional <ParComparable<C,V>> parOpcional = itens.stream().filter(par -> chave.equals(par.getChave())).findFirst();
		return parOpcional.isPresent() ? parOpcional.get().getValor() : null;
	}

	public SortedSet<ParComparable<C, V>> getItens() {
		return this.itens;
	}
	
	
}
