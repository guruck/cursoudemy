package inicial.classe;

public class ProdutoTeste {

	public static void main(String[] args) {
		
		Produto p1 = new Produto();
		p1.setNome("Notebook");
		p1.setPreco(4356.89);
		System.out.println(p1.toString());
		
		Produto.setDesconto(0.15);
		Produto p2 = new Produto("Mamadeira", 50.99);
		System.out.println(p2.toString());
		System.out.println(p1.toString());
	}

}
