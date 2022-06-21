package inicial.generics;

public class ParComparable<C,V> implements Comparable<ParComparable<C,V>>{

	private C chave;
	private V valor;
	
	public ParComparable(C chave, V valor) {
		super();
		this.chave = chave;
		this.valor = valor;
	}
	
	public C getChave() {
		return chave;
	}
	public void setChave(C chave) {
		this.chave = chave;
	}
	public V getValor() {
		return valor;
	}
	public void setValor(V valor) {
		this.valor = valor;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chave == null) ? 0 : chave.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParComparable<?, ?> other = (ParComparable<?, ?>) obj;
		if (chave == null) {
			if (other.chave != null)
				return false;
		} else if (!chave.equals(other.chave))
			return false;
		return true;
	}

	@Override
	public int compareTo(ParComparable<C, V> par) {
		String tipoChave = this.getChave().getClass().getSimpleName();
		if ("integer".equalsIgnoreCase(tipoChave)) {
			if ((Integer)par.getChave() > (Integer)this.getChave()) return -1;
			if ((Integer)par.getChave() < (Integer)this.getChave()) return 1;
		}
		return 0;
	}

	
}
