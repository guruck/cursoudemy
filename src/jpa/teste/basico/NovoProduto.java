package jpa.teste.basico;

import jpa.model.basico.Produto;
import jpa.model.infra.DAO;
public class NovoProduto {

	public static void main(String[] args) {
		
		//Produto novo = new Produto("Caneta",2.50);
		//DAO<Produto> dao = new DAO<>(Produto.class);
		//dao.includeAtomic(novo).close();
		
//		Produto lapiseira = new Produto("Lapiseira",5.35);
//		Produto caderno = new Produto("caderno",14.65);
//		Produto mochila = new Produto("mochila",99.95);
//		Produto prancheta = new Produto("prancheta",3.50);
//		Produto regua = new Produto("regua",1.25);
//		Produto borracha = new Produto("borracha",2.50);
		DAO<Produto> dao = new DAO<>(Produto.class);
//		dao.openTransaction()
//			.include(lapiseira)
//			.include(caderno)
//			.include(mochila)
//			.include(prancheta)
//			.include(regua)
//			.include(borracha)
//			.closeTransaction().close();
		dao.getAll().forEach(System.out::println);
		dao.close();
	}

}
