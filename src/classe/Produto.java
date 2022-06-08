package classe;


public class Produto {
	
	private String nome;
	private double preco;
	static private double desconto = 0.25;
	
	Produto(){
		
	}
	
	Produto (String nome, double preco){
		this.nome = nome;
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + ", desconto=" + desconto + ", valorFinal=" + this.calcValorFinal() + "]";
	}
	
	public double calcValorFinal() {
		if ((desconto > 1) || (desconto < 0) ) return 0;
		return Util.truncateTo(this.preco * (1 - desconto),2);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getDesconto() {
		return desconto;
	}

	static public void setDesconto(double desconto) {
		Produto.desconto = desconto;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Produto) {
			Produto outro = (Produto) obj;
			return outro.nome.equals(this.nome);
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		
		return this.nome.length();
	}
	
}
